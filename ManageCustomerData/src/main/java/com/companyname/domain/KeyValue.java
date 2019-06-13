package com.companyname.domain;

public class KeyValue {
	private  String key;
	private  String value;
	
	public  String getKey() {
		return key;
	}
	public  void setKey(String Key) {
		this.key = Key;
	}
	public  String getValue() {
		return value;
	}
	public  void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return key+"\t"+value;
	}

}
