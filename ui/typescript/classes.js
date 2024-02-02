"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Person = void 0;
var Person = /** @class */ (function () {
    function Person(personId, personName, personEmail, personAge) {
        this.personId = personId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personAge = personAge;
    }
    Object.defineProperty(Person.prototype, "personid", {
        // constructor(personId: number, personName: string, 
        //     personEmail:string, personAge: number,
        //     city:string) 
        // {
        //     this.personId = personId;
        //     this.personName = personName;
        //     this.personEmail = personEmail;
        //     this.personAge = personAge;
        //     this.city = city;
        // }
        get: function () {
            return this.personId;
        },
        set: function (id) {
            this.personId = id;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "personname", {
        get: function () {
            return this.personName;
        },
        set: function (name) {
            this.personName = name;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "personemail", {
        get: function () {
            return this.personEmail;
        },
        set: function (email) {
            this.personEmail = email;
        },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Person.prototype, "personage", {
        get: function () {
            return this.personAge;
        },
        set: function (age) {
            this.personAge = age;
        },
        enumerable: false,
        configurable: true
    });
    Person.prototype.setDetails = function (name, email, age) {
        if (age == undefined) {
            this.personName = name;
            this.personEmail = email;
        }
        else {
            this.personName = name;
            this.personEmail = email;
            this.personAge = age;
        }
    };
    Person.prototype.getDetails = function () {
        return this.personId + " " + this.personName
            + " " + this.personEmail + " " + this.personAge;
    };
    return Person;
}());
exports.Person = Person;
// let person: Person = new Person(1, "person1","person@aja", 23);
// // person.personId = 1;
// console.log(person);
// // person.personid = 2;
// // console.log(person.personid);
// person.setDetails("New Person", "newssj@@");
// console.log(person);
