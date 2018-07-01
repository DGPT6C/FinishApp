/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina;

import android.app.Activity;
import android.os.Bundle;

/**
 * 类名 ActivityHelper.java</br>
 * 
 * 说明 类的描述
 */
public class ActivityHelper implements ActivityHelperInterface{
	
	Activity mActivity;
	
	public ActivityHelper(Activity activity) {
		mActivity = activity;
	}
	
	public void onCreate(Bundle savedInstanceState) {
		
	}
	
	public void onAttachedToWindow() {
		
	}
	
	public void onDetachedFromWindow() {
		
	}

	@Override
	public OSChinaApplication getOsChinaApplication() {
		return (OSChinaApplication) mActivity.getApplication();
	}

	@Override
	public Activity getActivity() {
		return mActivity;
	}
}
