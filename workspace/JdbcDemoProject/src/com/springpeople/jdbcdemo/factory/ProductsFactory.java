package com.springpeople.jdbcdemo.factory;

import java.util.List;

import com.springpeople.jdbcdemo.connectivity.ProductsDb;
import com.springpeople.jdbcdemo.entity.Products;

public class ProductsFactory {

	public static String createProduct(Products p) {
		int res = ProductsDb.createProduct(p);
		String str = "Unable to add new product details";
		
		if(res > 0) {
			str = "Product details uploaded successfully";
		}
		
		return str;
	}
	
	public static Products[] getAllProducts() {
		List<Products> list = ProductsDb.retrieveAll();
		
		return list.toArray(new Products[list.size()]);
	}
	
	public static Products getProductById(int id) {
		Products p = ProductsDb.getProductById(id);
		return p;
	}
}
