/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina;

import net.oschina.app.core.AppContext;

import com.codeboy.app.library.util.L;
import com.umeng.analytics.MobclickAgent;

public class OSChinaApplication extends AppContext{

	@Override
	public void onCreate() {
		MobclickAgent.openActivityDurationTrack(false);
		//设置是否为调试模式
		L.setDebug(BuildConfig.DEBUG);
		super.onCreate();
	}
}
