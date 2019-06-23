package com.dfwcomputech.scrap.common;

public class PesFilter {
	private String name;
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	//Return the pair for the url
	public String getFilter() {
		if(this.name==null)
			return "";
		return (this.name==null?"":this.name)+"="+(this.value==null?"":this.value);
	}
}
