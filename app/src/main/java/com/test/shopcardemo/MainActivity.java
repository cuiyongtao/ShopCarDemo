package com.test.shopcardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvShopCar;
    private ShopCarAdapter mAdapter;
    ShopCarTitle shopCarTitle;
    ShopCarContent shopCarContent;
    ShopCarBottom shopCarBottom;
    int num = 0;
    ArrayList<MultiItemEntity> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rvShopCar = findViewById(R.id.rvShopCar);
        rvShopCar.setLayoutManager(new LinearLayoutManager(this));
        list = getData();
        mAdapter = new ShopCarAdapter(list);
        mAdapter.expandAll();
        rvShopCar.setAdapter(mAdapter);


        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                TextView txtNum = (TextView) mAdapter.getViewByPosition(rvShopCar, position, R.id.tv_show_num);
                switch (view.getId()) {
                    case R.id.iv_add:
                        num = Integer.valueOf(txtNum.getText().toString().trim());
                        num++;
                        if (num >= 5) {
                            Toast.makeText(MainActivity.this, "已达到最大限购数量", Toast.LENGTH_LONG).show();
                        } else {
                            shopCarContent = (ShopCarContent) mAdapter.getItem(position);
                            shopCarContent.setNum(num);
                        }
                        setPrice();
                        break;
                    case R.id.iv_sub:
                        num = Integer.valueOf(txtNum.getText().toString().trim());
                        num--;
                        if (num <= 0) {
                            Toast.makeText(MainActivity.this, "已达到最小限购数量", Toast.LENGTH_LONG).show();
                        } else {
                            shopCarContent = (ShopCarContent) mAdapter.getItem(position);
                            shopCarContent.setNum(num);
                        }
                        setPrice();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    private ArrayList<MultiItemEntity> getData() {
        ArrayList<MultiItemEntity> data = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            shopCarTitle = new ShopCarTitle();
            shopCarBottom = new ShopCarBottom();
            for (int j = 0; j < 3; j++) {
                shopCarContent = new ShopCarContent();
                shopCarContent.setNum(1);
                shopCarContent.setPrice(0.5 + j);
                shopCarContent.setCheck(true);
                shopCarTitle.addSubItem(shopCarContent);
            }
            shopCarTitle.setTitle("我是商店" + i);
            shopCarBottom.setPrice(10.00);
            data.add(shopCarTitle);
            data.add(shopCarBottom);
        }
        return data;
    }

    private void setPrice() {
        double price = 0;
        for (int i = 0; i < list.size(); i++) {
            if (mAdapter.getItem(i).getItemType() == ShopCarAdapter.SHOP_CAR_CONTENT) {
                shopCarContent = (ShopCarContent) mAdapter.getItem(i);
                price += shopCarContent.getPrice() * ((ShopCarContent) mAdapter.getItem(i)).getNum();
            }

            if (mAdapter.getItem(i).getItemType() == ShopCarAdapter.SHOP_CAR_BOTTOM) {
                shopCarBottom = (ShopCarBottom) mAdapter.getItem(i);
                shopCarBottom.setPrice(price);
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}
