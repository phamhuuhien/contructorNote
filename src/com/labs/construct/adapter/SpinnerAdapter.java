package com.labs.construct.adapter;

import java.util.List;

import com.labs.construct.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<ObjectItem> {

	// Your sent context
	private Context context;
	// Your custom values for the spinner (User)
	private List<ObjectItem> values;

	public SpinnerAdapter(Context context, int textViewResourceId,
			List<ObjectItem> values) {
		super(context, textViewResourceId, values);
		this.context = context;
		this.values = values;
	}

	public int getCount(){
		return values.size();
	}

	public ObjectItem getItem(int position){
		return values.get(position);
	}

	public long getItemId(int position){
		return position;
	}


	// And the "magic" goes here
	// This is for the "passive" state of the spinner
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
		//TextView label = new TextView(context);
		//label.setTextColor(Color.BLACK);
		LayoutInflater li = LayoutInflater.from(context);
		final TextView label = (TextView)li.inflate(android.R.layout.simple_spinner_item, null);
		// Then you can get the current item using the values array (Users array) and the current position
		// You can NOW reference each method you has created in your bean object (User class)
		label.setText(values.get(position).title);

		// And finally return your dynamic (or custom) view for each spinner item
		return label;
	}

	// And here is when the "chooser" is popped up
	// Normally is the same view, but you can customize it if you want
	@Override
	public View getDropDownView(int position, View convertView,
			ViewGroup parent) {
		LayoutInflater li = LayoutInflater.from(context);
		final TextView label = (TextView)li.inflate(R.layout.spinner_item, null);
		label.setText(values.get(position).title);

		return label;
	}
}
