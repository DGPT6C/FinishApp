/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina.ui;

import java.util.List;

import net.oschina.app.adapter.ListViewBlogAdapter;
import net.oschina.app.bean.Blog;
import net.oschina.app.bean.BlogList;
import net.oschina.app.common.UIHelper;
import net.oschina.app.core.AppException;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.codeboy.app.oschina.R;
import com.codeboy.app.oschina.modul.MessageData;

public class NewsRecentBlogPostsFragment extends BaseSwipeRefreshFragment<Blog, BlogList> {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public BaseAdapter getAdapter(List<Blog> list) {
		return new ListViewBlogAdapter(
				getActivity(), 0, list, R.layout.blog_listitem);
	}

	@Override
	protected MessageData<BlogList> asyncLoadList(int page, boolean reflash) {
		MessageData<BlogList> msg = null;
		try {
			BlogList list = mApplication.getBlogList(BlogList.TYPE_LATEST, page, reflash);
			msg = new MessageData<BlogList>(list);
		} catch (AppException e) {
			e.printStackTrace();
			msg = new MessageData<BlogList>(e);
		}
		return msg;
	}

	@Override
	public void onItemClick(int position, Blog blog) {
		UIHelper.showUrlRedirect(getActivity(), blog.getUrl());
	}
}
