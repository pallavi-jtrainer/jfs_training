package com.springpeople.productservice.entity;

public class Inventory {
	private Long inventoryID;
	private Long productID;
	private Boolean inStock;
	
	public Inventory() {}

	public Inventory(Long inventoryID, Long productID, Boolean inStock) {
		this.inventoryID = inventoryID;
		this.productID = productID;
		this.inStock = inStock;
	}

	public Long getInventoryID() {
		return inventoryID;
	}

	public void setInventoryID(Long inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	
	
}
