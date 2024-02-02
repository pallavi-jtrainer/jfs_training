class Item {
    #itemid;
    #itemname;
    #price;
    constructor(itemid, itemname, price) {
        this.#itemid = itemid;
        this.#itemname = itemname
        this.#price = price;
    }

    get itemid() {
        return  this.#itemid;
    }

    set itemid(value) {
        this.#itemid = value;
    }

    get itemname() {
        return this.#itemname;
    }

    set itemname(value) {
        this.#itemname = value;
    }

    get price() {
        return this.#price;
    }

    set price(value) {
        this.#price = value;
    }

    getItemDetails() {
        return this.#itemid + " " + this.#itemname + " " + this.#price;
    }
}

let item = new Item();
item.itemid = 101;
item.itemname = "Dell Laptop";
item.price = 100000;

console.log(item.getItemDetails());

console.log(item.itemid);
