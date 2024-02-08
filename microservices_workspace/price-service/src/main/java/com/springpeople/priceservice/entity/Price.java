package com.springpeople.priceservice.entity;

public class Price {

	private Long priceId;
	private Long productId;
	private Integer originalPrice;
	private Integer discountedPrice;
	
	public Price() {}

	public Price(Long priceId, Long productId, Integer originalPrice, Integer discountedPrice) {
		this.priceId = priceId;
		this.productId = productId;
		this.originalPrice = originalPrice;
		this.discountedPrice = discountedPrice;
	}

	public Long getPriceId() {
		return priceId;
	}

	public void setPriceId(Long priceId) {
		this.priceId = priceId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Integer getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Integer discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	
	
}
