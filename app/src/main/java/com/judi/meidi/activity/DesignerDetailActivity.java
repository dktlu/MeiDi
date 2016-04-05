package com.judi.meidi.activity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.judi.meidi.R;
import com.judi.meidi.base.BaseActivity;
import com.judi.meidi.modul.DesignerInfo;
import com.judi.meidi.recyclerview.HeaderAndFooterRecyclerViewAdapter;
import com.judi.meidi.recyclerview.HeaderSpanSizeLookup;
import com.judi.meidi.utils.StringUtil;
import com.judi.meidi.utils.Util;

import java.util.ArrayList;

public class DesignerDetailActivity extends BaseActivity {

    private RelativeLayout rlDesignerInfo;

    private RecyclerView recyclerView;
    private ArrayList<Integer> images;
    private HeaderAndFooterRecyclerViewAdapter headerAndFooterRecyclerViewAdapter;

    private TextView tvBack;
    private TextView tvShare;

    private ImageView ivDesignerPhoto;
    private TextView tvName;
    private TextView tvSchool;
    private TextView tvWorksExperience;
    private TextView tvProduct;
    private TextView tvDesignConcept;
    private TextView tvDesignStyle;
    private TextView tvWinning;
    private TextView tvPhone;

    @Override
    public void setBasicInfo(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_designer_detail;
    }

    @Override
    public void initViews() {
        rlDesignerInfo = (RelativeLayout) findViewById(R.id.rl_designer_info);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvSchool = (TextView) findViewById(R.id.tv_school);
        tvWorksExperience = (TextView) findViewById(R.id.tv_works_experience);
        tvProduct = (TextView) findViewById(R.id.tv_product);
        tvDesignConcept = (TextView) findViewById(R.id.tv_design_concept);
        tvDesignStyle = (TextView) findViewById(R.id.tv_design_style);
        tvWinning = (TextView) findViewById(R.id.tv_winning);
        tvPhone = (TextView) findViewById(R.id.tv_phone);
        ivDesignerPhoto = (ImageView) findViewById(R.id.iv_designer_photo);

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
        recyclerView.setFocusable(false);

        DesignerInfo info = (DesignerInfo) getIntent().getSerializableExtra("designerinfo");
        if (null != info) {
            ivDesignerPhoto.setBackgroundResource(info.getPicID());
            tvName.setText(info.getPosition() + "：" + info.getName());
            tvSchool.setText(getStylerStr("毕业学校："+ getStrWithisEmpty(info.getSchool()), 5));
            tvWorksExperience.setText(getStylerStr("工作经验：" + getStrWithisEmpty(info.getWorksExperience()), 5));
            tvProduct.setText(getStylerStr("代表作品：" + getStrWithisEmpty(info.getProduct()), 5));
            tvDesignConcept.setText(getStylerStr("设计理念：" + getStrWithisEmpty(info.getDesignConcept()), 5));
            tvDesignStyle.setText(getStylerStr("设计风格：" + getStrWithisEmpty(info.getStyle()), 5));
            tvWinning.setText(getStylerStr("获奖情况：" + getStrWithisEmpty(info.getWinning()), 5));
            tvPhone.setText(getStylerStr("咨询电话：" + getStrWithisEmpty(info.getPhone()), 5));
        }

        WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        int width = size.x;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width / 2, width * 3 / 4);
        rlDesignerInfo.setLayoutParams(params);
        params.setMargins(Util.dip2px(getApplicationContext(), 5), 0, 0, 0);
        ivDesignerPhoto.setLayoutParams(params);

        setDesignerData();
        PhotoAdapter adapter = new PhotoAdapter();
        headerAndFooterRecyclerViewAdapter = new HeaderAndFooterRecyclerViewAdapter(adapter);
        recyclerView.setAdapter(headerAndFooterRecyclerViewAdapter);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        manager.setSpanSizeLookup(new HeaderSpanSizeLookup(
                (HeaderAndFooterRecyclerViewAdapter) recyclerView.getAdapter(), manager.getSpanCount()));
        recyclerView.setLayoutManager(manager);

    }

    private void setDesignerData() {
        images = new ArrayList<>();
        images.add(R.drawable.bg_fullview_1);
        images.add(R.drawable.bg_fullview_2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                DesignerDetailActivity.this.finish();
                break;
        }
    }

    /**
     * 出来字段无数据是返回""
     * @param context
     * @return
     */
    private String getStrWithisEmpty(String context) {
        return StringUtil.isEmpty(context) ? "" : context;
    }

    /**
     * 设置字体样式
     * @param context
     * @param end
     * @return
     */
    private SpannableStringBuilder getStylerStr(String context, int end) {
        SpannableStringBuilder builder = new SpannableStringBuilder(context);
        ForegroundColorSpan span6 = new ForegroundColorSpan(ContextCompat.getColor(getApplicationContext(), R.color.color_6));
        ForegroundColorSpan span9 = new ForegroundColorSpan(ContextCompat.getColor(getApplicationContext(), R.color.color_9));
        builder.setSpan(span6, 0, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setSpan(span9, end, context.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return builder;
    }

    private class PhotoAdapter extends RecyclerView.Adapter {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_designer_example, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.ivPhoto.setBackgroundResource(images.get(position));
            WindowManager wm = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
            Point size = new Point();
            wm.getDefaultDisplay().getSize(size);
            int width = size.x;
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width / 2, width / 2);
            params.setMargins(Util.dip2px(getApplicationContext(), 5), Util.dip2px(getApplicationContext(), 5),
                    Util.dip2px(getApplicationContext(), 5), Util.dip2px(getApplicationContext(), 5));
            viewHolder.ivPhoto.setLayoutParams(params);
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder {

            public ImageView ivPhoto;
            public ViewHolder(View itemView) {
                super(itemView);
                ivPhoto = (ImageView) itemView.findViewById(R.id.iv_photo);
            }
        }
    }

}
