/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina.ui;

import java.util.List;

import net.oschina.app.adapter.ListViewNewsAdapter;
import net.oschina.app.bean.News;
import net.oschina.app.bean.NewsList;
import net.oschina.app.common.UIHelper;
import net.oschina.app.core.AppException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.codeboy.app.oschina.R;
import com.codeboy.app.oschina.modul.MessageData;


public class NewsLatestNewsFragment extends BaseSwipeRefreshFragment<News, NewsList> {
	
	public static NewsLatestNewsFragment newInstance() {
		return new NewsLatestNewsFragment();
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public BaseAdapter getAdapter(List<News> list) {
		return new ListViewNewsAdapter(getActivity(), list, R.layout.news_listitem);
	}

	@Override
	protected MessageData<NewsList> asyncLoadList(int page, boolean reflash) {
		MessageData<NewsList> msg = null;
		try {
			NewsList list = mApplication.getNewsList(NewsList.CATALOG_ALL, page, reflash);
			msg = new MessageData<NewsList>(list);
		} catch (AppException e) {
			e.printStackTrace();
			msg = new MessageData<NewsList>(e);
		}
		return msg;
	}

	@Override
	public void onItemClick(int position, News news) {
		UIHelper.showNewsRedirect(getActivity(), news);
	}
}
