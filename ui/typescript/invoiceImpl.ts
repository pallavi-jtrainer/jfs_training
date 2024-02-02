import { Invoice } from "./absClasses";

class InvoiceImpl extends Invoice {
    constructor(invId: number, item:string, qty:number){
        super(invId, item, qty);
    }

    public getAmount(price: number): number {
        return price * this.quantity    
    }

}

let inv = new InvoiceImpl(1, "Laptop", 1);
console.log(inv);
console.log(inv.getAmount(100000));