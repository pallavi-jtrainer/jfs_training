package com.springpeople.priceservice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springpeople.priceservice.entity.ExgVal;
import com.springpeople.priceservice.entity.Price;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
	@Autowired
	private RestTemplate restTemplate;

	List<Price> priceList = new ArrayList<Price>();

	@GetMapping("/price/{productid}")
	public Price getPriceDetails(@PathVariable Long productid) {
		Price price = getPriceInfo(productid);

		// Get Exchange Value
		Integer exgVal = restTemplate.getForObject("http://localhost:8004/api/currency/currexg/from/USD/to/INR", ExgVal.class)
				.getExgVal();

		return new Price(price.getPriceId(), price.getProductId(), price.getOriginalPrice(),
				Math.multiplyExact(exgVal, price.getDiscountedPrice()));
	}

	private Price getPriceInfo(Long productid) {
		populatepriceList();

		for (Price p : priceList) {
			if (productid.equals(p.getProductId())) {

				return p;
			}
		}

		return null;
	}

	private void populatepriceList() {
		priceList.clear();
		priceList.add(new Price(201L, 101l, 1999, 999));
		priceList.add(new Price(202L, 102l, 199, 19));
		priceList.add(new Price(203L, 103l, 1222, 600));
	}
}
