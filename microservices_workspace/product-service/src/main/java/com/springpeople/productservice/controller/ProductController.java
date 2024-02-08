package com.springpeople.productservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springpeople.productservice.entity.Inventory;
import com.springpeople.productservice.entity.Price;
import com.springpeople.productservice.entity.Product;
import com.springpeople.productservice.response.ProductInfo;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/product/details/{productid}")
	public Product getProductDetails(@PathVariable Long productid) {
		ProductInfo productInfo = getProductInfo(productid);
		
		// Get Price from pricing-service
		Price price = restTemplate.getForObject("http://localhost:8002/api/prices/price/"+productid, Price.class);
		
		// Get Stock Avail from inventory-service
		Inventory inventory = restTemplate.getForObject("http://localhost:8003/api/inventories/inventory/"+productid, Inventory.class);
		
		return new Product(productInfo.getProductId(), productInfo.getProductName(), productInfo.getProductDescription(), price.getDiscountedPrice(),
				inventory.getInStock());
	}


	private ProductInfo getProductInfo(long id) {
		populateProductList();
		
		for(ProductInfo p: productList) {
			if(id == p.getProductId()) {
				return p;
			}
		}
		return null;
	}

	private void populateProductList() {
		productList.add(new ProductInfo(101L, "Product1", "A Product"));
		productList.add(new ProductInfo(102L, "Product2", "Product 2"));
		productList.add(new ProductInfo(103L, "Product3", "A Product 3"));
		productList.add(new ProductInfo(104L, "Product4", "A Product 4"));
		productList.add(new ProductInfo(105L, "Product5", "A Product 5"));
		
	}
}
