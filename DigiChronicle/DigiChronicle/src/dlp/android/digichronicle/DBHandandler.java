package dlp.android.digichronicle; // ur package name

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBHandandler extends SQLiteOpenHelper{
	private static String DB_PATH = "/data/data/dlp.android.digichronicle/databases/";
	  private static String DB_NAME = "widget.sqlite";
	   private static String TABLENAME = "widgets";
	   private SQLiteDatabase myDataBase;   
	   private final Context myContext;
       public static final String KEY_MEM = "memo";
       public static final String KEY_TAS = "tasks";
       public static final String KEY_REM = "reminder";
       public static final String KEY_EVE = "events";
       public static final String KEY_DAT = "dated";
       public static final String KEY_INC = "income";
       public static final String KEY_EXP = "exp";
	   ArrayList<String> sw;
	   String s="";
	public DBHandandler(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
		  this.myContext = context;
	}
	public int onCreateDataBase() throws IOException
	{
		boolean dbExist=checkDatabase();
		if(dbExist){
   		 return 0;
   	}
		else{
   	 	
       	this.getReadableDatabase();
       				copyDataBase();
   			return 1;	
   		
   	}
	}
	private boolean checkDatabase() {
		// TODO Auto-generated method stub
		SQLiteDatabase checkDB=null;
		try
		{
			String myPath = DB_PATH + DB_NAME;
			checkDB=SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		if(checkDB != null){
			 
    		checkDB.close();
 
    	}
		return checkDB != null ? true: false ;
		
	
	}
	private void copyDataBase() throws IOException{
		
		InputStream myInput=myContext.getAssets().open(DB_NAME);
			String outFileName = DB_PATH + DB_NAME;
		OutputStream myOutput = new FileOutputStream(outFileName);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer))>0){
			myOutput.write(buffer, 0, length);
		}
		myOutput.flush();
		myOutput.close();
		myInput.close();
		
		}
		
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	 public void openDataBase() throws SQLException{
    	 
	    
	        String myPath = DB_PATH + DB_NAME;
	    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
	    
	    }
	 	
	 public	String open(String s3,SQLiteDatabase Mydatabase)
	 {
	    		ArrayList<String> list=new ArrayList<String>();
	    		  
	    		String s="";
	    		 try{
	    		   	   
	    		   	String dt=MainActivity.g;
	    		   
	    			Cursor c = Mydatabase.rawQuery("select "+" "+s3+" "+"from widgets where dated='"+dt+"'",null);
	    			
	    		 if(c.moveToFirst())  
	    			{
	    			 
	    			
	    				do{ 	
	    					list.add(c.getString(c.getColumnIndex(s3)));
	    					    				
	    				}while(c.moveToNext());  
	    			}
	    				c.close();
	    		 }
	    		 catch(SQLiteException se){
	    			Mydatabase.close();
	    			
	    		}

	    	s=list.toString();
	    	int len=s.length();
	    		s=s.substring(1, len-1);
	    	return s;
	    	
	 }
  public String eventdia(SQLiteDatabase mydatabase1){
	    	
	    

    		ArrayList<String> list=new ArrayList<String>();
    	
    		String s="";
    		 try{
    	  
    		   	String dt=MainActivity.g;
    	
    			Cursor c = mydatabase1.rawQuery("select events from widgets where dated='"+dt+"'",null);
    			
    		 if(c.moveToFirst())  
    			{
    			 System.out.println("cursor"+c.moveToFirst());
    				do{ 	
    					list.add(c.getString(c.getColumnIndex("events")));  
    					
    				
    				}while(c.moveToNext());  
    			}
    				c.close();
    		 }
    		 catch(SQLiteException se){
    			mydatabase1.close();
    			
    		}

    	s=list.toString();
    	int len=s.length();
    		s=s.substring(1, len-1);
    	return s;
    	}
  public String checkin(SQLiteDatabase mydatabase1){
	  
	  ArrayList<String> list=new ArrayList<String>();
	  
	String s="";
	 try{
	    
	   	String dt=MainActivity.g;
	  
		Cursor c = mydatabase1.rawQuery("select events from widgets where dated='"+dt+"'",null);
		
	 if(c.moveToFirst())  
		{
		
			do{ 	
				list.add(c.getString(c.getColumnIndex("events")));  
		
			
			}while(c.moveToNext());  
		}
			c.close();
	 }
	 catch(SQLiteException se){
		mydatabase1.close();
		
	}

s=list.toString();
int len=s.length();
	s=s.substring(1, len-1);
return s;

  }
  
  
		public void updateevent(String ge,SQLiteDatabase mydatabase2, String s1) {
					String dt=MainActivity.g;
		ContentValues cvupdate=new ContentValues();
			cvupdate.put(ge, s1);

			String strFilter = "dated=" + dt;
			
			mydatabase2.update(TABLENAME, cvupdate, KEY_DAT+"=?",new String[]{dt});
		   

			
		}
		
		public void Insertinto(SQLiteDatabase mydatabase2,String date ,String memo, String tasks , String reminder,float income,String events,float exp)
	    {
	       ContentValues data=createContentValues(date, memo, tasks,reminder,income,events,exp);

	       mydatabase2.insert(TABLENAME, null, data);

	       
	    }
	   
	   
	    private ContentValues createContentValues(String date ,String memo, String tasks , String reminder,float income,String events,float exp)
	    {
	              ContentValues values = new ContentValues();
	              values.put(KEY_DAT, date);
	              values.put(KEY_MEM, memo);
	              values.put(KEY_TAS, tasks);
	              values.put(KEY_REM, reminder);
	              values.put(KEY_INC, income);
	              values.put(KEY_EVE, events);
	              values.put(KEY_EXP, exp);
	              
	             
	              return values;
	    }
		public void updateacc(String inccol,String expcol, SQLiteDatabase mydatabase2,
				float inc,float exp) {
			String dt=MainActivity.g;

			
			ContentValues cvupdate=new ContentValues();
			cvupdate.put(expcol,exp );
			cvupdate.put(inccol,inc);


			mydatabase2.update(TABLENAME, cvupdate, KEY_DAT+"=?",new String[]{dt});
		    System.out.println("###### after query update in acc");
		}
		
		
		
		public ArrayList<Float> calc(SQLiteDatabase mydatabase2,String colname,String frm,String to) {

			
			ArrayList<Float> list=new ArrayList<Float>();

 		String s="";
 		 try{
 			
  		   frm=frm+" "+"00:00:00";
  		   to=to+" "+"00:00:00";
 		   	String dt=MainActivity.g;

 		   	Log.e("colname",colname);
 		   Cursor c = mydatabase2.rawQuery("SELECT exp FROM widgets WHERE  dated  BETWEEN '"+" "+frm+"'" +" "+"AND"+" "+"'"+to+"'",null);
 			//Cursor c = mydatabase2.rawQuery("SELECT exp FROM widgets WHERE  dated  BETWEEN '2012-10-22 00:00:00' AND '2012-11-21 00:00:00'",null);

 			
 		 if(c.moveToFirst())  
 			{

 				do{ 	
 					list.add(c.getFloat(c.getColumnIndex("exp")));  

 				
 				}while(c.moveToNext());  
 			}
 				c.close();
 		 }
 		 catch(SQLiteException se){
 			mydatabase2.close();

 		}

 	return list;

		
		}
		public ArrayList<Float> calc1(SQLiteDatabase mydatabase2,String frm,String to) {

			
			ArrayList<Float> list=new ArrayList<Float>();

 		String s="";
 		 try{
 			
  		   frm=frm+" "+"00:00:00";
  		   
  		   to=to+" "+"00:00:00";
  
 		   	String dt=MainActivity.g;

 		   	Log.e("calc11111111111","doneee");
 		   	String rq="SELECT inc FROM widgets WHERE  dated  BETWEEN '"+" "+frm+"'" +" "+"AND"+" "+to+"'";
 		   	Log.e("query is",rq);
 		   Cursor c = mydatabase2.rawQuery("SELECT inc FROM widgets WHERE  dated  BETWEEN '"+" "+frm+"'" +" "+"AND"+" "+"'"+to+"'",null);
 			//Cursor c = mydatabase2.rawQuery("SELECT inc FROM widgets WHERE  dated  BETWEEN '2012-10-22 00:00:00' AND '2012-11-21 00:00:00'",null);
 		   	
 		 if(c.moveToFirst())  
 			{

 				do{ 	
 					list.add(c.getFloat(c.getColumnIndex("inc")));  
    
 				}while(c.moveToNext());  
 			}
 				c.close();
 		 }
 		 catch(SQLiteException se){
 			mydatabase2.close();

 		}

 	return list;
		}
		
		public void delall(SQLiteDatabase mydatabase2) {
			// TODO Auto-generated method stub
			try{
	 			mydatabase2.delete(TABLENAME, null,null);
			}
	 		  catch(SQLiteException se){
	 			mydatabase2.close();
	 	
	 		}
		}
}
