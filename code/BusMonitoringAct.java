package com.android;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BusMonitoringAct extends Activity {
    /** Called when the activity is first created. */
 
    
    HttpResponse response;
	HttpClient httpclient;
	String userMobile = null;
	String responseText;
	protected Intent intent;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText txt_uname = (EditText)findViewById(R.id.txt_uname);
        final EditText txt_pass = (EditText)findViewById(R.id.txt_pass);
        final EditText txt_ip = (EditText)findViewById(R.id.txt_ip);
        
        Button submit = (Button)findViewById(R.id.submit);
        Button reset = (Button)findViewById(R.id.reset);
        
        submit.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        	  	if((txt_uname.getText().toString().intern()== "dhana") && (txt_pass.getText().toString().intern()== "sudha")){
        	  		ServerIPAddress.setIpaddress(txt_ip.getText().toString());
        	  		Toast.makeText(getApplicationContext(), "Logged in",10).show();
 intent = new Intent(BusMonitoringAct.this,Menu.class);
        	  		startActivity(intent);
             }else{
            	 Toast.makeText(getApplicationContext(), "Invalid user Name and Password", Toast.LENGTH_SHORT).show();
            	 txt_uname.setText("");
         		txt_pass.setText("");
         		txt_ip.setText("");
             }
        	}
        });
        reset.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		txt_uname.setText("");
        		txt_pass.setText("");
        		txt_ip.setText("");
        	}
             	
        });
                   
  }
    
  
}