/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina;

import com.codeboy.app.oschina.core.HandleActivityForResult;
import com.umeng.analytics.MobclickAgent;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 类名 BaseFragment.java</br>
 * 
 * 说明 碎片的基类
 */
public class BaseFragment extends Fragment implements HandleActivityForResult {

	
	public OSChinaApplication getOsChinaApplication() {
		return (OSChinaApplication) getActivity().getApplication();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		MobclickAgent.onPageStart(getClass().getSimpleName());
	}
	
	@Override
	public void onPause() {
		super.onPause();
		MobclickAgent.onPageEnd(getClass().getSimpleName());
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
}
