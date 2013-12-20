package com.example.dto;

public class Record {

	private String name;
	
	private String date;
	
	private String type;

	public Record(String name, String date, String type) {
		super();
		this.name = name;
		this.date = date;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getType() {
		return type;
	}
	
	
}
