export class Person {
    private personId: number;
    private personName: string;
    private personEmail: string;
    private personAge: number;
    readonly city: string;// = "Bangalore";

    constructor(personId: number, personName: string, 
        personEmail:string, personAge: number) 
    {
        this.personId = personId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personAge = personAge;
    }


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

    
    public get personid() : number {
        return this.personId;
    }

    
    public set personid(id : number) {
        this.personId = id;
    }
    
    
    public get personname() : string {
        return this.personName
    }

    public get personemail():string {
        return this.personEmail;
    }

    public get personage() : number { 
        return this.personAge;
    }

    
    public set personname(name : string) {
        this.personName = name;
    }

    public set personemail(email : string) { 
        this.personEmail = email;
    }

    public set personage(age : number) { 
        this.personAge = age;
    }
    
    public setDetails(name : string, email : string, age?: number) {
        if(age == undefined) {
            this.personName = name;
            this.personEmail = email;
        } else {
            this.personName = name;
            this.personEmail = email;
            this.personAge = age;
        }
    }

    public getDetails(): string {
        return this.personId + " " + this.personName
            + " " + this.personEmail + " " + this.personAge;
    }

    // public setDetails(name : string, email : string, age : number) {
    //     this.personName = name;
    //     this.personEmail = email;
    //     this.personAge = age;
    // }
    
}

// let person: Person = new Person(1, "person1","person@aja", 23);
// // person.personId = 1;
// console.log(person);

// // person.personid = 2;
// // console.log(person.personid);

// person.setDetails("New Person", "newssj@@");
// console.log(person);




