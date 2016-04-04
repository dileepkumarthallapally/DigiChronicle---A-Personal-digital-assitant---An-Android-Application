package dlp.android.digichronicle;


import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class memo extends Activity {
	Button btnm1,btnm2,btnm3;
	string displ;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	
        setContentView(R.layout.memo);
        	btnm1=(Button)findViewById(R.id.btnm1);
        	btnm1.setOnClickListener(new OnClickListener() {
    	
    			@Override
    			public void onClick(View v) {
    				
    				Intent i1=new Intent(memo.this,displ.class);
    				startActivity(i1);
    			}
    		});
        	
        	btnm2=(Button)findViewById(R.id.btnm2);
        	btnm2.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				    				Intent i2=new Intent(memo.this,displ.class);
    			startActivity(i2);
    			}
    		});
        	btnm3=(Button)findViewById(R.id.btnm3);
        	btnm3.setOnClickListener(new OnClickListener() {
    			
    			@Override
    			public void onClick(View v) {
    				
    				Intent i3=new Intent(memo.this,dlt.class);
    			startActivity(i3);
    			}
    		});
        	
        
    
	}
	}
