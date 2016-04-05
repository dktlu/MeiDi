package com.judi.meidi.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.judi.meidi.R;
import com.judi.meidi.activity.AboutActivity;
import com.judi.meidi.activity.DesignerActivity;
import com.judi.meidi.activity.FullViewActivity;
import com.judi.meidi.adapter.FirstPageImageAdapter;
import com.judi.meidi.base.BaseFragment;
import com.judi.meidi.view.GuideGallery;

import java.util.ArrayList;
import java.util.List;


public class IndexFragment extends BaseFragment {
	
	private View view;
	private LinearLayout layoutContainer;
	private GuideGallery gallery;
	private List<Integer> imagePaths;
    private static final int CHANGE_IMG = 1;
    private static final int CHANGE_NOTICE = 2;
    protected Handler imageChangeHandler = new MyHandler();
    private boolean run = false;
    
    private RelativeLayout rlAbout;     //关于莱迪
    private RelativeLayout rlDesigner;  //设计师
	private RelativeLayout rlExample;

    private RelativeLayout rlFullView1, rlFullView2, rlFullView3, rlFullView4;
	private RelativeLayout rlExample1, rlExample2, rlExample3, rlExample4, rlExample5,
			rlExample6, rlExample7;
    private LinearLayout llMoreFullView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_index, null);
		super.onCreateView(inflater, container, savedInstanceState);
		return view;
	}

	@Override
	public void initViews() {
		gallery = (GuideGallery) view.findViewById(R.id.default_gallery);
		layoutContainer = (LinearLayout) view.findViewById(R.id.layout_container);
		rlAbout = (RelativeLayout) view.findViewById(R.id.rl_about);
		rlExample = (RelativeLayout) view.findViewById(R.id.rl_example);
        rlDesigner = (RelativeLayout) view.findViewById(R.id.rl_designer);
        rlFullView1 = (RelativeLayout) view.findViewById(R.id.rl_fullview1);
        rlFullView2 = (RelativeLayout) view.findViewById(R.id.rl_fullview2);
        rlFullView3 = (RelativeLayout) view.findViewById(R.id.rl_fullview3);
        rlFullView4 = (RelativeLayout) view.findViewById(R.id.rl_fullview4);
		rlExample1 = (RelativeLayout) view.findViewById(R.id.rl_example1);
		rlExample2 = (RelativeLayout) view.findViewById(R.id.rl_example2);
		rlExample3 = (RelativeLayout) view.findViewById(R.id.rl_example3);
		rlExample4 = (RelativeLayout) view.findViewById(R.id.rl_example4);
		rlExample5 = (RelativeLayout) view.findViewById(R.id.rl_example5);
		rlExample6 = (RelativeLayout) view.findViewById(R.id.rl_example6);
		rlExample7 = (RelativeLayout) view.findViewById(R.id.rl_example7);
        llMoreFullView = (LinearLayout) view.findViewById(R.id.ll_more_fullview);
    }

	@Override
	public void bindViews() {
		rlAbout.setOnClickListener(this);
		rlExample.setOnClickListener(this);
        rlDesigner.setOnClickListener(this);
        rlFullView1.setOnClickListener(this);
        rlFullView2.setOnClickListener(this);
        rlFullView3.setOnClickListener(this);
        rlFullView4.setOnClickListener(this);
        llMoreFullView.setOnClickListener(this);
        rlExample1.setOnClickListener(this);
        rlExample2.setOnClickListener(this);
        rlExample3.setOnClickListener(this);
        rlExample4.setOnClickListener(this);
        rlExample5.setOnClickListener(this);
        rlExample6.setOnClickListener(this);
        rlExample7.setOnClickListener(this);
	}

	@SuppressLint("NewApi")
	@Override
	public void initData() {
		
		imagePaths = new ArrayList<Integer>();
		imagePaths.add(R.drawable.banner);
		imagePaths.add(R.drawable.bg_banner_1);
		imagePaths.add(R.drawable.bg_banner_2);
		
		//设置轮播图的宽高
		WindowManager wm = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
		Point size = new Point();
		wm.getDefaultDisplay().getSize(size);
        int width = size.x;
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                width, (width * 2) / 5);
        gallery.setLayoutParams(params);
        
        gallery.bottomFrame = layoutContainer;
        gallery.setAutoPlay(true);
        gallery.setImageSize(imagePaths.size());
        gallery.initPoints();
        gallery.setPageMargin(0);
        if (!run) {
            startPlayPic();
        }
        FirstPageImageAdapter adapter = new FirstPageImageAdapter(
                getActivity(), imagePaths,
                true, R.layout.gallery_item_first_page,
                R.id.iv_gallery);
        gallery.setAdapter(adapter);
        gallery.setCurrentItem(imagePaths.size() * 5000);
	}


    private void startPlayPic() {
        new Thread() {
            @Override
            public void run() {
            	Log.d("Thread run:", "" + run);
                run = true;
                while (run) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        Thread.interrupted();
                    }
                    Message msg = imageChangeHandler.obtainMessage();
                    msg.what = CHANGE_IMG;
                    imageChangeHandler.sendMessage(msg);
                }
            }
        }.start();
    }

    class MyHandler extends Handler {
        public void handleMessage(Message msg) {
            if (msg.what == CHANGE_IMG) {
                if (gallery != null) {
                    gallery.setCurrentItem(gallery.getCurrentItem() + 1);
                }
            }

        }
    }

	@SuppressLint("NewApi")
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.rl_about:         //关于美迪
			Intent aboutIntent = new Intent(getActivity(), AboutActivity.class);
			startActivity(aboutIntent);
			break;
		case R.id.rl_designer:      //设计师
			Intent designerIntent = new Intent(getActivity(), DesignerActivity.class);
			startActivity(designerIntent);
			break;
		case R.id.rl_fullview1:
			Intent fullview1Intent = new Intent(getActivity(), FullViewActivity.class);
			startActivity(fullview1Intent);
			break;
		case R.id.rl_fullview2:
			Intent fullview2Intent = new Intent(getActivity(), FullViewActivity.class);
			startActivity(fullview2Intent);
			break;
		case R.id.rl_fullview3:
			Intent fullview3Intent = new Intent(getActivity(), FullViewActivity.class);
			startActivity(fullview3Intent);
			break;
		case R.id.rl_fullview4:
			Intent fullview4Intent = new Intent(getActivity(), FullViewActivity.class);
			startActivity(fullview4Intent);
			break;
		case R.id.ll_more_fullview:
			Intent moreFullviewIntent = new Intent(getActivity(), FullViewActivity.class);
			startActivity(moreFullviewIntent);
			break;
		case R.id.rl_example:
		case R.id.rl_example1:
		case R.id.rl_example2:
		case R.id.rl_example3:
		case R.id.rl_example4:
		case R.id.rl_example5:
		case R.id.rl_example6:
		case R.id.rl_example7:
			Intent exampleFullviewIntent = new Intent(getActivity(), FullViewActivity.class);
			exampleFullviewIntent.putExtra("tag", "example");
			startActivity(exampleFullviewIntent);
			break;

		default:
			break;
		}
	}

}
