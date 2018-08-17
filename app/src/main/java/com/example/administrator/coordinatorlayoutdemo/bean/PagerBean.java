package com.example.administrator.coordinatorlayoutdemo.bean;

/**
 * Created by kangsq on 2017/12/11.
 */

public class PagerBean extends BaseBean{


    /**
     * p : 1
     * rows : 20
     * total_count : 1811
     * total_pages : 91
     * new_data_sum : 0
     */

    private int p;
    private int rows;
    private int total_count;
    private int total_pages;
    private int new_data_sum;

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getNew_data_sum() {
        return new_data_sum;
    }

    public void setNew_data_sum(int new_data_sum) {
        this.new_data_sum = new_data_sum;
    }
}
