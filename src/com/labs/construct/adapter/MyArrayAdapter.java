package com.labs.construct.adapter;

import java.util.List;

import com.labs.construct.R;
import com.labs.construct.object.ThepListObject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<ThepListObject> {
	private final Context context;
	private final List<ThepListObject> values;

	public MyArrayAdapter(Context context, List<ThepListObject> values) {
		super(context, R.layout.list_item, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.list_item, parent, false);
		TextView text = (TextView) rowView.findViewById(R.id.title);
		ImageView icon = (ImageView) rowView.findViewById(R.id.icon);
		ThepListObject tmp = values.get(position);
		text.setText(tmp.title);
		icon.setImageResource(tmp.icon);

		return rowView;
	}
}