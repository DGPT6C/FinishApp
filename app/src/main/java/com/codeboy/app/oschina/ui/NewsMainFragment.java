/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina.ui;

import com.codeboy.app.oschina.R;
import com.codeboy.app.oschina.adapter.TabsFragmentPagerAdapter;

public class NewsMainFragment extends BaseMainFragment{

	public static NewsMainFragment newInstance() {
		return new NewsMainFragment();
	}

	@Override
	protected void onSetupTabAdapter(TabsFragmentPagerAdapter adapter) {
		adapter.addTab(getString(R.string.frame_title_news_lastest), "news", NewsLatestNewsFragment.class, null);
		adapter.addTab(getString(R.string.frame_title_news_blog), "blog", NewsRecentBlogPostsFragment.class, null);
		adapter.addTab(getString(R.string.frame_title_news_recommend), "recommon", NewsRecommonFragment.class, null);
	}
}