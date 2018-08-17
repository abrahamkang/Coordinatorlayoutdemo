package com.example.administrator.coordinatorlayoutdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.coordinatorlayoutdemo.R;
import com.example.administrator.coordinatorlayoutdemo.bean.Tab1Bean;

import java.util.ArrayList;
import java.util.List;


/**
 * Tab1Adapter
 * Created by kangsq on 2018/1/3.
 */

public class Tab1Adapter extends RecyclerView.Adapter<Tab1Adapter.EntryHolder> {

    private Context mContext;        //上下文对象

    private List<Tab1Bean> mList;

    private onEntryClick mOnEntryClick;

    private int screen_widthOffset;


    public interface onEntryClick {
        void doEntry(int position);
    }

    public void setOnEntryClick(onEntryClick onEntryClick) {
        this.mOnEntryClick = onEntryClick;
    }

    //构造方法
    public Tab1Adapter(List<Tab1Bean> list, Context context) {
        this.mContext = context;
        this.mList = list;
    }


    @Override
    public EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tab1, parent, false);
        EntryHolder viewHolder = new EntryHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EntryHolder holder, final int position) {
        try {

            final Tab1Bean bean = mList.get(position);
            holder.nameTV.setText(bean.getName() == null ? "" : bean.getName());
            holder.ageTV.setText(bean.getAge() == null ? "" : bean.getAge());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    class EntryHolder extends RecyclerView.ViewHolder {
        TextView ageTV ,nameTV;

        public EntryHolder(View convertView) {
            super(convertView);
            nameTV = convertView.findViewById(R.id.item_name_tv);
            ageTV = convertView.findViewById(R.id.item_age_tv);
        }

    }

    /**
     * 清空数据
     */
    public void clear() {
        if (mList != null) {
            mList.clear();
            //notifyDataSetChanged();
        }
    }

    /**
     * 添加数据
     */

    public void addAll(List<Tab1Bean> beanList) {
        if (this.mList == null) {
            this.mList = new ArrayList<>();
        }
        this.mList.addAll(beanList);
        notifyDataSetChanged();
    }


    public List<Tab1Bean> getAdapterInfos() {
        return mList;
    }

}
