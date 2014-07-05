package com.labs.construct;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockFragment;
import com.labs.construct.trathep.TraThepV;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BangTraFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.bangtra_fragment, container, false);

		final ListView listview = (ListView) view.findViewById(R.id.listview);
		String[] values = new String[] { "Tra thep hinh", "Tra baybay" };

		final ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < values.length; ++i) {
			list.add(values[i]);
		}

		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Toast.makeText(getApplicationContext(),
//						"Click ListItem Number " + position, Toast.LENGTH_LONG)
//						.show();
				
				Intent intent = new Intent(getActivity(), TraThepV.class);
				startActivity(intent);
			}
		}); 
		return view;
	}
	
	@Override 
	public void onSaveInstanceState(Bundle outState) 
	{
	//first saving my state, so the bundle wont be empty.
	outState.putString("WORKAROUND_FOR_BUG_19917_KEY",  "WORKAROUND_FOR_BUG_19917_VALUE");
	super.onSaveInstanceState(outState);
	}
}
