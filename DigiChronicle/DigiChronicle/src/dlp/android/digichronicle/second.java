package dlp.android.digichronicle;



import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.TextView;

public class second extends Activity {
	Button btn21,btn22,btn23,btn24,btn25;
	TextView tv1;
	SQLiteDatabase Mydatabase;
	public static String ge="";
		public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.second);
      tv1=(TextView)findViewById(R.id.tv1);
 	  btn21=(Button)findViewById(R.id.btn21);
 	btn22=(Button)findViewById(R.id.btn22);
 	btn23=(Button)findViewById(R.id.btn23);
 	btn24=(Button)findViewById(R.id.btn24);
 	btn25=(Button)findViewById(R.id.btn25);

 	btn21.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ge=btn21.getText().toString();
			Intent i2=new Intent(second.this,memo.class);
			startActivity(i2);
		}
	});
 	
 	
 	btn22.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ge = btn22.getText().toString();
		Intent i3=new Intent(second.this,tasks.class);
		startActivity(i3);
		}
	});
 		btn23.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ge=btn23.getText().toString();
			Intent i4=new Intent(second.this,events.class);
			startActivity(i4);
			}
		});
 		
 		
 	
 	btn25.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			ge=btn25.getText().toString();
		Intent i6=new Intent(second.this,accounts.class);
			startActivity(i6);
		}
	});
}
}