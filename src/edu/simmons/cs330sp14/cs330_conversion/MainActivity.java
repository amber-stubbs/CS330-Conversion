package edu.simmons.cs330sp14.cs330_conversion;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	/** Methods for the conversion app  **/
	
	public void convert(View view) {
	    // Do something in response to button
		String convAns = "";
		EditText e = (EditText)findViewById(R.id.editText1);
		String num1 = e.getText().toString();

		Spinner sp = (Spinner)findViewById(R.id.spinner1);
		String text = sp.getSelectedItem().toString();

		TextView t = (TextView)findViewById(R.id.textView1);
		t.setText("Convert "+num1+" in "+text);	
		if (text.equals("Decimal"))
		{
			convAns = decToHex(num1);
		}
		else if (text.equals("Hex")){
			convAns = hexToDecimal(num1); 
		}
		else if (text.equals("Fahrenheit"))
		{
			convAns = fToC(num1);
		}
		else
		{
			convAns = cToF(num1);
		}
		t.setText(num1 + " in " + text + " is " + convAns); 
	}
	public String hexToDecimal(String num) {
		String dec = "";
	    // more code to come. --ksb 
	    return dec; 
	}
	public String decToHex(String num)
	{
	    Integer hex = Integer.parseInt(num);
		return Integer.toHexString(hex);
	    
	}
	public String fToC(String temp)
	{
		//String cel = ""; // the string that will eventually hold the celsius value
		Double t = Double.parseDouble(temp);
		t = (t -32)/1.8000;
		return t.toString(); 
	}
	public String cToF(String temp)
	{
		//String far = ""; // the string that will eventually hold the fahrenheit value
		Double t = Double.parseDouble(temp);
		t = (t * 1.8000) + 32;
		return t.toString();
	}
}
	


