/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina;

import net.oschina.app.bean.FavoriteList;
import net.oschina.app.bean.News;
import net.oschina.app.bean.Result;
import net.oschina.app.common.UIHelper;
import net.oschina.app.core.AppException;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.codeboy.app.library.util.L;
import com.codeboy.app.oschina.adapter.TabInfo;
import com.codeboy.app.oschina.core.Contanst;
import com.codeboy.app.oschina.modul.UpdateDatasEvent;
import com.codeboy.app.oschina.ui.NewsDetailBodyFragment;

public class NewsDetailActivity extends BaseDetailActivity  {

    private final static int SHARE_ITEM_ID = 100;
    private final static int FAVORITE_ITEM_ID = 101;

	private int mNewsId;
	private int mCommentCount;
	private News mNews;

    private ShareActionProvider mShareActionProvider;
    private Menu optionsMenu;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		mNewsId = getIntent().getIntExtra(Contanst.NEWS_ID_KEY, 0);
		super.onCreate(savedInstanceState);
        mShareActionProvider = new ShareActionProvider(this);
		loadDatas(false);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        optionsMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == FAVORITE_ITEM_ID) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupShareAction() {
        String url = "";
        if(mNews != null) {
            url = mNews.getUrl();
        }
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, url);
        intent.putExtra(Intent.EXTRA_TEXT, url);
        intent.putExtra("Kdescription", url);
        intent.putExtra("sms_body", url);

        mShareActionProvider.setShareIntent(intent);
    }

    @Override
	protected TabInfo getBodyTabInfo(String tag) {
		Bundle args = new Bundle();
		args.putSerializable(Contanst.NEWS_DATA_KEY, mNews);
		return new TabInfo(null, tag, NewsDetailBodyFragment.class, args);
	}

	@Override
	protected boolean isDataLoaded() {
		return mNews != null;
	}
	
	/** 更新资讯内容数据*/
	private void updateBodyFragment(News news) {
		//更新adapter里的数据
		TabInfo info = mAdapter.getTab(0);
		FragmentManager fm = getSupportFragmentManager();
		String tag = info.tag;
		
		Fragment fragment = fm.findFragmentByTag(tag);
		if(fragment != null && fragment instanceof UpdateDatasEvent) {
			UpdateDatasEvent event = (UpdateDatasEvent)fragment;
			event.onNotifyUpdate(news);
		} else {
			L.d("body is null");
			info.args.putSerializable(Contanst.NEWS_DATA_KEY, news);
		}
	}
	
	/**
	 * 加载资讯数据
	 * @param isRefresh 是否刷新，否则加载本地缓存
	 * */
	private void loadDatas(final boolean isRefresh) {
		new AsyncTask<Void, Void, Message>() {

			@Override
			protected Message doInBackground(Void... params) {
				Message msg = new Message();
				try {
					News news = mApplication.getNews(mNewsId, isRefresh);
					
					msg.what = (news != null && news.getId() > 0) ? 1 : 0;
					msg.obj = news;
				} catch (AppException e) {
					e.printStackTrace();
					msg.what = -1;
					msg.obj = e;
				}
				return msg;
			}
			
			@Override
			protected void onPreExecute() {
				
			}
			
			@Override
			protected void onPostExecute(Message msg) {
				if(isFinishing()) {
					return;
				}
				final Context context = NewsDetailActivity.this;
				if (msg.what == 1) {
					final News newsDetail = (News) msg.obj;
					mNews = newsDetail;
					mCommentCount = newsDetail.getCommentCount();
                    setupShareAction();

					//更新内容界面
					updateBodyFragment(newsDetail);
				} else if (msg.what == 0) {
					UIHelper.ToastMessage(context, R.string.msg_load_is_null);
				} else if (msg.what == -1 && msg.obj != null) {
					((AppException) msg.obj).makeToast(context);
				}
			}
		}.execute();
	}

}