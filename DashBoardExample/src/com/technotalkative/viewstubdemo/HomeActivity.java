package com.technotalkative.viewstubdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends DashBoardActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setHeader(getString(R.string.HomeActivityTitle), false, true);
        
    }
    
    public void onButtonClicker(View v)
    {
    	Intent intent;
    	
    	switch (v.getId()) {
		case R.id.main_btn_Greetings:
			intent = new Intent(this, Activity_Greetings.class);
			startActivity(intent);
			break;

		case R.id.main_btn_Departures:
			intent = new Intent(this, Activity_Departures.class);
			startActivity(intent);
			break;
			
		case R.id.main_btn_HandlingDisagreements:
			intent = new Intent(this, Activity_HandlingDisagreements.class);
			startActivity(intent);
			break;
		
		default:
			break;
		}
    }
}

