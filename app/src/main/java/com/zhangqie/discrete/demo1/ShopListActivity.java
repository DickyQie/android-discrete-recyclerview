package com.zhangqie.discrete.demo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.zhangqie.discrete.DiscreteRecyclerView.DSVOrientation;
import com.zhangqie.discrete.DiscreteRecyclerView.DiscreteRecyclerView;
import com.zhangqie.discrete.DiscreteRecyclerView.InfiniteScrollAdapter;
import com.zhangqie.discrete.DiscreteRecyclerView.transform.ScaleTransformer;
import com.zhangqie.discrete.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqie on 2019/3/15
 * Describe: https://github.com/yarolegovich/DiscreteScrollView
 */
public class ShopListActivity extends AppCompatActivity implements DiscreteRecyclerView.OnItemChangedListener {


    private TextView tv_name;
    private TextView tv_price;
    private DiscreteRecyclerView discreteRecyclerView;

    private List<GoodBean> goodBeanList;

    private InfiniteScrollAdapter infiniteAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_demo);
        initData();
        initView();
    }

    private void initView() {
        tv_name = findViewById(R.id.item_name);
        tv_price = findViewById(R.id.item_price);
        discreteRecyclerView = findViewById(R.id.discrete_recycler_view);
        discreteRecyclerView.setOrientation(DSVOrientation.HORIZONTAL);
        discreteRecyclerView.setItemTransitionTimeMillis(150); //设置滑动时间
        discreteRecyclerView.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());
        infiniteAdapter = InfiniteScrollAdapter.wrap(new ShopAdapter(this, goodBeanList));
        discreteRecyclerView.setAdapter(infiniteAdapter);
        onItemChanged(goodBeanList.get(0));
        discreteRecyclerView.addOnItemChangedListener(this);
    }


    @Override
    public void onCurrentItemChanged(@Nullable RecyclerView.ViewHolder viewHolder, int adapterPosition) {
        int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
        onItemChanged(goodBeanList.get(positionInDataSet));
    }

    private void onItemChanged(GoodBean item) {
        tv_name.setText(item.getContent());
        tv_price.setText("$" + item.getPrice());
    }

    private void initData() {
        goodBeanList = new ArrayList<>();
        GoodBean goodBean1 = new GoodBean();
        goodBean1.setImg(1);
        goodBean1.setContent("我是商品1");
        goodBean1.setPrice(11.25f);
        GoodBean goodBean2 = new GoodBean();
        goodBean2.setImg(1);
        goodBean2.setContent("我是商品2");
        goodBean2.setPrice(22.35f);
        GoodBean goodBean3 = new GoodBean();
        goodBean3.setImg(1);
        goodBean3.setContent("我是商品3");
        goodBean3.setPrice(666.00f);
        goodBeanList.add(goodBean1);
        goodBeanList.add(goodBean2);
        goodBeanList.add(goodBean3);
    }

}
