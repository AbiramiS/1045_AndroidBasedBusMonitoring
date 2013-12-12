package com.android;


import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


public class DestinationMenu extends ListActivity{
	static String text = "";
	 HttpResponse response;
		HttpClient httpclient;
		String responseText;
		String message = "";
		int destination = 0;
		int source = 0;
	
	public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   
	    ArrayList<String> al = new ArrayList<String>();
	    al.add("STOP2");
	    al.add("STOP3");
	    al.add("STOP4");
	    al.add("STOP5");
	    al.add("STOP6");
	    al.add("STOP7");
	    al.add("STOP8");
	    al.add("STOP9");
	    //al.add("STOP10");
	    al.add("Submit");
	   Log.v("Client List",al.toString());
	   setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, al));

	   ListView lv = getListView();
	   lv.setTextFilterEnabled(true);

	   lv.setOnItemClickListener(new OnItemClickListener() {
	     public void onItemClick(AdapterView<?> parent, View view,
	         int position, long id) {
	      	String selectedText = ((TextView) view).getText().toString();
	      	 if(selectedText.intern() == "Submit"){
	      	 //Toast.makeText(getApplicationContext(),selectedText, 10).show();
	      	 //Toast.makeText(getApplicationContext(), "Source Destjava..."+ServerIPAddress.getSource(),Toast.LENGTH_LONG).show();
	      	 if(text.intern()== "STOP2"){
	      		destination = 116;
	      	 }else if(text.intern()== "STOP3"){
	      		destination = 170;
	      	 }else if(text.intern()== "STOP4"){
	      		destination = 230;
	      	 }	else if(text.intern()== "STOP5"){
	      		destination = 371;
	      	 }	else if(text.intern()== "STOP6"){
	      		destination = 470;
	      	 }	else if(text.intern()== "STOP7"){
	      		destination = 503;
	      	 }	else if(text.intern()== "STOP8"){
	      		destination = 551;
	      	 }	else if(text.intern()== "STOP9"){
	      		destination = 666;
	      	 } if(ServerIPAddress.getSource().intern()== "STOP1"){
	      		source = 52;
	      	 } if(ServerIPAddress.getSource().intern()== "STOP2"){
	      		source = 116;
	      	 } if(ServerIPAddress.getSource().intern()== "STOP3"){
	      		source = 170;
	      	 }	 if(ServerIPAddress.getSource().intern()== "STOP4"){
	      		source = 230;
	      	 }	 if(ServerIPAddress.getSource().intern()== "STOP5"){
	      		source = 371;
	      	 }	 if(ServerIPAddress.getSource().intern()== "STOP6"){
	      		source = 470;
	      	 }	 if(ServerIPAddress.getSource().intern()== "STOP7"){
	      		source = 503;
	      	 }	 if(ServerIPAddress.getSource().intern()== "STOP8"){
	      		source = 551;
	      	 }	 if(ServerIPAddress.getSource().intern()== "STOP9"){
	      		source = 666;
	      	 }	
	      	  String uLoc = ""+source;
	      	  String uDest = ""+destination;
	      	  getConnection(uLoc,uDest);
	      	 }else{
	      		text = selectedText.trim();
	      		Toast.makeText(getApplicationContext(), "Destination selected...."+text,Toast.LENGTH_LONG).show();
	      		ServerIPAddress.setDestination(text);
	      	 }
	       }
	   });
	 }

	private void getConnection(String source,String destination){
		 try {
			 Toast.makeText(getApplicationContext(), destination, 10).show();
			 Toast.makeText(getApplicationContext(), source, 10).show();
	    	httpclient = new DefaultHttpClient();
	    	HttpGet httpget = new HttpGet("http://"+ServerIPAddress.getIpaddress()+":8080/LBS/UserLoc?uLoc="+source+"&uDest="+destination);
	        response = httpclient.execute(httpget);
	        HttpEntity entity = response.getEntity();
	        responseText = EntityUtils.toString(entity);
	        Log.v("Exception",  responseText.toString());
	        Toast.makeText(getApplicationContext(), responseText.toString(),Toast.LENGTH_LONG).show();
	        
	           
	      }catch (Exception e){
	        Toast.makeText(this, "error"+e.toString(), Toast.LENGTH_LONG).show();
	        
	    }
	}
	  
}