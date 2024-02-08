package com.springpeople.priceservice.entity;

public class ExgVal {
	private Long id;
	private Currencies from;
	private Currencies to;
	private Integer exgVal;
	
	public ExgVal() {}

	public ExgVal(Long id, Currencies from, Currencies to, Integer exgVal) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.exgVal = exgVal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Currencies getFrom() {
		return from;
	}

	public void setFrom(Currencies from) {
		this.from = from;
	}

	public Currencies getTo() {
		return to;
	}

	public void setTo(Currencies to) {
		this.to = to;
	}

	public Integer getExgVal() {
		return exgVal;
	}

	public void setExgVal(Integer exgVal) {
		this.exgVal = exgVal;
	}
	
	
}
