package dlp.android.digichronicle;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class events extends Activity {
	Button btne1,btne2,btne3;
	string displ;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.events);
  
    
    	btne1=(Button)findViewById(R.id.btne1);
    	btne1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				Intent i1=new Intent(events.this,displ.class);
				startActivity(i1);
			}
		});
    	btne2=(Button)findViewById(R.id.btne2);
    	btne2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				Intent i2=new Intent(events.this,displ.class);
				startActivity(i2);
			}
		});
    	btne3=(Button)findViewById(R.id.btne3);
    	btne3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
	
				Intent i3=new Intent(events.this,dlt.class);
				startActivity(i3);
			}
		});
    	
    
	}
}
