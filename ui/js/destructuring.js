class NotFoundError extends Error { 
    constructor(message) {
        super(message);
    }
}

let info = ['this', 'is', 'a', 'sample', 'string'];
//let x = info[0];
// let[a,,,b] = info;
let[, b, ...args] = info
console.log(info);
let err = {name: "NotFoundError", message:"Variable not found"};

try {
    // console.log(a);

    if (typeof(a) == "undefined") {
       // alert("In if");
        throw new NotFoundError("Variable not found");
    } else {
        console.log(a);
    }
    
} catch(error) {

    console.log(error.message);
} finally {
    console.log(b);
    console.log(args);
}


// let person = {
//     firstname: 'John',
//     lastname: 'Doe'
// };

// let {firstname: fname, lastname: lname} = person;
// console.log(fname);

// class Employee {
//     constructor(empId, empName) {
//         this.empId = empId;
//         this.empName = empName;
//     }

//     work() {
//         console.log("I am an employee. I am working");
//     }
// }

// let employee = new Employee(101, "employee 1");
// let {empId: id, empName: empname} = employee;

// console.log(employee);
// console.log(`${id}`);
// console.log(empname);


