package alx.dices;

import android.os.Bundle;
import android.app.Activity;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener; 
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private int mCounter=0;
	private Button mK10;
	private Button mK100;
	private TextView K1;
	private TextView K10;
	private TextView K2;
	private TextView K20;
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
		//mX = (Button)findViewById(R.id.x);
		//mKtv = (TextView)findViewById(R.id.K_txt); 
		//mXtv = (TextView)findViewById(R.id.x_txt);
		//Ktv = (Button)findViewById(R.id.liczby);
		K1 = (Button)findViewById(R.id.liczba1);
		K10 = (Button)findViewById(R.id.liczba10);
		K2 = (Button)findViewById(R.id.liczba2);
		K20 = (Button)findViewById(R.id.liczba20);
		mRzucaj = (Button)findViewById(R.id.rzucaj);
		
		mK10.setOnClickListener(this);
		mK100.setOnClickListener(this);
		//mKx.setOnClickListener(this);
		//mX.setOnClickListener(this);
		mRzucaj.setOnClickListener(this);
		Rand.get();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		String wynik = "";
		
		switch(id){
		case R.id.K10:
			if (mCounter == 0){
				k=10;
				wynik += rzucaj();
				K1.setText(wynik);
				K1.setVisibility(View.VISIBLE);
				K10.setVisibility(View.INVISIBLE);
				K2.setVisibility(View.INVISIBLE);
				K20.setVisibility(View.INVISIBLE);
				mCounter++;
			}else if(mCounter == 1){
				k=10;
				wynik += rzucaj();
				K10.setText(wynik);
				K10.setVisibility(View.VISIBLE);
				mCounter++;
			}else if(mCounter == 2){
				k=10;
				wynik += rzucaj();
				K2.setText(wynik);
				K2.setVisibility(View.VISIBLE);
				mCounter++;
			}else if(mCounter == 3){
				k=10;
				wynik += rzucaj();
				K20.setText(wynik);
				K20.setVisibility(View.VISIBLE);
				mCounter++;
			}else {
				K1.setVisibility(View.INVISIBLE);
				K10.setVisibility(View.INVISIBLE);
				K2.setVisibility(View.INVISIBLE);
				K20.setVisibility(View.INVISIBLE);
				mCounter = 0;
			}
			
			break;
		case R.id.K100: 
			if (mCounter == 0){
				k=10;
				wynik += 10*rzucaj();
				K1.setText(wynik);
				wynik = "";
				wynik += rzucaj();
				K10.setText(wynik);
				K1.setVisibility(View.VISIBLE);
				K10.setVisibility(View.VISIBLE);
				K2.setVisibility(View.INVISIBLE);
				K20.setVisibility(View.INVISIBLE);
				mCounter = mCounter+10;
			}else if(mCounter == 10){
				k=10;
				wynik += 10*rzucaj();
				K2.setText(wynik);
				wynik = "";
				wynik += rzucaj();
				K20.setText(wynik);
				K2.setVisibility(View.VISIBLE);
				K20.setVisibility(View.VISIBLE);
				mCounter = mCounter+10;
			}else{
				K1.setVisibility(View.INVISIBLE);
				K10.setVisibility(View.INVISIBLE);
				K2.setVisibility(View.INVISIBLE);
				K20.setVisibility(View.INVISIBLE);
				mCounter = 0;
			}
			break;
		case R.id.rzucaj:
			K1.setVisibility(View.INVISIBLE);
			K10.setVisibility(View.INVISIBLE);
			K2.setVisibility(View.INVISIBLE);
			K20.setVisibility(View.INVISIBLE);
			break;
		}
		//mStatus.setText("k = "+k+", x = "+x); 
	}

	private int rzucaj() {
		String wynik = "";
		int rzut = 0;
		int a = 0;
		//String d10 = "";
		//String d20;
		//String d1 = "";
		//String d2 = "";
		//String d3 = "";
		//String d4 = "";
		for(int i=0;i<x;i++){

			for (int j=0 ; j<2 ; j++){
				rzut = Rand.get().nextInt(k)+1 + rzut;
			} 
			a = rzut/2;
			//wyniki += (a + " ");

			//d10 += ((a/10)*10);
			//d1 += (a-((a/10)*10));
			//K10.setText(d10);
			//K10.setVisibility(View.INVISIBLE);
			//K1.setText(d1);
			//wynik += (a);
		}
		return a;
	}

}
