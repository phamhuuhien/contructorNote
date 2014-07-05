package com.labs.construct.adapter;

import com.labs.construct.BangTraFragment;
import com.labs.construct.TieuChuanFragment;
import com.labs.construct.TinhtoanFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

	// Declare the number of ViewPager pages
	final int PAGE_COUNT = 3;

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {

		// Open FragmentTab1.java
		case 0:
			TinhtoanFragment fragmenttab1 = new TinhtoanFragment();
			return fragmenttab1;

			// Open FragmentTab2.java
		case 1:
			BangTraFragment fragmenttab2 = new BangTraFragment();
			return fragmenttab2;

			// Open FragmentTab3.java
		case 2:
			TieuChuanFragment fragmenttab3 = new TieuChuanFragment();
			return fragmenttab3;
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return PAGE_COUNT;
	}
}
