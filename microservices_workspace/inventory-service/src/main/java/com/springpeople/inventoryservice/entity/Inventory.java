package com.springpeople.inventoryservice.entity;

public class Inventory {
	private Long inventoryId;
	private Long productId;
	private Boolean inStock;
	
	public Inventory() {}

	public Inventory(Long inventoryId, Long productId, Boolean inStock) {
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.inStock = inStock;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Boolean getInStock() {
		return inStock;
	}

	public void setInStock(Boolean inStock) {
		this.inStock = inStock;
	}
	
	
}
