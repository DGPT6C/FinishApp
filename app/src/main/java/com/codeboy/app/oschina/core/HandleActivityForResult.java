/*
 * Copyright (c) 2014. CodeBoyTeam
 */

package com.codeboy.app.oschina.core;

import android.content.Intent;

/**
 * 说明 用于调用方法startActivityForResult
 */
public interface HandleActivityForResult {

	public void startActivityForResult(Intent intent, int requestCode);
}
