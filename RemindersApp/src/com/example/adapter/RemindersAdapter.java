package com.example.adapter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dto.Record;
import com.example.dto.RecordTypeEnum;
import com.example.remindersapp.R;
import com.example.utils.CommonUtils;

public class RemindersAdapter extends BaseAdapter{

	private List<Record> records = new ArrayList<Record>();
	
	@Override
	public int getCount() {
		return records.size();
	}

	@Override
	public Object getItem(int index) {
		return records.get(index);
	}

	@Override
	public long getItemId(int index) {
		return index;
	}

	@Override
	public View getView(int index, View view, ViewGroup parent) {
		if(view == null)
		{
			LayoutInflater inflater = LayoutInflater.from(parent.getContext());
			view = inflater.inflate(R.layout.reminder_list_item, parent, false);
		}
		
		Record reminderRecord = records.get(index);
		
		TextView name = (TextView) view.findViewById(R.id.textView1);
		name.setText(reminderRecord.getName());
		
		TextView date = (TextView) view.findViewById(R.id.textView2);
		date.setText(CommonUtils.formatDate(reminderRecord.getDate()));
		
		TextView type = (TextView) view.findViewById(R.id.textView3);
		type.setText(reminderRecord.getType().toString());
		type.setTypeface(Typeface.MONOSPACE);
		
		return view;
	}

	public RemindersAdapter()
	{
		Record testRecord = new Record("Record One", new Date(), RecordTypeEnum.ANNIVERSARY);
		Record testRecord2 = new Record("Record Two", new Date(), RecordTypeEnum.BIRTHDAY);
		records.add(testRecord);
		records.add(testRecord2);
	}
}
