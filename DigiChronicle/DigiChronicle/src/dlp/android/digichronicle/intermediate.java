package dlp.android.digichronicle;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class intermediate extends Activity{
	DBHandandler  myDbHelper=new DBHandandler(this);
	SQLiteDatabase Mydatabase;
	float inc,exp;
	String s1,s2,s3;
	String stattionlist,DBname="widgets";
	@SuppressWarnings("unchecked")
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myDbHelper = new DBHandandler(this);
         Bundle b=getIntent().getExtras();
        {
        	inc=b.getFloat("inc");
        	exp=b.getFloat("exp");
        	
        	
        	 try {
        			FetchingData();
        			myDbHelper.openDataBase();
        	
        	  		Mydatabase = myDbHelper.getWritableDatabase();
        	
        	  		
        	
        	  		String s2 =second.ge;
        	  		
        	  		if(s2.equalsIgnoreCase("accounts")){
        	  		 myDbHelper.updateacc("income","exp",Mydatabase,inc,exp);
        	  		
        	
        	  		  }
        	  	   
        	  		
        	  		Toast.makeText(getApplicationContext(), "Updated Accounts",Toast.LENGTH_LONG).show();
        	  		
        	  		
        			} catch (SQLException e) {
        	 			 //TODO Auto-generated catch block
        	 			e.printStackTrace();
        	 		}
        	 
        	   	myDbHelper.close();
        	   	Mydatabase.close();
        	   	
        	
        	   		
        		}
		   Intent i3=new Intent(intermediate.this,accounts.class);
   		startActivity(i3);
        	 
        	   }
	
   	private void FetchingData() {
		
		
		 try {  
   			 
	        	myDbHelper.onCreateDataBase();
	        	       	
	        	
	 	} catch (IOException ioe) {
	 
	 		throw new Error("Unable to create database");
	 
	 	} 
	 	try {
	 
	 		myDbHelper.openDataBase();
	 		Mydatabase = myDbHelper.getWritableDatabase();
			
	 	
	 	}catch(SQLException sqle){
	 
	 		throw sqle;
	 
	 	}
 
	}
   	

}


