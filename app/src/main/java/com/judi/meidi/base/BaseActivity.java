package com.judi.meidi.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;

/**
 * Activity基类
 * @author dengkaitao
 * @date 2016年3月31日上午9:02:15
 */
public abstract class BaseActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(getLayoutId());
		setBasicInfo(savedInstanceState);
		initViews();
		bindViews();
		initData();
	}

	/**
	 * 设置第三方信息及其它配置
	 * @param savedInstanceState
	 */
	public abstract void setBasicInfo(Bundle savedInstanceState);

	/**
	 * activity资源界面
	 * @return
	 */
	public abstract int getLayoutId();

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
