package com.test.shopcardemo;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

/**
 * @author:Victory
 * @time:2018/1/29
 * @Email:949021037@qq.com
 * @QQ:949021037
 * @explain;
 */

public class ShopCarAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int SHOP_CAR_TITLE = 0;
    public static final int SHOP_CAR_CONTENT = 1;
    public static final int SHOP_CAR_BOTTOM = 2;

    public ShopCarAdapter(List<MultiItemEntity> mData) {
        super(mData);
        addItemType(SHOP_CAR_TITLE, R.layout.layout_title);
        addItemType(SHOP_CAR_CONTENT, R.layout.layout_content);
        addItemType(SHOP_CAR_BOTTOM, R.layout.layout_bottom);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case SHOP_CAR_TITLE:
                ShopCarTitle title = (ShopCarTitle) item;
                helper.setText(R.id.title, title.getTitle());
                break;
            case SHOP_CAR_CONTENT:
                ShopCarContent content = (ShopCarContent) item;
                helper.setText(R.id.tv_show_num, content.getNum() + "");
                helper.setText(R.id.contentCommdityPrice, content.getPrice() + "");
                helper.setText(R.id.contentCommdityName, content.getName());

                helper.addOnClickListener(R.id.iv_sub);
                helper.addOnClickListener(R.id.iv_add);
                break;
            case SHOP_CAR_BOTTOM:
                ShopCarBottom bottom = (ShopCarBottom) item;
                helper.setText(R.id.bottomPrice, "小计:" + bottom.getPrice());
                break;
            default:
                break;
        }
    }

}
