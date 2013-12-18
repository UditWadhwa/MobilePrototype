package com.example.dto;

import java.util.Date;

public class Record {

	private String name;
	
	private Date date;
	
	private RecordTypeEnum type;

	public Record(String name, Date date, RecordTypeEnum type) {
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

	public RecordTypeEnum getType() {
		return type;
	}
	
	
}
