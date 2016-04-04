package dlp.android.digichronicle;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity  implements View.OnClickListener{
	Button btn1,okbtn,resetbtn;
	TextView tv31;
	EditText edt2;
	
	
	
	public static String g="";
	
	
	SQLiteDatabase Mydatabase;
	DBHandandler  myDbHelper=new DBHandandler(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myDbHelper = new DBHandandler(this);
         FirstPage();
    
    }
    

    public void FirstPage(){
    	setContentView(R.layout.activity_main);
    	btn1=(Button)findViewById(R.id.btn1);
    	resetbtn=(Button)findViewById(R.id.resetbtn);
   	 btn1.setVisibility(Button.INVISIBLE);
    	okbtn=(Button)findViewById(R.id.okbtn);
    	btn1.setOnClickListener(this);
    	okbtn.setOnClickListener(this);
    	resetbtn.setOnClickListener(this);
    	edt2=(EditText)findViewById(R.id.edt2);
    	
    	   Log.d("Testing", "Checkpoint 1");
        	
    	 }
    
  
  public void ThirdPage(){
	    
	  
  }

    public void dia(String dia){
    	if(dia.equalsIgnoreCase(""))
    			{
    		
    		dia="No Event today";
    			}
    	Context context = MainActivity.this;
        AlertDialog.Builder ad = new AlertDialog.Builder(context);
        ad.setMessage(dia);
        ad.setTitle("Events");
        ad.setPositiveButton("Done",
        new OnClickListener() {
        public void onClick(DialogInterface dialog,
        int arg1) { }
        });
        ad.setCancelable(true);
        ad.show();
    	
    }
    
    public void test(){
    	Context context = MainActivity.this;
        AlertDialog.Builder adc = new AlertDialog.Builder(context);
        adc.setTitle("Reset");
        adc.setMessage("Are you sure to clear all the data?");
        adc.setPositiveButton("yes",
        new OnClickListener() {
        public void onClick(DialogInterface dialog,
        int arg1) { 
        	
        	try {
	  			FetchingData();
	  			myDbHelper.openDataBase();
    	  		Mydatabase = myDbHelper.getWritableDatabase();
    	  		g=edt2.getText().toString();
    	  		String chk=myDbHelper.checkin(Mydatabase);
    	  		if(chk.isEmpty()){
    	  		myDbHelper.delall(Mydatabase);
    	  		}
 	  		} catch (SQLException e) {
	  			 //TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}
        }
        });
        adc.setNegativeButton("Cancel",
                new OnClickListener() {
            public void onClick(DialogInterface dialog,
            int arg1) { }
            });
        adc.setCancelable(true);
        adc.show();
    	
    }
public void onClick(View v){
	   Log.d("Testing", "Checkpoint 2");
	if(v==btn1)
	{
		Intent i1=new Intent(MainActivity.this,second.class);
		startActivity(i1);
	}  
	if(v==resetbtn){
		
		test();
		
		Toast.makeText(getBaseContext()," Action successful :) ",Toast.LENGTH_SHORT).show();
	}
	if(v==okbtn){
		
    	  	g=edt2.getText().toString();
    	  	btn1.setVisibility(Button.VISIBLE);
    	  	if(g.equalsIgnoreCase("")){
    	  		Toast.makeText(getBaseContext()," Please Remember to enter Date :) ",Toast.LENGTH_SHORT).show();	
    	  		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	        Date date = new Date();
    	        String ge=dateFormat.format(date);
    	        ge=date.toString();
    	       
    	         try {
					date = dateFormat.parse(ge);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
    	        
    	         SimpleDateFormat postFormater = new SimpleDateFormat("yyyy-MM-dd"); 
    	         ge = postFormater.format(date); 
    	         edt2.setText(ge);
    	    	 g=edt2.getText().toString();
    	    	  	
    	  	}
    	  	
    	  	if(!(g.equalsIgnoreCase(""))){
    	  		
    	  		try {
    	  			FetchingData();
    	  			myDbHelper.openDataBase();
        	  		Mydatabase = myDbHelper.getWritableDatabase();
        	  		g=edt2.getText().toString();
        	  		String chk=myDbHelper.checkin(Mydatabase);
        	  		if(chk.isEmpty()){
        	  		myDbHelper.Insertinto(Mydatabase,g ,"hey memo", "" , "",0,"events ra",0);
        	  		 Toast.makeText(this,"Record Inserted", Toast.LENGTH_SHORT).show();
        	  		}
            	  	g=edt2.getText().toString();
        	  	  	
            	  	
    	  		} catch (SQLException e) {

    	  			e.printStackTrace();
    	  		}
    	  		
    	  		String di=myDbHelper.eventdia(Mydatabase);
    	  		dia(di);
    	  		myDbHelper.close();
		    	Mydatabase.close();
		    	
    	  		
    	  	}
    	  	g=edt2.getText().toString();
	}
	
	}

    	  	
 	private void FetchingData() throws SQLException {
    	  		   	  		
    	  		 try {  
    	  		      	myDbHelper.onCreateDataBase();
      	
    	  	 	} catch (IOException ioe) {
    	  	 
    	  	 		throw new Error("Unable to create database");
    	  	 	} 
    	  	}
    	  	}

