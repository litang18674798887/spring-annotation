package com.lt.dao;

public class BooKDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BooKDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
