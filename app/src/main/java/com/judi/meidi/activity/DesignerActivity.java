package com.judi.meidi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.judi.meidi.R;
import com.judi.meidi.adapter.DesignerAdapter;
import com.judi.meidi.base.BaseActivity;
import com.judi.meidi.modul.DesignerInfo;
import com.judi.meidi.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.judi.meidi.recyclerview.HeaderSpanSizeLookup;

import java.util.ArrayList;

/**
 * 设计师列表界面
 *
 * @author dengkaitao
 * @date 2016年3月31日下午16:02:25
 */
public class DesignerActivity extends BaseActivity {

    private RecyclerView recyclerview;
    private DesignerAdapter adapter;
    private ArrayList<DesignerInfo> designerInfos;
    private HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter;

    private TextView tvBack;
    private TextView tvShare;

    @Override
    public void onClick(View arg0) {
        switch (arg0.getId()) {
            case R.id.tv_back:
                DesignerActivity.this.finish();
                break;
        }
    }

    @Override
    public void setBasicInfo(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_designer;
    }

    @Override
    public void initViews() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        tvBack = (TextView) findViewById(R.id.tv_back);
        tvShare = (TextView) findViewById(R.id.tv_share);
    }

    @Override
    public void bindViews() {
        tvBack.setOnClickListener(this);
        tvShare.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setDesignerData();
        adapter = new DesignerAdapter(getApplicationContext(), designerInfos);
        headerAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        recyclerview.setAdapter(headerAndFooterRecyclerViewAdapter);

        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup(
                (HeaderAndFooterRecyclerViewAdapter) recyclerview.getAdapter(), manager.getSpanCount()));
        recyclerview.setLayoutManager(manager);

        headerAndFooterRecyclerViewAdapter.setOnItemClickListener(new HeaderAndFooterRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, long id) {
                Intent designerIntent = new Intent(DesignerActivity.this, DesignerDetailActivity.class);
                designerIntent.putExtra("designerinfo", designerInfos.get(position));
                startActivity(designerIntent);
            }
        });
    }

    /**
     * 添加设计师本地数据
     */
    private void setDesignerData() {
        designerInfos = new ArrayList<>();
        DesignerInfo info1 = new DesignerInfo();
        info1.setName("邓艳");
        info1.setPosition("高级设计师");
        info1.setPicID(R.drawable.bg_designer_1);
        info1.setSchool("浙江大学 室内外控件拓展设计专业");
        info1.setWorksExperience("6年");
        info1.setProduct("麓谷小镇 金南家园 潇湘奥林匹克花园等");
        info1.setDesignConcept("自然 简约 艺术");
        info1.setStyle("现代中式 古典中式 古典欧式");
        info1.setPhone("0731-87098639");

        DesignerInfo info2 = new DesignerInfo();
        info2.setName("夏元");
        info2.setPosition("首席设计师");
        info2.setPicID(R.drawable.bg_designer_2);
        info2.setSchool("云南大学 进修四川美术学院 室内外控件拓展设计专业");
        info2.setWorksExperience("8年");
        info2.setProduct("金科东方大院、世贸铂翠湾、达美D6、长城时代城等");
        info2.setDesignConcept("自然 人文 艺术 平民化");
        info2.setStyle("台式现代人文 日式无印良品风 现代中式 古典欧式等");
        info2.setPhone("0731-87098639");

        DesignerInfo info3 = new DesignerInfo();
        info3.setName("邓艳");
        info3.setPosition("高级设计师");
        info3.setPicID(R.drawable.bg_designer_1);
        info3.setSchool("浙江大学 室内外控件拓展设计专业");
        info3.setWorksExperience("6年");
        info3.setProduct("麓谷小镇 金南家园 潇湘奥林匹克花园等");
        info3.setDesignConcept("自然 简约 艺术");
        info3.setStyle("现代中式 古典中式 古典欧式");
        info3.setPhone("0731-87098639");

        DesignerInfo info4 = new DesignerInfo();
        info4.setName("夏元");
        info4.setPosition("首席设计师");
        info4.setPicID(R.drawable.bg_designer_2);
        info4.setSchool("云南大学 进修四川美术学院 室内外控件拓展设计专业");
        info4.setWorksExperience("8年");
        info4.setProduct("金科东方大院、世贸铂翠湾、达美D6、长城时代城等");
        info4.setDesignConcept("自然 人文 艺术 平民化");
        info4.setStyle("台式现代人文 日式无印良品风 现代中式 古典欧式等");
        info4.setPhone("0731-87098639");

        designerInfos.add(info1);
        designerInfos.add(info2);
        designerInfos.add(info3);
        designerInfos.add(info4);
    }

}
