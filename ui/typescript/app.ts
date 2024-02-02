import { Employee } from "./derived";

let employees: Employee[] = [
    new Employee(101, "John", "john@asa", 24, "developer"),
    new Employee(102, "Jane", "jane@asa", 25, "developer"),
    new Employee(103, "Jonah", "jonah@asa", 24, "tester"),
    new Employee(104, "Jenny", "jenny@asa", 27, "tester"),
    new Employee(105, "Joanne", "joanne@asa", 24, "developer"),
    new Employee(106, "Jessie", "jessie@asa", 29, "BA"),
    new Employee(107, "James", "james@asa", 30, "senior developer"),
    new Employee(108, "June", "june@asa", 25,"tester")
];

// console.log(employees);

function getEmployeesByJob(job: string): Employee[] {
    let emps: Employee[] = 
        employees.filter(e => e.getJobTitle() === job);

    // for (let index = 0; index < employees.length; index++) {
    //     if(employees[index].getJobTitle() === job) {
    //         emps.push(employees[index]);
    //     }
    // }

    return emps;
 }

console.log(getEmployeesByJob("developer"));