package com.judi.meidi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.judi.meidi.R;
import com.judi.meidi.modul.FullViewInfo;

import java.util.ArrayList;

/**
 * 360°全景图界面适配器
 * Created by Administrator on 2016/4/1.
 */
public class FullViewAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<FullViewInfo> fullViewInfos;
    private LayoutInflater mLayoutInflator;
    private String tag;

    public FullViewAdapter(Context context, ArrayList<FullViewInfo> fullViewInfos, String tag) {
        this.context = context;
        this.fullViewInfos = fullViewInfos;
        this.tag = tag;
        mLayoutInflator = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflator.inflate(R.layout.item_fullview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.ivPhoto.setBackgroundResource(fullViewInfos.get(position).getPicID());
        viewHolder.tvTitle.setText(fullViewInfos.get(position).getTitle());
        viewHolder.tvLikeNumber.setText(fullViewInfos.get(position).getLikeNumber());
        viewHolder.tvStyleName.setText(fullViewInfos.get(position).getStyleName());
        viewHolder.tvArea.setText(fullViewInfos.get(position).getArea());
        viewHolder.tvAdvantage.setText(fullViewInfos.get(position).getAdvantage());
        if (tag != null && "example".equals(tag)) {
            viewHolder.tvTag.setVisibility(View.GONE);
        } else {
            viewHolder.tvTag.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return fullViewInfos.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private ImageView ivLike;
        private TextView tvTitle;
        private TextView tvLikeNumber;
        private TextView tvStyleName;
        private TextView tvArea;
        private TextView tvHouseType;
        private TextView tvAdvantage;
        private TextView tvTag;

        public ViewHolder(View itemView) {
            super(itemView);

            ivPhoto = (ImageView) itemView.findViewById(R.id.iv_photo);
            ivLike = (ImageView) itemView.findViewById(R.id.iv_like);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvLikeNumber = (TextView) itemView.findViewById(R.id.tv_like_number);
            tvStyleName = (TextView) itemView.findViewById(R.id.tv_style_name);
            tvArea = (TextView) itemView.findViewById(R.id.tv_area);
            tvHouseType = (TextView) itemView.findViewById(R.id.tv_house_type);
            tvAdvantage = (TextView) itemView.findViewById(R.id.tv_advantage);
            tvTag = (TextView) itemView.findViewById(R.id.tv_tag);
        }
    }
}
