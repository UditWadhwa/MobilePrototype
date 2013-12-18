package com.example.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.dto.Record;

public class CommonUtils {

	private static DateFormat DATEFORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String formatDate(Date date)
	{
		return DATEFORMAT.format(date);
	}
	
	public static List<Record> getReminders(InputStream inputStream) throws ParseException
	{
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		int read;
		try 
		{
			read = inputStream.read();
			while (read != -1)
			{
				byteArrayOutputStream.write(read);
				read = inputStream.read();
			}
			inputStream.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		String remindersString = byteArrayOutputStream.toString();
		
		List<Record> records = new ArrayList<Record>();
		try 
		{
			JSONArray reminders = new JSONArray(remindersString);
			for(int i=0; i < reminders.length(); i++)
			{
				JSONObject reminder = reminders.getJSONObject(i);
				records.add(new Record(reminder.getString("name"), DATEFORMAT.parse(reminder.getString("date")), reminder.getString("type")));
			}
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return records;
	}
}
