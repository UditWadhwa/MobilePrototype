package com.example.remindersapp;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
