package alx.dices;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener; 
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	private int mCounter=0;
	private Button mK10;
	private Button mK100;

	private Button mRzut1;
	private Button mRzut10;
	private Button mRzut2;
	private Button mRzut20; //// by³o TextView
	private Button mRzucaj;
	private int k = 10;
	private int number_result;
	private int x = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mK10 = (Button)findViewById(R.id.przyciskK10);
		mK100 = (Button)findViewById(R.id.przyciskK100); 
		mRzut1 = (Button)findViewById(R.id.liczba1);
		mRzut10 = (Button)findViewById(R.id.liczba10);
		mRzut2 = (Button)findViewById(R.id.liczba2);
		mRzut20 = (Button)findViewById(R.id.liczba20);
		mRzucaj = (Button)findViewById(R.id.rzucaj);

		
		
		mK10.setOnClickListener(this);
		mK100.setOnClickListener(this);
		
		mRzut1.setOnClickListener(this);
		mRzut10.setOnClickListener(this);
		mRzut2.setOnClickListener(this);
		mRzut20.setOnClickListener(this);
		mRzucaj.setOnClickListener(this);
		Rand.get();
	}

	@Override
	public void onClick(View v) {
		int id = v.getId();
		String wynik = "";

		switch(id){
		case R.id.przyciskK10:
			x = 1;
			if (mCounter == 0){
				mRzut1.setText("");
				mRzut1.setVisibility(View.VISIBLE);
				mRzut10.setVisibility(View.INVISIBLE);
				mRzut2.setVisibility(View.INVISIBLE);
				mRzut20.setVisibility(View.INVISIBLE);
				mCounter++;
			}else if(mCounter == 1){
				mRzut10.setText("");
				mRzut10.setVisibility(View.VISIBLE);
				mRzut2.setVisibility(View.INVISIBLE);
				mRzut20.setVisibility(View.INVISIBLE);
				mCounter++;
			}else if(mCounter == 2){
				mRzut2.setText("");
				mRzut2.setVisibility(View.VISIBLE);
				mRzut20.setVisibility(View.INVISIBLE);
				mCounter++;
			}else if(mCounter == 3){
				mRzut20.setText("");
				mRzut20.setVisibility(View.VISIBLE);
				mCounter++;
			}else {
				mRzut1.setVisibility(View.INVISIBLE);
				mRzut10.setVisibility(View.INVISIBLE);
				mRzut2.setVisibility(View.INVISIBLE);
				mRzut20.setVisibility(View.INVISIBLE);
				mCounter = 0;
			}
			
			break;
		case R.id.przyciskK100: 
			x = 10;
			if (mCounter == 0){
				mRzut1.setText("");
				mRzut10.setText("");
				mRzut2.setText("");
				mRzut20.setText("");
				mRzut1.setVisibility(View.VISIBLE);
				mRzut10.setVisibility(View.VISIBLE);
				mRzut2.setVisibility(View.INVISIBLE);
				mRzut20.setVisibility(View.INVISIBLE);
				mCounter = mCounter+10;
			}else{
				mRzut1.setVisibility(View.INVISIBLE);
				mRzut10.setVisibility(View.INVISIBLE);
				mRzut2.setVisibility(View.INVISIBLE);
				mRzut20.setVisibility(View.INVISIBLE);
				mCounter = 0;
			}
			break;
			
		case R.id.liczba1:
			number_result = rzucaj();
			if (x==10) wynik += number_result+"0";
			else wynik += number_result;
			mRzut1.setText(wynik);
			wynik = "";
			break;
			
		case R.id.liczba10:
			number_result = rzucaj();
			wynik += number_result;
			mRzut10.setText(wynik);
			wynik = "";
			break;
			
		case R.id.liczba2:
			number_result = rzucaj();
			if (x==10) wynik += number_result+"0";
			else wynik += number_result;
			mRzut2.setText(wynik);
			wynik = "";
			break;
			
		case R.id.liczba20:
			number_result = rzucaj();
			if (x==10) wynik += number_result+"0";
			else wynik += number_result;
			mRzut20.setText(wynik);
			wynik = "";
			break;
			
		case R.id.rzucaj:
			number_result = rzucaj();
			if (x==10) wynik += number_result+"0";
			else wynik += number_result;
			mRzut1.setText(wynik);
			wynik = "";
			
			number_result = rzucaj();
			wynik += number_result;
			mRzut10.setText(wynik);
			wynik = "";
			
			number_result = rzucaj();
			wynik += number_result;
			mRzut2.setText(wynik);
			wynik = "";
			
			number_result = rzucaj();
			wynik += number_result;
			mRzut20.setText(wynik);
			wynik = "";
			
			break;
		}
	}

	private int rzucaj() {
		int rzut = 0;
		int a = 0;

		for (int j=0 ; j<1 ; j++){
			rzut = Rand.get().nextInt(k) + rzut;
		} 
		//a = rzut/2;
		a = rzut;
		
		return a;
	}
}
