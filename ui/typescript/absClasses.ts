export abstract class Invoice {
    // private invId: number;

    constructor(private invId: number,
        private item: string, 
        private qty: number) {}

    abstract getAmount(price: number) :number;

    public get invid(): number { return this.invId; }

    public get Item():string { return this.item; }

    public get quantity() {
        return this.qty;
    }
}