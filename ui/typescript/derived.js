"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.Employee = void 0;
var classes_1 = require("./classes");
var Employee = /** @class */ (function (_super) {
    __extends(Employee, _super);
    function Employee(personId, personName, personEmail, personAge, jobTitle) {
        var _this = _super.call(this, personId, personName, personEmail, personAge) || this;
        _this.jobTitle = jobTitle;
        _this.jobTitle = jobTitle;
        return _this;
    }
    Employee.prototype.getDetails = function () {
        return _super.prototype.getDetails.call(this) + " " + this.jobTitle;
    };
    // constructor(private empId: number, private empName: string) {
    //     this.empId = empId;
    //     this.empName = empName;
    // }
    Employee.prototype.getJobTitle = function () {
        return this.jobTitle;
    };
    return Employee;
}(classes_1.Person));
exports.Employee = Employee;
// let emp = new Employee(101, "emp1","emp1@ahaha", 25, "developer");
// console.log(emp.getDetails());
