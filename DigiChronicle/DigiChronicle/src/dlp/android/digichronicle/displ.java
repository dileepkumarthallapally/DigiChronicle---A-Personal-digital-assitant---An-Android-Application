package dlp.android.digichronicle;


import java.io.IOException;
import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class displ extends Activity implements View.OnClickListener  {
Button btnf;
TextView tvf;
EditText edtf,edt2;

/** Called when the activity is first created. */
 


 DBHandandler  myDbHelper=new DBHandandler(this);
SQLiteDatabase Mydatabase;
String stattionlist,s1;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.displ);	
    tvf=(TextView)findViewById(R.id.tvf);
    edtf=(EditText)findViewById(R.id.edtf);
    edt2=(EditText)findViewById(R.id.edt2);
    btnf=(Button)findViewById(R.id.btnf);
    btnf.setOnClickListener(this);
first();
}

private void first() {
	String s1="",s2=second.ge;
	 this.myDbHelper = new DBHandandler(this);
	 try {
			FetchingData();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	 myDbHelper.openDataBase();
		Mydatabase = myDbHelper.getWritableDatabase();
	Mydatabase =  myDbHelper.getReadableDatabase();
	  if(s2.equalsIgnoreCase("memo")){
		  s1=myDbHelper.open("memo",Mydatabase);

		  }
	    else if(s2.equalsIgnoreCase("reminder"))
	    	s1=myDbHelper.open("reminder",Mydatabase);
	   else if(s2.equalsIgnoreCase("tasks"))
		   s1=myDbHelper.open("tasks",Mydatabase);
	   else if(s2.equalsIgnoreCase("events"))
		  s1= myDbHelper.open("events",Mydatabase);
	   else if(s2.equalsIgnoreCase("accounts"))
		  s1= myDbHelper.open("accounts",Mydatabase);
	    System.out.println("after open");
	    	
	    edtf.setText(s1);

		edtf.setMovementMethod(new ScrollingMovementMethod());
		tvf.setText(s2);
}

private void FetchingData() throws SQLException {
	// TODO Auto-generated method stub
	
	 try {  
	      	myDbHelper.onCreateDataBase();
          	
 	} catch (IOException ioe) {
 
 		throw new Error("Unable to create database");
 
 	} 
}

@Override
public void onClick(View v) {
	if (v==btnf)
	{
		   s1=edtf.getText().toString();
		Intent i3=new Intent(displ.this,inter.class);
		i3.putExtra("value",s1);
		startActivity(i3);
	   	
	}
}
 	}
   
