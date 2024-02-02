"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Invoice = void 0;
var Invoice = /** @class */ (function () {
    // private invId: number;
    function Invoice(invId, item, qty) {
        this.invId = invId;
        this.item = item;
        this.qty = qty;
    }
    Object.defineProperty(Invoice.prototype, "invid", {
        get: function () { return this.invId; },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Invoice.prototype, "Item", {
        get: function () { return this.item; },
        enumerable: false,
        configurable: true
    });
    Object.defineProperty(Invoice.prototype, "quantity", {
        get: function () {
            return this.qty;
        },
        enumerable: false,
        configurable: true
    });
    return Invoice;
}());
exports.Invoice = Invoice;
