package com.example.twoway;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.example.twoway.MaterialRangeSlider.RangeSliderListener;
import com.first.twoway.R;

public class MainActivity extends Activity implements RangeSliderListener{

	TextView min_price_txt;
	TextView max_price_txt;
	MaterialRangeSlider price_slider;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		price_slider = (MaterialRangeSlider) findViewById(R.id.price_slider);
		min_price_txt = (TextView) findViewById(R.id.min_price_txt);
		max_price_txt = (TextView) findViewById(R.id.max_price_txt);
		
		
		price_slider.setRangeSliderListener(this);
		price_slider.setMin(0);
		price_slider.setMax(1000);

		price_slider.setStartingMinMax(50, 300);
	}
	
	private int cIndex(int actionIndex) {
		int y = actionIndex % 50;
		int index = 0;
		if (y != 0) {
			int c = actionIndex / 50;
			if (y >= 25) {
				index = (c + 1) * 50;
			} else if (y < 25) {
//				if (c <= 1) {
					index = c * 50;
//				} else {
//					index = (c - 1) * 50;
//				}
			}
		} else {
			index = actionIndex;
		}
		return index;
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

	@Override
	public void onMaxChanged(int newValue) {
		// TODO Auto-generated method stub
		max_price_txt.setText("" + cIndex(newValue));
	}

	@Override
	public void onMinChanged(int newValue) {
		// TODO Auto-generated method stub
		min_price_txt.setText("" + cIndex(newValue));
	}
}
