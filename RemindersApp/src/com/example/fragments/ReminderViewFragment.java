package com.example.fragments;

import com.example.remindersapp.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ReminderViewFragment extends Fragment
{
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(R.layout.reminder_view_fragment, container, false);
		return fragmentView;
	}
	
	public void updateView(int position)
	{
		View fragment = this.getView();
		TextView text = (TextView) fragment.findViewById(R.id.textView1);
		text.setText("You are viewing record " + (position + 1));
		
	}
}
