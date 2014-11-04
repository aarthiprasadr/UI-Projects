package com.optative.bf.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cluster")
public class ItemList {

	private List<String> itemNames = new ArrayList<String>();

	public ItemList() {
		super();
	}

	public ItemList(List<String> itemNames) {
		super();
		this.setItemNames(itemNames);
	}

	public List<String> getItemNames() {
		return itemNames;
	}

	public void setItemNames(List<String> itemNames) {
		this.itemNames = itemNames;
	}


}
