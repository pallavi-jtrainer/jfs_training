package com.springpeople.hibernate.HibernateDemo.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	@Id
	@Column(name="productid")
	private int productId;
	
	@Column(name="productname")
	private String productName;
	
	@Column(name="unitprice")
	private double unitprice;
	
	public Products() {
		
	}

	public Products(int productId, String productName, double unitprice) {
		this.productId = productId;
		this.productName = productName;
		this.unitprice = unitprice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, productName, unitprice);
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
				&& Double.doubleToLongBits(unitprice) == Double.doubleToLongBits(other.unitprice);
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", unitprice=" + unitprice + "]";
	}
}
