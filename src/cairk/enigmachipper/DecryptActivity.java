package cairk.enigmachipper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class DecryptActivity extends ActionBarActivity {
	public final static String EXTRA_CODE = "cairk.enigmachipper.CODE";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_decrypt);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.decrypt, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_decrypt,
					container, false);
			return rootView;
		}
	}
	
	public void DecryptCode(View view) {
		Intent intent = new Intent(this, ShowMessage.class);
        Enigma myEnigmaEnc = (Enigma)getApplicationContext();

		EditText editText = (EditText) findViewById(R.id.edit_code);
		String Input = editText.getText().toString() + ".";
		myEnigmaEnc.setInput(Input);
		
		String message = myEnigmaEnc.Decrypt();
    	intent.putExtra(EXTRA_CODE, message);
    	System.out.println(message);
    	startActivity(intent);
	}


}
