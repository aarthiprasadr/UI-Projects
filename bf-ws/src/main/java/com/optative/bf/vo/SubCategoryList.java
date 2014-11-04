package com.optative.bf.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "subcategory")
public class SubCategoryList {

	private String categoryName ;
	private List<String> subCategoryNames = new ArrayList<String>();

	public SubCategoryList() {
		super();
	}

	public SubCategoryList(List<String> categoryNames) {
		super();
		this.setSubCategoryNames(categoryNames);
	}

	public List<String> getSubCategoryNames() {
		return subCategoryNames;
	}

	public void setSubCategoryNames(List<String> subCategoryNames) {
		this.subCategoryNames = subCategoryNames;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
