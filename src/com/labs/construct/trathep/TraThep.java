package com.labs.construct.trathep;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.labs.construct.BangTraFragment;
import com.labs.construct.R;
import com.labs.construct.util.CSVReader;

public class TraThep extends SherlockActivity {

	TableLayout table;
	Spinner spinner;
	List<String[]> list_value = new ArrayList<String[]>();;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trathepv);

		String link = getIntent().getStringExtra(BangTraFragment.ASSET_LINK);
		String next[] = {};

		try {
			CSVReader reader = new CSVReader(new InputStreamReader(getAssets().open(link)));
			for(;;) {
				next = reader.readNext();
				if(next != null) {
					list_value.add(next);
				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		table = (TableLayout)findViewById(R.id.table);
		spinner = (Spinner)findViewById(R.id.spinner);
		String[] spinnerValues = list_value.get(0);
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, Arrays.asList(spinnerValues).subList(3, spinnerValues.length));
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
				updateTable(position+3);
			}
			public void onNothingSelected(AdapterView<?> arg0) { }
		});
		addTableRow(getResources().getStringArray(R.array.title), 2,100);
		//addTableRowSpinner(list_value.get(0));
		updateTable(3);

	}

	public void updateTable(int position) {
		for(int i=1; i< list_value.size(); i++) {
			View view = table.findViewById(i);
			table.removeView(view);
			addTableRow(list_value.get(i), position, i);
		}
	}

	private void addTableRow(final String[] value, final int three, final int id) {
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View myView = inflater.inflate(R.layout.table_row, null);
		if(id == 100) {
			myView.setBackgroundColor(Color.parseColor("#666666"));
		} else if(id % 2 == 0) {
			myView.setBackgroundColor(Color.parseColor("#FFFFFF"));
		} else {
			myView.setBackgroundColor(Color.parseColor("#EAEAEA"));
		}
		myView.setId(id);
		TextView textView1 = (TextView)myView.findViewById(R.id.textView1);
		textView1.setText(value[0]);
		TextView textView2 = (TextView)myView.findViewById(R.id.textView2);
		textView2.setText(value[1]);
		TextView textView3 = (TextView)myView.findViewById(R.id.textView3);
		textView3.setText(value[three]);
		TextView textView4 = (TextView)myView.findViewById(R.id.textView4);
		textView4.setText(value[2]);
		table.addView(myView, new TableLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
	}


	@Override 
	public void onSaveInstanceState(Bundle outState) 
	{
		//first saving my state, so the bundle wont be empty.
		outState.putString("WORKAROUND_FOR_BUG_19917_KEY",  "WORKAROUND_FOR_BUG_19917_VALUE");
		super.onSaveInstanceState(outState);
	}
}
