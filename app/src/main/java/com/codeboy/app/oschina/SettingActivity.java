/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina;

import com.codeboy.app.oschina.ui.SettingPreferenceFragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.widget.FrameLayout;

/**
 * 类名 SettingActivity.java</br>
 * 
 * 说明 设置界面
 */

public class SettingActivity extends BaseActionBarActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getSupportActionBar();
		int flags = ActionBar.DISPLAY_HOME_AS_UP;
		int change = bar.getDisplayOptions() ^ flags;
        bar.setDisplayOptions(change, flags);
		
		FrameLayout layout = new FrameLayout(this);
		layout.setId(R.id.container);
		
		setContentView(layout);
		
		if(savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
			.replace(R.id.container, new SettingPreferenceFragment())
			.commit();
		}
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		finish();
		return true;
	}
}