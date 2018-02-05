package com.test.shopcardemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author:Victory
 * @time:2018/1/29
 * @Email:949021037@qq.com
 * @QQ:949021037
 * @explain;
 */

public class ShopCarContent implements MultiItemEntity {
    private int num;
    private double price;
    private boolean isCheck;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getItemType() {
        return ShopCarAdapter.SHOP_CAR_CONTENT;
    }
}
