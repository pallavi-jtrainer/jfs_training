"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var derived_1 = require("./derived");
var employees = [
    new derived_1.Employee(101, "John", "john@asa", 24, "developer"),
    new derived_1.Employee(102, "Jane", "jane@asa", 25, "developer"),
    new derived_1.Employee(103, "Jonah", "jonah@asa", 24, "tester"),
    new derived_1.Employee(104, "Jenny", "jenny@asa", 27, "tester"),
    new derived_1.Employee(105, "Joanne", "joanne@asa", 24, "developer"),
    new derived_1.Employee(106, "Jessie", "jessie@asa", 29, "BA"),
    new derived_1.Employee(107, "James", "james@asa", 30, "senior developer"),
    new derived_1.Employee(108, "June", "june@asa", 25, "tester")
];
// console.log(employees);
function getEmployeesByJob(job) {
    var emps = employees.filter(function (e) { return e.getJobTitle() === job; });
    // for (let index = 0; index < employees.length; index++) {
    //     if(employees[index].getJobTitle() === job) {
    //         emps.push(employees[index]);
    //     }
    // }
    return emps;
}
console.log(getEmployeesByJob("developer"));
