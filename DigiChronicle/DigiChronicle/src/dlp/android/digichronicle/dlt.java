package dlp.android.digichronicle;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class dlt extends Activity{
	DBHandandler  myDbHelper=new DBHandandler(this);
	SQLiteDatabase Mydatabase;
	String s;
	String stattionlist,DBname="widgets";
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myDbHelper = new DBHandandler(this);
         Bundle b=getIntent().getExtras();
              	s="";
       	     	 try {
        			FetchingData();
        			myDbHelper.openDataBase();

        	  		Mydatabase = myDbHelper.getWritableDatabase();
        	  		
        	  		
        	  		
        	  		String s2 =second.ge;
        	  		
        	  		if(s2.equalsIgnoreCase("memo")){
        	  		 myDbHelper.updateevent("memo",Mydatabase,s);
        	  		
        	  		  }
        	  	    else if(s2.equalsIgnoreCase("reminder"))
        	  	    	myDbHelper.updateevent("reminder",Mydatabase,s);
        	  	   else if(s2.equalsIgnoreCase("tasks"))
        	  		 myDbHelper.updateevent("tasks",Mydatabase,s);
        	  	   else if(s2.equalsIgnoreCase("events"))
        	  		 myDbHelper.updateevent("events",Mydatabase,s);
        	  	   else if(s2.equalsIgnoreCase("accounts"))
        	  		 myDbHelper.updateevent("accounts",Mydatabase,s);
        	  		
        	  		
        	  		Toast.makeText(getApplicationContext(), "updated",Toast.LENGTH_LONG).show();
        	  		
        	  		
        			} catch (SQLException e) {
        	 		
        	 			e.printStackTrace();
        	 		}
        	   	myDbHelper.close();
        	   	Mydatabase.close();
        	   	
        	   	
        	   	Intent i3=new Intent(dlt.this,second.class);
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
			System.out.println("executed");
	 	
	 	}catch(SQLException sqle){
	 
	 		throw sqle;
	 
	 	}
 
	}
}


