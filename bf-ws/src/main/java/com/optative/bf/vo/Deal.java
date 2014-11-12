package com.optative.bf.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "deals")
public class Deal {

	private int id;
	private String store;
	private String category;
	private String sub_category;
	private String item;
	private String early_bird;
	private String rebate;
	private String price;
	private String img_url;
	private String product_url;

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

	public String getSub_category() {
		return sub_category;
	}

	public void setSub_category(String sub_category) {
		this.sub_category = sub_category;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getProduct_url() {
		return product_url;
	}

	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
