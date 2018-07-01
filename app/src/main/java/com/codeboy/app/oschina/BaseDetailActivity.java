/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina;

import net.oschina.app.common.UIHelper;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.codeboy.app.oschina.adapter.SimpleFragmentPagerAdapter;
import com.codeboy.app.oschina.adapter.TabInfo;

/**
 * 类名 BaseDetailActivity.java</br>
 * 创建日期 2014年5月2日</br>
 * @author LeonLee (http://my.oschina.net/lendylongli)</br>
 * Email lendylongli@gmail.com</br>
 * 更新时间 2014年5月2日 上午11:39:41</br>
 * 最后更新者 LeonLee</br>
 * 
 * 说明 详细信息的基类
 */
public abstract class BaseDetailActivity extends BaseActionBarActivity 
	implements OnPageChangeListener {

	protected ViewPager mViewPager;
	
	protected SimpleFragmentPagerAdapter mAdapter;
	protected OSChinaApplication mApplication;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ActionBar bar = getSupportActionBar();
        bar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP, ActionBar.DISPLAY_HOME_AS_UP);
		
        mApplication = getOsChinaApplication();
        mAdapter = new SimpleFragmentPagerAdapter(this, getSupportFragmentManager());
        
        setContentView(R.layout.activity_base_detail);
        
        initView();
	}
	
	@Override
	public boolean onSupportNavigateUp() {
		finish();
		return true;
	}
	
	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.basedetail_viewpager);
		
		mViewPager.setOnPageChangeListener(this);
		
		mAdapter.addTab(getBodyTabInfo(getBodyFragmentTag()));
		mViewPager.setAdapter(mAdapter);
		
	}
	
	protected abstract TabInfo getBodyTabInfo(String tag);
	/** 数据是否已经加载完毕*/
	protected abstract boolean isDataLoaded();
	
	/** 
	 * 在AndroidSupportV4里，每一个位置的fragment的tag生成规则
	 * 详细看源码
	 * @param viewId ViewPager的id
	 * @param id adapter里的long id,规则以位置作为id
	 * */
	static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
	
	String getBodyFragmentTag() {
		return makeFragmentName(mViewPager.getId(), 0);
	}
	
	String getCommentFragmentTag() {
		return makeFragmentName(mViewPager.getId(), 1);
	}
	
	@Override
	public void onPageScrollStateChanged(int state) {
		
	}
	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}
	@Override
	public void onPageSelected(int position) {

	}
}