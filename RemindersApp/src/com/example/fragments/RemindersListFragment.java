package com.example.fragments;

import java.util.List;

import com.example.adapter.RemindersAdapter;
import com.example.dto.Record;
import com.example.remindersapp.R;
import com.example.utils.CommonUtils;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class RemindersListFragment extends Fragment
{
	RemindersAdapter remindersAdapter;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		View fragmentView = inflater.inflate(R.layout.reminder_fragment, container);
		
		ListView list = (ListView) fragmentView.findViewById(R.id.listView1);;
		List<Record> reminders = null;
        
        try 
        {
        	reminders = CommonUtils.getReminders(getActivity().getAssets().open("reminders.json"));
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
        
        setHasOptionsMenu(true);
        
		return fragmentView;
	}
	
	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    	menu.add("Sort by date");
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	remindersAdapter.setReminders(CommonUtils.sortRemindersByDate(remindersAdapter.getReminders()));
    	remindersAdapter.notifyDataSetChanged();
		return true;
    	
    }
}
