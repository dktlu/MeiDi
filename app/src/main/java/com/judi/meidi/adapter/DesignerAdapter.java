package com.judi.meidi.adapter;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.judi.meidi.R;
import com.judi.meidi.modul.DesignerInfo;
import com.judi.meidi.utils.Util;

import java.util.ArrayList;

/**
 * 设计师界面适配器
 * Created by Administrator on 2016/4/1.
 */
public class DesignerAdapter extends RecyclerView.Adapter {

    private LayoutInflater mLayoutInflater;
    private ArrayList<DesignerInfo> designerInfos;
    private Context context;

    public DesignerAdapter(Context context, ArrayList<DesignerInfo> designerInfos) {
        this.context = context;
        this.designerInfos = designerInfos;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.item_designer_list, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvName.setText(designerInfos.get(position).getName());
        viewHolder.tvPosition.setText(designerInfos.get(position).getPosition());
        viewHolder.ivDesigner.setBackgroundResource(designerInfos.get(position).getPicID());

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point size = new Point();
        wm.getDefaultDisplay().getSize(size);
        int width = size.x - Util.dip2px(context, 20);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width / 2, width * 3 / 4);
        viewHolder.ivDesigner.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return designerInfos.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private TextView tvPosition;
        private ImageView ivDesigner;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPosition = (TextView) itemView.findViewById(R.id.tv_position);
            ivDesigner = (ImageView) itemView.findViewById(R.id.iv_designer);
        }
    }
}
