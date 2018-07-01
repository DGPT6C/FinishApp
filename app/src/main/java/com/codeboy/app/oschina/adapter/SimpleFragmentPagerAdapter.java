/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
	private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
	private Context mContext;
	
	public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		mContext = context;
	}
	
	public void addTab(String tag, Class<?> clss, Bundle args) {
        TabInfo info = new TabInfo(null, tag, clss, args);
        mTabs.add(info);
        notifyDataSetChanged();
    }
	
	public void addTab(TabInfo info) {
		mTabs.add(info);
		notifyDataSetChanged();
	}
	
	public TabInfo getTab(int position) {
		return mTabs.get(position);
	}

	@Override
	public Fragment getItem(int position) {
		TabInfo info = mTabs.get(position);
        return Fragment.instantiate(mContext, info.clss.getName(), info.args);
	}

	@Override
	public int getCount() {
		return mTabs.size();
	}
}
