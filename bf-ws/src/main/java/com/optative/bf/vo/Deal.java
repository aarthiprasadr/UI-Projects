package com.optative.bf.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="deals")
public class Deal {
	
	private String store;
	private String category;
	private String item;
	private String early_bird;
	private String rebate;
	private String price;
	
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getEarly_bird() {
		return early_bird;
	}
	public void setEarly_bird(String early_bird) {
		this.early_bird = early_bird;
	}
	public String getRebate() {
		return rebate;
	}
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

}
