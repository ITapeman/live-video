package com.saas.pojo;

import java.util.Set;

public class Garden_Category {
	private int gcid;
	private String category;
	
	private Set<Garden> gardens;

	public Garden_Category(){}
	
	public int getGcid() {
		return gcid;
	}

	public void setGcid(int gcid) {
		this.gcid = gcid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<Garden> getGardens() {
		return gardens;
	}

	public void setGardens(Set<Garden> gardens) {
		this.gardens = gardens;
	}
	
}
