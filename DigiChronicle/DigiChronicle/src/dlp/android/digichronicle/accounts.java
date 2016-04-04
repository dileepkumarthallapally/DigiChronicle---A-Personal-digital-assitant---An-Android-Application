package dlp.android.digichronicle;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class accounts extends Activity implements View.OnClickListener  {
	public static String i,e,sa;
		TextView tvc2,tvc3,tvcinc,tvcinc1,tvcexp,tvcexp1,tvcsav,tvcsav1,tvcdate;
	Button btnacc,btndet,btndate,btnok;
	EditText edtcno1,edtcno2,edtdate1,edtdate2;
	DBHandandler  myDbHelper=new DBHandandler(this);
	SQLiteDatabase Mydatabase;
	
	
	public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.myDbHelper = new DBHandandler(this);
        
        Bundle b=getIntent().getExtras();
    	   	
    setContentView(R.layout.accounts);
    tvc2=(TextView)findViewById(R.id.tvc2);
    tvc2.setVisibility(TextView.INVISIBLE);
    tvc3=(TextView)findViewById(R.id.tvc3);
    tvc3.setVisibility(TextView.INVISIBLE);
    tvcinc=(TextView)findViewById(R.id.tvcinc);
    tvcinc.setVisibility(TextView.INVISIBLE);
    tvcinc1=(TextView)findViewById(R.id.tvcinc1);
    tvcinc1.setVisibility(TextView.INVISIBLE);
    tvcexp=(TextView)findViewById(R.id.tvcexp);
    tvcexp.setVisibility(TextView.INVISIBLE);
    tvcexp1=(TextView)findViewById(R.id.tvcexp1);
    tvcexp1.setVisibility(TextView.INVISIBLE);
    tvcdate=(TextView)findViewById(R.id.tvcdate);
    tvcdate.setVisibility(TextView.INVISIBLE);
    tvcsav1=(TextView)findViewById(R.id.tvcsav1);
    tvcsav1.setVisibility(TextView.INVISIBLE);
    tvcsav=(TextView)findViewById(R.id.tvcsav);
    tvcsav.setVisibility(TextView.INVISIBLE);
    btnacc=(Button)findViewById(R.id.btnacc);
    btnacc.setOnClickListener(this);
    btndet=(Button)findViewById(R.id.btndet);
    btndet.setOnClickListener(this);
    btndate=(Button)findViewById(R.id.btndate);
    btndate.setOnClickListener(this);
    btndate.setVisibility(Button.INVISIBLE);
    btnok=(Button)findViewById(R.id.btnok);
    btnok.setOnClickListener(this);
    btnok.setVisibility(Button.INVISIBLE);
    edtcno1=(EditText)findViewById(R.id.edtcno1);
    edtcno1.setVisibility(EditText.INVISIBLE);	
    edtcno2=(EditText)findViewById(R.id.edtcno2);
    edtcno2.setVisibility(EditText.INVISIBLE);	
    edtdate1=(EditText)findViewById(R.id.edtdate1);
    edtdate1.setVisibility(EditText.INVISIBLE);	
    edtdate2=(EditText)findViewById(R.id.edtdate2);
    edtdate2.setVisibility(EditText.INVISIBLE);	
    tvcdate.setVisibility(TextView.INVISIBLE);
    if(b!=null)
	{
		String s1=b.getString("inc");
		String s2=b.getString("exp");
		String s3=b.getString("sav");
		Log.e("inc",s1);
		Log.e("exp",s2);
		Log.e("sav",s3);
		 tvcinc.setVisibility(TextView.VISIBLE);
	     tvcinc1.setVisibility(TextView.VISIBLE);
	     tvcexp.setVisibility(TextView.VISIBLE);
	     tvcexp1.setVisibility(TextView.VISIBLE);
	     tvcsav.setVisibility(TextView.VISIBLE);
	     tvcsav1.setVisibility(TextView.VISIBLE);
		tvcinc1.setText(s1);
		tvcexp1.setText(s2);
		tvcsav1.setText(s3);
		
	}
	else{
		
		 tvcinc.setVisibility(TextView.INVISIBLE);
	     tvcinc1.setVisibility(TextView.INVISIBLE);
	     tvcexp.setVisibility(TextView.INVISIBLE);
	     tvcexp1.setVisibility(TextView.INVISIBLE);
	     tvcsav.setVisibility(TextView.INVISIBLE);
	     tvcsav1.setVisibility(TextView.INVISIBLE);
		
	}
}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==btnacc)
		{
			tvc2.setVisibility(TextView.VISIBLE);
			tvc3.setVisibility(TextView.VISIBLE);
			edtcno1.setVisibility(EditText.VISIBLE);
			edtcno2.setVisibility(EditText.VISIBLE);
			tvcdate.setVisibility(TextView.INVISIBLE);
			btnok.setVisibility(Button.VISIBLE);
			edtcno1.setVisibility(EditText.VISIBLE);	
		    edtcno2.setVisibility(EditText.VISIBLE);	
			    tvcinc.setVisibility(TextView.INVISIBLE);
			    tvcsav1.setVisibility(TextView.INVISIBLE);
			    tvcinc1.setVisibility(TextView.INVISIBLE);
			    tvcexp.setVisibility(TextView.INVISIBLE);
			    tvcexp1.setVisibility(TextView.INVISIBLE);
			    tvcsav.setVisibility(TextView.INVISIBLE);
			    btndate.setVisibility(Button.INVISIBLE);
			    edtdate1.setVisibility(EditText.INVISIBLE);	
			    edtdate2.setVisibility(EditText.INVISIBLE);	
			    
			    
			    
			    
			    
		}    	
		else if(v==btndet)
		{
			
			tvc2.setVisibility(TextView.INVISIBLE);
			tvc3.setVisibility(TextView.INVISIBLE);
			edtcno1.setVisibility(EditText.INVISIBLE);
			edtcno2.setVisibility(EditText.INVISIBLE);
			tvcdate.setVisibility(TextView.VISIBLE);
			btnok.setVisibility(Button.INVISIBLE);
			edtcno1.setVisibility(EditText.INVISIBLE);	
		    edtcno2.setVisibility(EditText.INVISIBLE);
			    tvcinc.setVisibility(TextView.VISIBLE);
			    tvcinc1.setVisibility(TextView.VISIBLE);
			    tvcexp.setVisibility(TextView.VISIBLE);
			    tvcexp1.setVisibility(TextView.VISIBLE);
			    tvcsav.setVisibility(TextView.VISIBLE);
			    tvcsav1.setVisibility(TextView.VISIBLE);
			    btndate.setVisibility(Button.VISIBLE);
			    edtdate1.setVisibility(EditText.VISIBLE);	
			    edtdate2.setVisibility(EditText.VISIBLE);	

		}
		else if(v==btnok){
			float inc,exp;
			String s=edtcno1.getText().toString();
			inc=Float.parseFloat(s);
			String sn=edtcno2.getText().toString();
			exp=Float.parseFloat(sn);
			System.out.println("got from user"+inc+"exp"+exp);
			Intent i3=new Intent(accounts.this,intermediate.class);
			i3.putExtra("inc",(float)inc);
			i3.putExtra("exp",(float)exp);
			startActivity(i3);
		   	}

		else if(v==btndate){
			Intent i2=new Intent(accounts.this,calcok.class);
			String frm=edtdate1.getText().toString();
			String to=edtdate2.getText().toString();
			Log.e("acc->calcok","inbetween intents");
			Log.e("fom",frm);
        	Log.e("to",to);
			i2.putExtra("from",(String)frm);
			i2.putExtra("to",(String) to);
			startActivity(i2);
			}
		}
	}
