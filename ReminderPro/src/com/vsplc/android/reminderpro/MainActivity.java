package com.vsplc.android.reminderpro;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.options_menu, menu);

		
		// Associate searchable configuration with the SearchView
	    SearchManager searchManager =
	           (SearchManager) getSystemService(Context.SEARCH_SERVICE);
	    
	    SearchView searchView =
	            (SearchView) menu.findItem(R.id.search).getActionView();
	    
	    if (searchManager != null) {
			
	    	searchView.setSearchableInfo(
		            searchManager.getSearchableInfo(getComponentName()));
	    	
		}else{
			Log.d("MainActivity : ", "SearchManager : "+searchManager);
		}
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.ic_search) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
