package com.test.shopcardemo;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author:Victory
 * @time:2018/1/29
 * @Email:949021037@qq.com
 * @QQ:949021037
 * @explain;
 */

public class ShopCarTitle extends AbstractExpandableItem<ShopCarContent> implements MultiItemEntity{
    private String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Override
    public int getItemType() {
        return ShopCarAdapter.SHOP_CAR_TITLE;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
