package com.optative.bf.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class StoreConfig {
	
	private List<CategoryConfig> categoryConfigs = new ArrayList<CategoryConfig>();
	
	public StoreConfig() {
		super();
	}

	public StoreConfig(List<CategoryConfig> categoryConfigs) {
		super();
		this.categoryConfigs = categoryConfigs;
	}

	public List<CategoryConfig> getCategoryConfigs() {
		return categoryConfigs;
	}

	public void setCategoryConfigs(List<CategoryConfig> categoryConfigs) {
		this.categoryConfigs = categoryConfigs;
	}

}
