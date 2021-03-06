//The package and the first import are from the site where the code was copied from,
//we should probably get around to changing this
package in.wptrafficanalyzer.navigationdrawer;

import in.wptrafficanalyzer.navigationdrawer.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LifeAppMenuSelections extends Fragment {
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
 
        // Retrieving the currently selected item number
        int menuItemSelected = getArguments().getInt("position");
 
        // List of menu items
        String[] menuItems = getResources().getStringArray(R.array.life_app_main_menu_items);
 
        // Creating view corresponding to the fragment
        /*IMPORTANT******* 
         * This references the layout to be displayed after clicking a menu item
         */
        View v = inflater.inflate(R.layout.test_layout, container, false);
 
        switch(menuItemSelected)
        {
	        case 0: 
		        v = inflater.inflate(R.layout.relationship_maint_home, container, false);
		        break;
	        case 1: 
	        	v = inflater.inflate(R.layout.scripts_home, container, false);
	        	break;
	        case 2:
		       	v = inflater.inflate(R.layout.hygiene_home, container, false);
		    	break;
	        case 3:
		        v = inflater.inflate(R.layout.time_management_home, container, false);
		    	break;
	        case 4: 
		        v = inflater.inflate(R.layout.emergency_info_home, container, false);
		    	break;        	
	        default:
	        	v = inflater.inflate(R.layout.test_layout, container, false);
	        	break;
        }
        
        /*
        // Getting reference to the TextView of the Fragment   
        //The next few lines are irrelevant since this references the text view of the fragment layout
        //we need to change this fragment layout to the different menu activities
        TextView tv = (TextView) v.findViewById(R.id.tv_content);
 
        // Setting currently selected river name in the TextView
        //
        tv.setText(menuItems[position]);
 
 		*/
        // Updating the action bar title
        //This part stays
        getActivity().getActionBar().setTitle(menuItems[menuItemSelected]);
 
        return v;
    }
}
