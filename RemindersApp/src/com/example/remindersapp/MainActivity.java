package com.example.remindersapp;

import android.app.Activity;
import android.os.Bundle;

import com.example.adapter.RemindersAdapter;

public class MainActivity extends Activity {

	RemindersAdapter remindersAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
}
