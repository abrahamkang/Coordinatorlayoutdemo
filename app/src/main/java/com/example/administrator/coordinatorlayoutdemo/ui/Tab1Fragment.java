package com.example.administrator.coordinatorlayoutdemo.ui;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.coordinatorlayoutdemo.R;
import com.example.administrator.coordinatorlayoutdemo.adapter.Tab1Adapter;
import com.example.administrator.coordinatorlayoutdemo.bean.PagerBean;
import com.example.administrator.coordinatorlayoutdemo.bean.Tab1Bean;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * tab1列表
 * Created by kangsq on 2017/8/31.
 */

public class Tab1Fragment extends BaseLazyFragment {

    public SwipeRefreshLayout mRefreshLayout;

    private SwipeMenuRecyclerView mRecyclerView;

    private Tab1Adapter mAdapter;

    private List<Tab1Bean> mList = new ArrayList<>();

    /**
     * 默认从第一页开始加载
     */
    private final int defult_page = 1;

    /**
     * 当前页码
     */
    private int curPage = defult_page;

    /**
     * 是否是刷新状态,true为刷新，false为加载更多
     */
    private boolean isRefresh = true;


    /**
     * 创建一个实例
     *
     * @return 返回一个实例
     */
    public static Tab1Fragment newInstance() {
        Tab1Fragment tabFragment = new Tab1Fragment();
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findView(view);
        init();
        initData();
        initEvent();
        return view;
    }

    private void findView(View view) {
        mRecyclerView = view.findViewById(R.id.listview);
        mRefreshLayout = view.findViewById(R.id.refreshLayout);
    }

    public void init() {
        mRefreshLayout.setEnabled(false);

        mRecyclerView.useDefaultLoadMore(); // 使用默认的加载更多的View。
        // 加载更多的监听。
        mRecyclerView.setLoadMoreListener(mLoadMoreListener);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mAdapter = new Tab1Adapter(mList, mContext);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initData() {
        //  mRefreshLayout.autoRefresh();
    }

    private void initEvent() {

    }


    /**
     * 加载更多。
     */
    private SwipeMenuRecyclerView.LoadMoreListener mLoadMoreListener = new SwipeMenuRecyclerView.LoadMoreListener() {
        @Override
        public void onLoadMore() {
            refreshNetData(false);
        }
    };


    /**
     * 刷新网络数据(true为刷新，false为添加更多)
     *
     * @param boo
     */
    public void refreshNetData(boolean boo) {
        isRefresh = boo;
        if (isRefresh) {
            curPage = defult_page;
        }
        getDataByNet();
    }

    /**
     * 刷新数据
     *
     * @param list
     */
    private void refreshListData(List<Tab1Bean> list, PagerBean pagerBean) {
        if (isRefresh) {
            mAdapter.clear();
        }
        //curPage++;// 请求下一页
        mAdapter.addAll(list);

        int totalPages = pagerBean.getTotal_pages();
        if (curPage == totalPages) {
            //mRefreshLayout.setEnableLoadmore(false);
            // 第一次加载数据：一定要调用这个方法，否则不会触发加载更多。
            // 第一个参数：表示此次数据是否为空，假如你请求到的list为空(== null || list.size == 0)，那么这里就要true。
            // 第二个参数：表示是否还有更多数据，根据服务器返回给你的page等信息判断是否还有更多，这样可以提供性能，如果不能判断则传true。
            mRecyclerView.loadMoreFinish(false, false);
        }

        curPage++;// 请求下一页

        mRecyclerView.loadMoreFinish(false, true);

    }


    /**
     * 获取数据
     */
    private void getDataByNet() {
        List<Tab1Bean> beans = new ArrayList<>();
        beans.add(new Tab1Bean("Danny","28"));
        beans.add(new Tab1Bean("Ken","11"));
        beans.add(new Tab1Bean("David","45"));
        beans.add(new Tab1Bean("Linda","16"));
        beans.add(new Tab1Bean("Danny","28"));
        beans.add(new Tab1Bean("Ken","11"));
        beans.add(new Tab1Bean("David","45"));
        beans.add(new Tab1Bean("Linda","16"));
        beans.add(new Tab1Bean("Danny","28"));
        beans.add(new Tab1Bean("Ken","11"));
        beans.add(new Tab1Bean("David","45"));
        beans.add(new Tab1Bean("Linda","16"));



        PagerBean pagerBean = new PagerBean();
        pagerBean.setTotal_pages(2);
        pagerBean.setTotal_count(10);

        refreshListData(beans, pagerBean);
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshNetData(true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
