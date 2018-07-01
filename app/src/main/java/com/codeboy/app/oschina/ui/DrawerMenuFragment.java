/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina.ui;

import net.oschina.app.bean.MyInformation;
import net.oschina.app.common.UIHelper;
import net.oschina.app.core.AppException;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.codeboy.app.library.util.L;
import com.codeboy.app.oschina.BaseFragment;
import com.codeboy.app.oschina.OSChinaApplication;
import com.codeboy.app.oschina.R;
import com.codeboy.app.oschina.modul.DrawerMenuCallBack;


public class DrawerMenuFragment extends BaseFragment implements OnClickListener{
	
	public static DrawerMenuFragment newInstance() {
		return new DrawerMenuFragment();
	}
	
	private ImageView mAvatarImageView;
	private ImageView mGenderImageView;
	private TextView mNameTextView;
	private View mInfoLayout;
	private View mLoginTipsLayout;

	//通过回调与Activity通讯
	private DrawerMenuCallBack mCallBack;
	private OSChinaApplication mApplication;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity instanceof DrawerMenuCallBack) {
			mCallBack = (DrawerMenuCallBack) activity;
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mCallBack = null;
		L.d("is activity is null?" + (getActivity() == null));
	}

	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mApplication = getOsChinaApplication();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_drawer_menu, null);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		view.findViewById(R.id.menu_item_news).setOnClickListener(this);
		view.findViewById(R.id.menu_item_qa).setOnClickListener(this);
		view.findViewById(R.id.menu_item_tweet).setOnClickListener(this);
		view.findViewById(R.id.menu_item_software).setOnClickListener(this);
		view.findViewById(R.id.menu_item_active).setOnClickListener(this);

//		setupUserView(false);
	}


	@Override
	public void onClick(View v) {
		int id = v.getId();
        if (id == R.id.menu_item_news) {
			onClickNews();
		} else if (id == R.id.menu_item_qa) {
//			onClickQuestionAsk();
		} else if (id == R.id.menu_item_tweet) {
//			onClickTweet();
		} else if (id == R.id.menu_item_software) {
//			onClickSoftware();
		} else if (id == R.id.menu_item_active) {
//			onClickActive();
		}
	}

	
	/** 点击了资讯*/
	private void onClickNews() {
		if(mCallBack != null) {
			mCallBack.onClickNews();
		}
	}
	
//	/** 点击了问答*/
//	private void onClickQuestionAsk() {
//		if(mCallBack != null) {
//			mCallBack.onClickQuestionAsk();
//		}
//	}
//
//	/** 点击了开源软件*/
//	private void onClickSoftware() {
//		if(mCallBack != null) {
//			mCallBack.onClickSoftware();
//		}
//	}
//
//	/** 点击了动弹*/
//	private void onClickTweet() {
//		if(mCallBack != null) {
//			mCallBack.onClickTweet();
//		}
//	}
//
//	/** 点击了我的空间*/
//	private void onClickActive() {
//		if(mCallBack != null) {
//			mCallBack.onClickAvtive();
//		}
//	}
}
