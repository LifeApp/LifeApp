package in.wptrafficanalyzer.navigationdrawer;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;

public class Second_Screen extends Activity {
    /** Called when the activity is first created. */
	
	Button button;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);  
    }
}