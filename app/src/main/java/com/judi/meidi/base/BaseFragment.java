package com.judi.meidi.base;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * Activity基类
 * @author dengkaitao
 * @date 2016年3月31日上午9:02:17
 */
@SuppressLint("NewApi")
public abstract class BaseFragment extends Fragment implements OnClickListener {
	
	@SuppressLint("NewApi")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		initViews();
		bindViews();
		initData();
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	/**
	 * 初始化控件
	 */
	public abstract void initViews();

	/**
	 * 绑定控件监听事件
	 */
	public abstract void bindViews();

	/**
	 * 初始化数据
	 */
	public abstract void initData();
}
