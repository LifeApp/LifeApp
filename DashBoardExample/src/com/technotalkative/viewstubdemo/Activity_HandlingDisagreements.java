package com.technotalkative.viewstubdemo;

import android.os.Bundle;

public class Activity_HandlingDisagreements extends DashBoardActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_HandlingDisagreements);
        setHeader(getString(R.string.HandlingDisagreementsActivityTitle), true, true);
        
    }
}
