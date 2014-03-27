package com.technotalkative.viewstubdemo;

import android.os.Bundle;

public class Activity_Greetings extends DashBoardActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greetings);
        setHeader(getString(R.string.GreetingsActivityTitle), true, true);
        
    }
}
