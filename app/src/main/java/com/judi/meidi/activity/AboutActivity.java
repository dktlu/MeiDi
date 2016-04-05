package com.judi.meidi.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.judi.meidi.R;
import com.judi.meidi.base.BaseActivity;

/**
 * 关于我们
 * @author dengkaitao
 * @date 2016年3月31日上午9:22:15
 */
public class AboutActivity extends BaseActivity {

	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBasicInfo(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLayoutId() {
		return R.layout.activity_about;
	}

	@Override
	public void initViews() {
		webView = (WebView) findViewById(R.id.webview);
	}

	@Override
	public void bindViews() {

	}

	@Override
	public void initData() {
		WebSettings webSetting = webView.getSettings();
		webSetting.setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) { 
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("http://www.hncsmd.com/about/?108.html");
	}

}
