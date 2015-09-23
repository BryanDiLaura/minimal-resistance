package com.example.minimalresistance;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnItemSelectedListener {

	//define class-wide variables
	public double FIRST_VALUE = 0;
	public double SECOND_VALUE = 0;
	public double MULTIPLIER = 0;
	public double TOLERANCE = 0;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//find spinners
		Spinner color1 = (Spinner) findViewById(R.id.first_spin);
		Spinner color2 = (Spinner) findViewById(R.id.second_spin);
		Spinner multiplier = (Spinner) findViewById(R.id.multiplier);
		Spinner tolerance = (Spinner) findViewById(R.id.tolerance);
		
		
		//changes string array "resistor_colors" to an ArrayAdapter in the format of the default spinner item
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.resistor_colors, 
				android.R.layout.simple_spinner_item);
		//specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//changes string array "resistor_colors" to an ArrayAdapter in the format of the default spinner item
		ArrayAdapter<CharSequence> tolAdapter = ArrayAdapter.createFromResource(this, R.array.resistor_tolerance, 
				android.R.layout.simple_spinner_item);
		//specify the layout to use when the list of choices appears
		tolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//changes string array "resistor_colors" to an ArrayAdapter in the format of the default spinner item
		ArrayAdapter<CharSequence> multAdapter = ArrayAdapter.createFromResource(this, R.array.resistor_multiplier, 
				android.R.layout.simple_spinner_item);
		//specify the layout to use when the list of choices appears
		multAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		//ACTUALLY APPLIES ADAPTER TO SPINNERS
		color1.setAdapter(adapter);
		color2.setAdapter(adapter);
		multiplier.setAdapter(multAdapter);
		tolerance.setAdapter(tolAdapter);
		
		//set selection listeners on spinners
		color1.setOnItemSelectedListener(this);
		color2.setOnItemSelectedListener(this);
		multiplier.setOnItemSelectedListener(this);
		tolerance.setOnItemSelectedListener(this);
		

		System.out.println("completed onCreate");	
		
	}

		
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
			
			//find text field
			TextView result = (TextView) findViewById(R.id.result);
			
			/* The following large chunk of code consists of lots of if statements assorted by color. These are to 
			 * change the background color of the chosen spinner, and change the global variable correlated with that
			 * spinner.
			 */
			
			
			//BLACK
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.black) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 0;
				parent.setBackgroundColor(getResources().getColor(R.color.black));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.black) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 0;
				parent.setBackgroundColor(getResources().getColor(R.color.black));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.black) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 1;
				parent.setBackgroundColor(getResources().getColor(R.color.black));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.black) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0;
				parent.setBackgroundColor(getResources().getColor(R.color.black));
			}
			
			//BROWN
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.brown) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 10;
				parent.setBackgroundColor(getResources().getColor(R.color.brown));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.brown) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 1;
				parent.setBackgroundColor(getResources().getColor(R.color.brown));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.brown) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 10;
				parent.setBackgroundColor(getResources().getColor(R.color.brown));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.brown) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.01;
				parent.setBackgroundColor(getResources().getColor(R.color.brown));
			}
			
			//RED
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.red) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 20;
				parent.setBackgroundColor(getResources().getColor(R.color.red));
				System.out.println("it worked, but no color change!");
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.red) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 2;
				parent.setBackgroundColor(getResources().getColor(R.color.red));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.red) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 100;
				parent.setBackgroundColor(getResources().getColor(R.color.red));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.red) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.02;
				parent.setBackgroundColor(getResources().getColor(R.color.red));
			}
			
			//ORANGE
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.orange) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 30;
				parent.setBackgroundColor(getResources().getColor(R.color.orange));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.orange) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 3;
				parent.setBackgroundColor(getResources().getColor(R.color.orange));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.orange) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 1000;
				parent.setBackgroundColor(getResources().getColor(R.color.orange));
			}
			
			//YELLOW
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.yellow) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 40;
				parent.setBackgroundColor(getResources().getColor(R.color.yellow));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.yellow) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 4;
				parent.setBackgroundColor(getResources().getColor(R.color.yellow));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.yellow) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 10000;
				parent.setBackgroundColor(getResources().getColor(R.color.yellow));
			}
			
			//GREEN
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.green) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 50;
				parent.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.green) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 5;
				parent.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.green) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 100000;
				parent.setBackgroundColor(getResources().getColor(R.color.green));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.green) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.005;
				parent.setBackgroundColor(getResources().getColor(R.color.green));
			}
				
			//BLUE
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.blue) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 60;
				parent.setBackgroundColor(getResources().getColor(R.color.blue));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.blue) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 6;
				parent.setBackgroundColor(getResources().getColor(R.color.blue));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.blue) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 1000000;
				parent.setBackgroundColor(getResources().getColor(R.color.blue));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.blue) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.0025;
				parent.setBackgroundColor(getResources().getColor(R.color.blue));
			}
			
			//VIOLET
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.violet) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 70;
				parent.setBackgroundColor(getResources().getColor(R.color.violet));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.violet) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 7;
				parent.setBackgroundColor(getResources().getColor(R.color.violet));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.violet) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 10000000;
				parent.setBackgroundColor(getResources().getColor(R.color.violet));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.violet) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.001;
				parent.setBackgroundColor(getResources().getColor(R.color.violet));
			}
			
			//GREY
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.grey) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 80;
				parent.setBackgroundColor(getResources().getColor(R.color.grey));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.grey) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 8;
				parent.setBackgroundColor(getResources().getColor(R.color.grey));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.grey) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.0005;
				parent.setBackgroundColor(getResources().getColor(R.color.grey));
			}
			
			//WHITE
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.white) && parent.getId()== R.id.first_spin){
				FIRST_VALUE = 90;
				parent.setBackgroundColor(getResources().getColor(R.color.white));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.white) && parent.getId()== R.id.second_spin){
				SECOND_VALUE = 9;
				parent.setBackgroundColor(getResources().getColor(R.color.white));
			}
			
			//GOLD
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.gold) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.05;
				parent.setBackgroundColor(getResources().getColor(R.color.gold));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.gold) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 0.1;
				parent.setBackgroundColor(getResources().getColor(R.color.gold));
			}
			
			//SILVER
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.silver) && parent.getId()== R.id.tolerance){
				TOLERANCE = 0.1;
				parent.setBackgroundColor(getResources().getColor(R.color.silver));
			}
			if(parent.getItemAtPosition(pos)==getResources().getString(R.string.silver) && parent.getId()== R.id.multiplier){
				MULTIPLIER = 0.01;
				parent.setBackgroundColor(getResources().getColor(R.color.silver));
			}


			/*System.out.println(FIRST_VALUE);
			System.out.println(SECOND_VALUE);
			System.out.println(MULTIPLIER);
			System.out.println(TOLERANCE);*/
			
			//calculates values to be used
			double total = (FIRST_VALUE + SECOND_VALUE)*MULTIPLIER;
			double plusMinus = total*TOLERANCE;
			if(total > 1000){
				if(total > 1000000){
					total = total/1000000;
					String toDisplayFormatM = getResources().getString(R.string.toDisplayM);
					String toDisplayMsgM = String.format(toDisplayFormatM, total, plusMinus);
					result.setText((String) toDisplayMsgM);
					return;
				}
				total = total/1000;
				String toDisplayFormatK = getResources().getString(R.string.toDisplayK);
				String toDisplayMsgK = String.format(toDisplayFormatK, total, plusMinus);
				result.setText((String) toDisplayMsgK);
			}
			else{
				//generates string and formats it
				String toDisplayFormat = getResources().getString(R.string.toDisplay);
				String toDisplayMsg = String.format(toDisplayFormat, total, plusMinus);
				//Print results into text field
				result.setText((String) toDisplayMsg);
			}
			
					
		}

		
		//when the text view is tapped, will copy that text to the clipboard, and shoot toast to confirm that
		public void copyToClip(View text){
			TextView textcopy = (TextView) findViewById(R.id.result);
			
			//copy to clipboard for various api levels
			int currentapiVersion = android.os.Build.VERSION.SDK_INT;
			if (currentapiVersion >= android.os.Build.VERSION_CODES.HONEYCOMB){
			     android.content.ClipboardManager clipboard =  (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
			        ClipData clip = ClipData.newPlainText("resistance", textcopy.getText());
			        clipboard.setPrimaryClip(clip); 
			} else{
			    android.text.ClipboardManager clipboard = (android.text.ClipboardManager)getSystemService(CLIPBOARD_SERVICE); 
			    clipboard.setText(textcopy.getText());
			}
			//shoot toast
			Toast.makeText(getApplicationContext(), "Text copied to clipboard", Toast.LENGTH_SHORT).show();
			
		}
		
		
		
		
		
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			System.out.println("onNothingSelected");
			return;
		}
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	//handler for about menu
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
		case R.id.action_about:
			showInfo();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	

	//changes the activity to About
	public void showInfo(){
		Intent startAbout = new Intent(this, About.class);
		startActivity(startAbout);
	}

}
