package com.optative.bf.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cluster")
public class CategoryList {

	private List<String> categoryNames = new ArrayList<String>();

	public CategoryList() {
		super();
	}

	public CategoryList(List<String> categoryNames) {
		super();
		this.setCategoryNames(categoryNames);
	}

	public List<String> getCategoryNames() {
		return categoryNames;
	}

	public void setCategoryNames(List<String> categoryNames) {
		this.categoryNames = categoryNames;
	}
}
