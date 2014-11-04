package com.optative.bf.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class CategoryConfig {
	
	private String categoryName;
	private List<String> subCategoryList = new ArrayList<String>();
	
	public CategoryConfig() {
		super();
	}

	public CategoryConfig(List<String> subCategoryList) {
		super();
		this.subCategoryList = subCategoryList;
	}


	public List<String> getSubCategoryList() {
		return subCategoryList;
	}

	public void setSubCategoryList(List<String> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
			
	public void addSubCategory(String subCategory) {
		subCategoryList.add(subCategory);
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
			

}
