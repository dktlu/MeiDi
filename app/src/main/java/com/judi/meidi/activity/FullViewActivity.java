package com.judi.meidi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.judi.meidi.R;
import com.judi.meidi.adapter.FullViewAdapter;
import com.judi.meidi.base.BaseActivity;
import com.judi.meidi.modul.FullViewInfo;
import com.judi.meidi.recyclerview.HeaderAndFooterRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * 360°全景图
 */
public class FullViewActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private TextView tvBack;
    private TextView tvShare;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    private FullViewAdapter adapter;
    private HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter;
    private ArrayList<FullViewInfo> fullViewInfos;

    private String tag;

    @Override
    public void setBasicInfo(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_full_view;
    }

    @Override
    public void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
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
    }

    @Override
    public void initData() {

        tag = getIntent().getStringExtra("tag");

        if (tag != null && "example".equals(tag)) {
            tv1.setText("设计风格");
            tv2.setText("房屋户型");
            tv3.setText("房屋面积");
            tv4.setText("套餐类型");
        } else {
            tv1.setText("设计风格");
            tv2.setVisibility(View.INVISIBLE);
            tv3.setVisibility(View.INVISIBLE);
            tv4.setVisibility(View.INVISIBLE);
        }

        setFullViewData();
        adapter = new FullViewAdapter(getApplicationContext(), fullViewInfos, tag);
        headerAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        recyclerView.setAdapter(headerAndFooterRecyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        headerAndFooterRecyclerViewAdapter.setOnItemClickListener(new HeaderAndFooterRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id) {
                Intent detailIntent = new Intent(FullViewActivity.this, FullViewDetailActivity.class);
                detailIntent.putExtra("fullviewinfo", fullViewInfos.get(position));
                startActivity(detailIntent);
            }
        });
    }

    private void setFullViewData() {
        fullViewInfos = new ArrayList<>();

        FullViewInfo info1 = new FullViewInfo();
        info1.setPicID(R.drawable.bg_fullview_list_1);
        info1.setTitle("现代欧式 | 水榭华庭");
        info1.setLikeNumber("98");
        info1.setStyleName("风格：现代欧式");
        info1.setArea("面积：120平米");
        info1.setHouseType("户型：四室两厅");
        info1.setAdvantage("亮：欧式 现代 简约");
        info1.setDes("以艺术打造外型，以品质建构内涵；拥有品质是一种高贵");
        info1.setDesigner("爱德华");

        FullViewInfo info2 = new FullViewInfo();
        info2.setPicID(R.drawable.bg_fullview_list_2);
        info2.setTitle("日式简约 | 水榭华庭");
        info2.setLikeNumber("98");
        info2.setStyleName("风格：现代欧式");
        info2.setArea("面积：120平米");
        info2.setHouseType("户型：四室两厅");
        info2.setAdvantage("亮：欧式 现代 简约");
        info2.setDes("以艺术打造外型，以品质建构内涵；拥有品质是一种高贵");
        info2.setDesigner("邓艳");

        FullViewInfo info3 = new FullViewInfo();
        info3.setPicID(R.drawable.bg_fullview_list_3);
        info3.setTitle("日式简约 | 水榭华庭");
        info3.setLikeNumber("98");
        info3.setStyleName("风格：现代欧式");
        info3.setArea("面积：120平米");
        info3.setHouseType("户型：四室两厅");
        info3.setAdvantage("亮：欧式 现代 简约");
        info3.setDes("以艺术打造外型，以品质建构内涵；拥有品质是一种高贵");
        info3.setDesigner("夏元");

        fullViewInfos.add(info1);
        fullViewInfos.add(info2);
        fullViewInfos.add(info3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                FullViewActivity.this.finish();
                break;
            case R.id.tv_share:

                break;
        }
    }
}
