package com.optative.bf.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DealList {
	
	public DealList() {
		super();
	}

	public DealList(List<Deal> deals) {
		super();
		this.deals = deals;
	}

	private List<Deal> deals = new ArrayList<Deal>();

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}

}
