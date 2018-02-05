package com.test.shopcardemo;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author:Victory
 * @time:2018/1/29
 * @Email:949021037@qq.com
 * @QQ:949021037
 * @explain;
 */

public class ShopCarBottom implements MultiItemEntity {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int getItemType() {
        return ShopCarAdapter.SHOP_CAR_BOTTOM;
    }
}
