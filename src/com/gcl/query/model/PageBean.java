package com.gcl.query.model;

import java.util.List;

public class PageBean<T>{
    //基本属性
    private int currentPageNum;//当前页数，由用户指定
    private int pageSize=5;//每页显示的条数，固定的
    private int totalRecords;//总记录条数
    private int totalPageNum;//总页数，计算出来的=totalRecords/pageSize
    private List<T> list;//已经分好页的结果集
    //getter和setter方法
    public int getCurrentPageNum(){
        return this.currentPageNum;
    }
    public void setCurrentPageNum(int currentPageNum){
        this.currentPageNum=currentPageNum;
    }
    public int getPageSize(){
        return this.pageSize;
    }
    public void setPageSize(int pageSize){
        this.pageSize=pageSize;
    }
    public int getTotalRecords(){
        return this.totalRecords;
    }
    public List getList(){
        return list;
    }
    public void setList(List list){
        this.list=list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPageNum=" + currentPageNum +
                ", pageSize=" + pageSize +
                ", totalRecords=" + totalRecords +
                ", totalPageNum=" + totalPageNum +
                ", list=" + list +
                '}';
    }
}
