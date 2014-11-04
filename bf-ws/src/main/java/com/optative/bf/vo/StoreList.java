package com.optative.bf.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "storelist")
public class StoreList {
	
	
	private List<String> storeNames = new ArrayList<String>();

	public StoreList() {
		super();
	}

	public StoreList(List<String> clusters) {
		super();
		this.setStoreNames(clusters);
	}

	public List<String> getStoreNames() {
		return storeNames;
	}

	public void setStoreNames(List<String> storeNames) {
		this.storeNames = storeNames;
	}

}
