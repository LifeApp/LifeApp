package in.wptrafficanalyzer.navigationdrawer;

import in.wptrafficanalyzer.navigationdrawer.R;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NavigationDrawer extends Activity {

	// Within which the entire activity is enclosed
    DrawerLayout lifeDrawerLayout;
 
    // ListView represents Navigation Drawer
    ListView lifeDrawerList;
 
    // ActionBarDrawerToggle indicates the presence of Navigation Drawer in the action bar
    ActionBarDrawerToggle mDrawerToggle;
 
    // Title of the action bar
    String mTitle="";
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
        //Starts the main layout 
        //Maybe we can edit this so that the Nav drawer is over the relationship maintenance layout
        setContentView(R.layout.main_drawer_layout);
 
        mTitle = (String) getTitle();
 
        // Getting reference to the DrawerLayout
        lifeDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
 
        lifeDrawerList = (ListView) findViewById(R.id.drawer_list);
 
        // Getting reference to the ActionBarDrawerToggle
        mDrawerToggle = new ActionBarDrawerToggle( this,
            lifeDrawerLayout,
            R.drawable.ic_drawer,
            R.string.drawer_open,
            R.string.drawer_close){
 
                /** Called when drawer is closed */
                public void onDrawerClosed(View view) {
                    getActionBar().setTitle(mTitle);
                    invalidateOptionsMenu();
                }
 
                /** Called when a drawer is opened */
                public void onDrawerOpened(View drawerView) {
                    getActionBar().setTitle("Life-App");
                    invalidateOptionsMenu();
                }
        };
 
        // Setting DrawerToggle on DrawerLayout
        lifeDrawerLayout.setDrawerListener(mDrawerToggle);
 
        // Creating an ArrayAdapter to add items to the listview mDrawerList
        ArrayAdapter<String> lifeMainMenuItems = new ArrayAdapter<String>(
            getBaseContext(),
            R.layout.drawer_list_layout ,
            getResources().getStringArray(R.array.life_app_main_menu_items)
        );
 
        // Setting the adapter on mDrawerList
        // Puts the menu items on the nav drawer
        lifeDrawerList.setAdapter(lifeMainMenuItems);
 
        
        /*       
         BREAKS API 11 
         This portion break api 11 so its commented out, everything so far still works like normal
        // Enabling Home button
        getActionBar().setHomeButtonEnabled(true);
        
        */
 
        // Enabling Up navigation
        getActionBar().setDisplayHomeAsUpEnabled(true);
 
        // Setting item click listener for the listview mDrawerList
        lifeDrawerList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                View view,
                int position,
                long id) {
 
                    // Getting an array of menu items
                    String[] menuItems = getResources().getStringArray(R.array.life_app_main_menu_items);
 
                    //Currently selected menu item
                    mTitle = menuItems[position];
 
                    // Creating a fragment object
                    LifeAppMenuSelections rFragment = new LifeAppMenuSelections();
 
                    // Creating a Bundle object
                    Bundle data = new Bundle();
 
                    // Setting the index of the currently selected item of mDrawerList
                    data.putInt("position", position);
 
                    // Setting the position to the fragment
                    rFragment.setArguments(data);
 
                    // Getting reference to the FragmentManager
                    FragmentManager fragmentManager = getFragmentManager();
 
                    // Creating a fragment transaction
                    FragmentTransaction ft = fragmentManager.beginTransaction();
 
                    // Adding a fragment to the fragment transaction
                    ft.replace(R.id.content_frame, rFragment);
 
                    // Committing the transaction
                    ft.commit();
 
                    // Closing the drawer
                    lifeDrawerLayout.closeDrawer(lifeDrawerList);
            }
        });
    }
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
 
    /** Handling the touch event of app icon */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
 
    /** Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the drawer is open, hide action items related to the content view
        boolean drawerOpen = lifeDrawerLayout.isDrawerOpen(lifeDrawerList);
 
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}


