package alx.dices;

import android.os.Bundle;
import android.app.Activity;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener; 
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private Button mK10;
	private Button mK100;
	//private Button mKx;
	private Button mX1; 
	private Button mX2;
	private Button mX3;
	//private Button mX;
	private Button mX4;
	//private TextView mKtv;
	//private TextView mXtv;
	//private TextView Ktv;
	private TextView K10;
	private TextView K1;
	private Button mRzucaj;
	private int k = 100;
	private int x = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mK10 = (Button)findViewById(R.id.K10);
		mK100 = (Button)findViewById(R.id.K100); 
		//mKx = (Button)findViewById(R.id.K);
		mX1 = (Button)findViewById(R.id.x1);
		mX2 = (Button)findViewById(R.id.x2);
		mX3 = (Button)findViewById(R.id.x3);
		mX4 = (Button)findViewById(R.id.x4);
		//mX = (Button)findViewById(R.id.x);
		//mKtv = (TextView)findViewById(R.id.K_txt); 
		//mXtv = (TextView)findViewById(R.id.x_txt);
		//Ktv = (Button)findViewById(R.id.liczby);
		K10 = (Button)findViewById(R.id.liczba10);
		K1 = (Button)findViewById(R.id.liczba1);
		mRzucaj = (Button)findViewById(R.id.rzucaj);
		
		mK10.setOnClickListener(this);
		mK100.setOnClickListener(this);
		//mKx.setOnClickListener(this);
		//mX.setOnClickListener(this);
		mX1.setOnClickListener(this);
		mX2.setOnClickListener(this);
		mX3.setOnClickListener(this);
		mX4.setOnClickListener(this);
		mRzucaj.setOnClickListener(this);
		Rand.get();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch(id){
		case R.id.K10:
			k = 10;
			rzucaj();
			
			break;
		case R.id.K100: 
			k = 100;
			break;
		case R.id.x1:
			x = 1;
			break;
		case R.id.x2:
			x = 2;
			break;
		case R.id.x3:
			x = 3;
			break; 
		case R.id.x4:
			x = 4;
			break;
		case R.id.rzucaj:
			rzucaj();
			break;
		}
		//mStatus.setText("k = "+k+", x = "+x); 
	}

	private void rzucaj() {  
		//String wyniki = "";
		int rzut = 0;
		int a;
		String d10 = "";
		String d20;
		String d1 = "";
		String d2 = "";
		String d3 = "";
		String d4 = "";
		for(int i=0;i<x;i++){

			for (int j=0 ; j<2 ; j++){
				rzut = Rand.get().nextInt(k)+1 + rzut;
			} 
			a = rzut/2;
			//wyniki += (a + " ");

			d10 += ((a/10)*10);
			d1 += (a-((a/10)*10));
			K10.setText(d10);
			K10.setVisibility(View.INVISIBLE);
			K1.setText(d1);
		}
		//Ktv.setText(wyniki);
	}

}
