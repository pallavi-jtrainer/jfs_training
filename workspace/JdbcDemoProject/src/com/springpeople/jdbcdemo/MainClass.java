package com.springpeople.jdbcdemo;

import com.springpeople.jdbcdemo.entity.Products;
import com.springpeople.jdbcdemo.factory.ProductsFactory;

public class MainClass {

	public static void main(String[] args) {
//		Products p = new Products(1, "4 lined Notebook", 75.00);
//		
//		String str = ProductsFactory.createProduct(p);
//		System.out.println(str);
		
		Products[] products = ProductsFactory.getAllProducts();
		for(Products p: products) {
			System.out.println(p.toString());
		}
		
		Products p = ProductsFactory.getProductById(1);
		System.out.println(p.toString());

	}

}
