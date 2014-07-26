package com.labs.construct.tinhtoan;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockActivity;
import com.labs.construct.BangTraFragment;
import com.labs.construct.R;
import com.labs.construct.util.CSVReader;

public class TinhBeTong extends SherlockActivity {

	private static List<String> loaiXiMang = null;
	private Spinner loaiXiMangSpinner, macBetongSpinner, doSutSpinner, daDamSpinner;
	private TextView ximang_textview, catvang_textview, dadam_textview, nuoc_textview;
	private Button tinhtoan_button;
	private List<String[]> list_value =  new ArrayList<String[]>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tinhtoan_betong);

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
		
		list_value.remove(0);

		loaiXiMangSpinner = (Spinner)findViewById(R.id.loaiXiMangSpinner);
		macBetongSpinner = (Spinner)findViewById(R.id.macBetongSpinner);
		doSutSpinner = (Spinner)findViewById(R.id.doSutSpinner);
		daDamSpinner = (Spinner)findViewById(R.id.daDamSpinner);
		List<String> loaiXiMangSpinnerValues = new ArrayList<String>();
		List<String> macBetongSpinnerValues = new ArrayList<String>();
		List<String> doSutSpinnerValues = new ArrayList<String>();
		List<String> daDamSpinnerValues = new ArrayList<String>();
		for(String[] item : list_value) {
			if(!loaiXiMangSpinnerValues.contains(item[0])) {
				loaiXiMangSpinnerValues.add(item[0]);
			}
			
			if(!macBetongSpinnerValues.contains(item[1])) {
				macBetongSpinnerValues.add(item[1]);
			}
			
			if(!doSutSpinnerValues.contains(item[2])) {
				doSutSpinnerValues.add(item[2]);
			}
			
			if(!daDamSpinnerValues.contains(item[3])) {
				daDamSpinnerValues.add(item[3]);
			}
			
		}

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, loaiXiMangSpinnerValues);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		loaiXiMangSpinner.setAdapter(dataAdapter);
		
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, macBetongSpinnerValues);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		macBetongSpinner.setAdapter(dataAdapter1);

		ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, doSutSpinnerValues);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		doSutSpinner.setAdapter(dataAdapter2);
		
		ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, daDamSpinnerValues);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		daDamSpinner.setAdapter(dataAdapter3);
		
		ximang_textview = (TextView)findViewById(R.id.ximang_textview);
		catvang_textview = (TextView)findViewById(R.id.catvang_textview);
		dadam_textview = (TextView)findViewById(R.id.dadam_textview);
		nuoc_textview = (TextView)findViewById(R.id.nuoc_textview);
		tinhtoan_button = (Button)findViewById(R.id.tinhtoan_button);
		tinhtoan_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String loaiXimang = (String)loaiXiMangSpinner.getSelectedItem();
				String macBetong = (String)macBetongSpinner.getSelectedItem();
				String doSut = (String)doSutSpinner.getSelectedItem();
				String daDam = (String)daDamSpinner.getSelectedItem();

				ximang_textview.setText("");
				catvang_textview.setText("");
				dadam_textview.setText("");
				nuoc_textview.setText("");
				
				for(String[] item: list_value) {
					if(item[0].equals(loaiXimang) && item[1].equals(macBetong) && item[2].equals(doSut) && item[3].equals(daDam)) {
						ximang_textview.setText(item[4]);
						catvang_textview.setText(item[5]);
						dadam_textview.setText(item[6]);
						nuoc_textview.setText(item[7]);
						break;
					}
				}
			}
		});
	}


}
