package com.labs.construct;

import com.actionbarsherlock.app.SherlockFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TieuChuanFragment extends SherlockFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.tieuchuan_fragment, container, false);
	}
	
	@Override 
	public void onSaveInstanceState(Bundle outState) 
	{
	//first saving my state, so the bundle wont be empty.
	outState.putString("WORKAROUND_FOR_BUG_19917_KEY",  "WORKAROUND_FOR_BUG_19917_VALUE");
	super.onSaveInstanceState(outState);
	}
}
