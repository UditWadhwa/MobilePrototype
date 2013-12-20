package com.example.dto;

import java.util.Date;

public class Record {

	private String name;
	
	private Date date;
	
	private String type;

	public Record(String name, Date date, String type) {
		super();
		this.name = name;
		this.date = date;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public String getType() {
		return type;
	}
	
	
}
