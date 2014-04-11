package in.wptrafficanalyzer.navigationdrawer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class Scripts extends Activity {
    /** Called when the activity is first created. */
	
	ImageButton button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scripts_home); 
        addListenerOnButton();

    }

    public void addListenerOnButton() {
    	 
		final Context context = this;
 
		button = (ImageButton) findViewById(R.id.greetings_button);
 
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
 
			    Intent intent = new Intent(context, Second_Screen.class);
                            startActivity(intent);   
 
			}
 
		});
 
	}

}