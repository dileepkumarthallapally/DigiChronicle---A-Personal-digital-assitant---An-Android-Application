package dlp.android.digichronicle;


import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class tasks extends Activity {
	Button btntk1,btntk2,btntk3;
	string displ;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.tasks);
    
    	btntk1=(Button)findViewById(R.id.btntk1);
    	btntk1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i1=new Intent(tasks.this,displ.class);
			startActivity(i1);
			}
		});
    	btntk2=(Button)findViewById(R.id.btntk2);
    	btntk2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			Intent i2=new Intent(tasks.this,displ.class);
			startActivity(i2);
			}
		});
    	btntk3=(Button)findViewById(R.id.btntk3);
    	btntk3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent i3=new Intent(tasks.this,dlt.class);
				startActivity(i3);
			}
		});
    	
    }
    
	}

