package com.android;
import java.util.ArrayList;
import java.util.StringTokenizer;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

public class Menu extends ListActivity{
	static String text = "";
	
	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   
	    ArrayList<String> al = new ArrayList<String>();
	    al.add("STOP1");
	    al.add("STOP2");
	    al.add("STOP3");
	    al.add("STOP4");
	    al.add("STOP5");
	    al.add("STOP6");
	    al.add("STOP7");
	    al.add("STOP8");
	    al.add("STOP9");
	   // al.add("STOP10");
	    al.add("Back");
	   Log.v("Stop Details....",al.toString());
	   setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, al));

	   ListView lv = getListView();
	   lv.setTextFilterEnabled(true);

	   lv.setOnItemClickListener(new OnItemClickListener() {
	     public void onItemClick(AdapterView<?> parent, View view,
	         int position, long id) {
	      	String selectedText = ((TextView) view).getText().toString();
	      	 if(selectedText.intern() == "Back"){
	      	 Toast.makeText(getApplicationContext(),selectedText, 10).show();
	      	 }else{
	      		text = selectedText;
	      		Toast.makeText(getApplicationContext(), "Source...."+text,10).show();
	      		ServerIPAddress.setSource(text);
	      		Intent intent = new Intent(Menu.this,DestinationMenu.class);
	      		startActivity(intent);
	      	 }
	       }
	   });
	 }

}
