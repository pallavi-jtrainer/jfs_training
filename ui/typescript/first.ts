/**
 * number
 * string
 * boolean
 * object
 * null
 * undefined
 */

// let a: number = 10;
// console.log(a);

// function isNumber(num: any): any{
//     return typeof num === 'number';
// }

// console.log("Number? " + isNumber("23"));

// function myFunction(a: string, b: string);
// function myFunction(a: number, b: number);
// function myFunction(a: any, b: any){
//     if (typeof a === 'number' && typeof b === 'number') {
//         console.log(a + b);
//     } else {
//         console.log(a + " is not a number and neither is " + b); 
//     }
// }

// myFunction(23, 45);

import { Person } from "./classes";

let p1: Person = new Person(1, "person1","person@aja", 23);
console.log(p1);

