import { Person } from "./classes";

export class Employee extends Person{
    private static organization: string = "Paychex";

    constructor(personId: number, personName: string, 
        personEmail:string, personAge: number, 
        private jobTitle:string) 
    {
        super(personId, personName, personEmail, personAge);
        this.jobTitle = jobTitle;
    }

    public set organization(org: string) { 
        Employee.organization = org;
    }

    public get organization() {
        return Employee.organization;
    }
    public getDetails(): string {
        return super.getDetails() + " " + this.jobTitle;
    }
    // constructor(private empId: number, private empName: string) {
    //     this.empId = empId;
    //     this.empName = empName;
    // }

    public getJobTitle(): string { 
        return this.jobTitle;
    }
}

// let emp = new Employee(101, "emp1","emp1@ahaha", 25, "developer");

// console.log(emp.getDetails());