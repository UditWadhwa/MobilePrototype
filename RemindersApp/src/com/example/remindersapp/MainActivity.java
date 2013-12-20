package com.example.remindersapp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.RemindersAdapter;
import com.example.dto.Record;
import com.example.utils.CommonUtils;

public class MainActivity extends Activity {

	RemindersAdapter remindersAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView list = (ListView) findViewById(R.id.listView1);
        
        List<Record> reminders = null;
        
        try 
        {
        	reminders = CommonUtils.getReminders(getAssets().open("reminders.json"));
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		}
        remindersAdapter = new RemindersAdapter(reminders);
        list.setAdapter(remindersAdapter);
        
        list.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View view,
					int arg2, long arg3) {
				Toast.makeText(view.getContext(), "Delete: To be implemented", Toast.LENGTH_LONG).show();
				return true;
			}
		});
    }


    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	menu.add("Sort by date");
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	remindersAdapter.setReminders(CommonUtils.sortRemindersByDate(remindersAdapter.getReminders()));
    	remindersAdapter.notifyDataSetChanged();
		return true;
    	
    }
    
}
