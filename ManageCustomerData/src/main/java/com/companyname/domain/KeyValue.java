package com.companyname.domain;

public class KeyValue {
	private String tagName;

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagValue() {
		return tagValue;
	}

	public void setTagValue(String tagValue) {
		this.tagValue = tagValue;
	}

	private String tagValue;

//	private String XPath;
//	
//	public String getXPath() {
//		return XPath;
//	}
//	public void setXPath(String xPath) {
//		XPath = xPath;
//	}
	public String toString() {
		return tagName + "\t" + tagValue;
	}

}