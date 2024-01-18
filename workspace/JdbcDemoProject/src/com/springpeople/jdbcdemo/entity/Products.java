package com.springpeople.jdbcdemo.entity;

import java.util.Objects;

public class Products {
	private int productId;
	private String productName;
	private double unitPrice;
	
	public int getProductId() {
		return productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public Products() {
		
	}
	
	public Products(int productId, String productName, double unitPrice) {
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, unitPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return productId == other.productId && Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(unitPrice) == Double.doubleToLongBits(other.unitPrice);
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", unitPrice=" + unitPrice + "]";
	}
}
