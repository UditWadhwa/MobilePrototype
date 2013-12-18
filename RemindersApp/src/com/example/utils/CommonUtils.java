package com.example.utils;

import java.text.DateFormat;
import java.util.Date;

public class CommonUtils {

	private static final DateFormat format = DateFormat.getDateInstance();
	
	public static String formatDate(Date date)
	{
		return format.format(date);
	}
}
