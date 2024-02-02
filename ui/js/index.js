// // function add(a, b, ...args) {
// //     console.log(a, b, ...args);
// // }

// // add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// // function myFun(a, b=10) {
// //     return a + b;
// // }

// // console.log(myFun(1));

// // myfun = (a, b) => {console.log(a + b);}
// // myfun(2, 4);

// const obj = {
//     username: "Admin",
//     password: "password",
//     greet: (username) => {console.log("Hello " + username)}
// };

// //obj.greet(obj.username);
// //obj.username = "new user";

// // obj = {
// //     firstname: "prithvi",
// //     lastname: "raj"
// // };

// // console.log(obj.firstname);

// let User = {
//     firstname: "user",
//     lastname: "one",
//     password: "password"
// };

// User.greet = (name) => {
//     console.log("Hello " + name);
// }

// User.greet(User.firstname);

// function Person(firstname, lastname) {
//     this.firstname = firstname;
//     this.lastname = lastname;
// }

// Person.prototype.getFullName = function() {
//     return this.firstname + " " + this.lastname;
// }

// let person = new Person("first", "last");
// console.log(person.getFullName());
// // console.log(Person("Prithvi", "Raj"));


// classes
class Person {
    constructor(firstname, lastname) {
        this._firstname = firstname;
        this._lastname = lastname;
    }

    get firstName() {
        return this._firstname;
    }

    set firstName(firstname) {
        this._firstname = firstname;
    }

    getFullName() {
        return this._firstname + " " + this._lastname;
    }

}

let person = new Person("first", "last");

console.log(person.firstName);