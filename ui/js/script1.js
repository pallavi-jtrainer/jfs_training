/*
before ES6 
*/
// function Employee(empId, empName) {
//     this.empId = empId;
//     this.empName = empName;
// }

// Employee.prototype.work = () => {
//     console.log("I am an employee. I am working");
// }

// function Manager(desgination) {
//     this.desgination = desgination;
// }

// Manager.prototype = Object.create(Employee.prototype);
// Manager.prototype.constructor = Employee;

// Manager.prototype.work = () => {
//     console.log("I am a manager. I am working");
// }

// let e1 = new Manager();

//ES6 syntax`

class Employee {
    constructor(empId, empName) {
        this.empId = empId;
        this.empName = empName;
    }

    work() {
        console.log("I am an employee. I am working");
    }
}

class Manager extends Employee {
    constructor(empId, empName, designation) {
        super(empId, empName);
        this.designation = designation;
    }

    manage() {
        console.log("I am a manager. I manage");
    }

    managerDetails() {
        console.log(this.empId + " " + this.empName + " " + this.designation);
    }
}

let manager = new Manager(101, "Employee 1", "Manager");
manager.work();
manager.managerDetails();