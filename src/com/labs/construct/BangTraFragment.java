package com.labs.construct;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockFragment;
import com.labs.construct.adapter.MyArrayAdapter;
import com.labs.construct.object.ThepListObject;
import com.labs.construct.trathep.TraThep;

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

	public static String ASSET_LINK = "asset_link";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.bangtra_fragment, container, false);

		final ListView listview = (ListView) view.findViewById(R.id.listview);
		String[] values = new String[] { "Tra thep hinh V", "Tra thep hinh U" };
		String[] assets = new String[] {"ThepHinhV.csv", "ThepHinhU.csv"};

		final ArrayList<ThepListObject> list = new ArrayList<ThepListObject>();
		for (int i = 0; i < values.length; ++i) {
			ThepListObject obj = new ThepListObject();
			obj.title = values[i];
			obj.asset = assets[i];
			list.add(obj);
		}

		final MyArrayAdapter adapter = new MyArrayAdapter(getActivity(), list);
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
//				Toast.makeText(getApplicationContext(),
//						"Click ListItem Number " + position, Toast.LENGTH_LONG)
//						.show();
				ThepListObject obj = ((MyArrayAdapter)parent.getAdapter()).getItem(position);
				Intent intent = new Intent(getActivity(), TraThep.class);
				intent.putExtra(ASSET_LINK, obj.asset);
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
