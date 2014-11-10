package com.optative.bf.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DealWrapper {

	private Deal deal = null;
	
	public DealWrapper() {
		
	}
	
	public DealWrapper(Deal deal) {
		this.deal = deal;
	}

	public Deal getDeal() {
		return deal;
	}

	public void setDeal(Deal deal) {
		this.deal = deal;
	}
}
