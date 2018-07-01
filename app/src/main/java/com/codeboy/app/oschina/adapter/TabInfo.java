/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina.adapter;

import android.os.Bundle;

public final class TabInfo {

	public final String tag;
    public final Class<?> clss;
    public final Bundle args;
    public final String title;

    public TabInfo(String _title, String _tag, Class<?> _class, Bundle _args) {
    	title = _title;
        tag = _tag;
        clss = _class;
        args = _args;
    }
}
