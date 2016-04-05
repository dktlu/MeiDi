package com.judi.meidi.activity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.judi.meidi.R;
import com.judi.meidi.base.BaseActivity;
import com.judi.meidi.modul.FullViewInfo;
import com.judi.meidi.utils.Util;

public class FullViewDetailActivity extends BaseActivity {

    private ImageView ivPthoto;
    private TextView tvDesigner;
    private TextView tvArea;
    private TextView tvHouseType;
    private TextView tvAdvantage;
    private TextView tvDes;

    private TextView tvBack;
    private TextView tvShare;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;


    private FullViewInfo fullviewinfo;

    @Override
    public void setBasicInfo(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_full_view_detail;
    }

    @Override
    public void initViews() {
        ivPthoto = (ImageView) findViewById(R.id.iv_photo);
        tvAdvantage = (TextView) findViewById(R.id.tv_advantage);
        tvArea = (TextView) findViewById(R.id.tv_area);
        tvDes = (TextView) findViewById(R.id.tv_des);
        tvDesigner = (TextView) findViewById(R.id.tv_designer);
        tvHouseType = (TextView) findViewById(R.id.tv_house_type);
        tvBack = (TextView) findViewById(R.id.tv_back);
        tvShare = (TextView) findViewById(R.id.tv_share);
        tv1 = (TextView) findViewById(R.id.tv_1);
        tv2 = (TextView) findViewById(R.id.tv_2);
        tv3 = (TextView) findViewById(R.id.tv_3);
        tv4 = (TextView) findViewById(R.id.tv_4);
    }

    @Override
    public void bindViews() {
        tvBack.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
    }

    @Override
    public void initData() {

        tv1.setText("设计风格");
        tv2.setText("房屋户型");
        tv3.setText("房屋面积");
        tv4.setText("套餐类型");

        fullviewinfo = (FullViewInfo) getIntent().getSerializableExtra("fullviewinfo");
        if (fullviewinfo != null) {
            ivPthoto.setBackgroundResource(fullviewinfo.getPicID());
            WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            Point size = new Point();
            wm.getDefaultDisplay().getSize(size);
            int width = size.x - Util.dip2px(getApplicationContext(), 10);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, width);
            ivPthoto.setLayoutParams(params);

            tvAdvantage.setText(fullviewinfo.getAdvantage());
            tvArea.setText(fullviewinfo.getArea());
            tvDes.setText(fullviewinfo.getDes());
            tvDesigner.setText(fullviewinfo.getDesigner());
            tvHouseType.setText(fullviewinfo.getHouseType());

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                FullViewDetailActivity.this.finish();
                break;
            case R.id.tv_share:

                break;
        }
    }
}
