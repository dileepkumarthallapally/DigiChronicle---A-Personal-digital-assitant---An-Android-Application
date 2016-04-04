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

public class calcok extends Activity{
	DBHandandler  myDbHelper=new DBHandandler(this);
	SQLiteDatabase Mydatabase;
	float inc,exp;
	String s1,s2,s3;
	String stattionlist,DBname="widgets";
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.myDbHelper = new DBHandandler(this);
        setContentView(R.layout.demo);
         Bundle b=getIntent().getExtras();
System.out.println("Got from acc"+b);
String frm = getIntent().getStringExtra("from");
String to = getIntent().getStringExtra("to");
        if(b!=null)
        {
        	
        	Log.e("frm",frm);
        	Log.e("to",to);
	        	 Log.e("Entered accounts->" +"CALCCCC","");
	        	 try {
	        			FetchingData();
	        			myDbHelper.openDataBase();
	        
	        	  		Mydatabase = myDbHelper.getWritableDatabase();
	        
	        	  		String s =second.ge;
	        	  		
	        	  		if(s.equalsIgnoreCase("accounts")){
	        	  			ArrayList<Float> inclist=new ArrayList<Float>();
	        	  			ArrayList<Float> explist=new ArrayList<Float>();
	        	  			try{
	        	  			 explist =myDbHelper.calc(Mydatabase,"exp",frm,to);
	        	  			 
	        	  			inclist =myDbHelper.calc1(Mydatabase,frm,to);
	        	  			 }
	        	  			 catch(Exception e){
	        	  				 	inclist.add(500.0f);
	        	  				 	explist.add(320.0f);
	        	  			 }
	        	  			float inc= sum(inclist);
	        	  			float exp= sum(explist);
	        	  			float sav=inc-exp;
	        	  			if(sav<0){
	        	  			s3="Deficit Amount";
	        	  			}
	        	  			else
	        	  			{
	        	  				s3=Float.toString(sav);
	        	  			}
	        	  			s1=Float.toString(inc);
	        	  			s2=Float.toString(exp);
	        	  		  }
	        	  	   Toast.makeText(getApplicationContext(), "GOt Details",Toast.LENGTH_LONG).show();
	        	   
	        	 } catch (SQLException e) {
    	 			 //TODO Auto-generated catch block
    	 			e.printStackTrace();
    	 		}
    	   	myDbHelper.close();
    	   	Mydatabase.close();
    	   	Intent i3=new Intent(calcok.this,accounts.class);
 		   i3.putExtra("inc",s1);
 		   i3.putExtra("exp",s2);
 		   i3.putExtra("sav",s3);
    		startActivity(i3);
		   }
		   
		     }
	 public static float sum(ArrayList<Float> list){
	      if(list==null || list.size()<1)
	        return 0;

	      float sum = 0;
	      for(Float i: list)
	        sum = sum+i;

	      return sum;
	    }
	
   	private void FetchingData() {
		
		
		 try {  myDbHelper.onCreateDataBase();
	                
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


