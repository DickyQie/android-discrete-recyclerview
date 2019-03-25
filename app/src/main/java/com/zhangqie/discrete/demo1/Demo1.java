package com.zhangqie.discrete.demo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zhangqie.discrete.DiscreteRecyclerView.DSVOrientation;
import com.zhangqie.discrete.DiscreteRecyclerView.DiscreteRecyclerView;
import com.zhangqie.discrete.DiscreteRecyclerView.InfiniteScrollAdapter;
import com.zhangqie.discrete.DiscreteRecyclerView.transform.ScaleTransformer;
import com.zhangqie.discrete.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqie on 2019/3/15
 * Describe:
 */
public class Demo1 extends AppCompatActivity {


    DiscreteRecyclerView discreteRecyclerView;

    private List<GoodBean> goodBeanList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1);
        initData();
        initView();
    }

    private void initView(){
        discreteRecyclerView = findViewById(R.id.discrete_recycler_view);
        discreteRecyclerView.setOrientation(DSVOrientation.HORIZONTAL);
        discreteRecyclerView.setItemTransitionTimeMillis(150);
        discreteRecyclerView.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());
        InfiniteScrollAdapter infiniteAdapter = InfiniteScrollAdapter.wrap(new Demo1Adapter(this,goodBeanList));
        discreteRecyclerView.setAdapter(infiniteAdapter);
    }


    private void initData(){
        goodBeanList = new ArrayList<>();
        GoodBean goodBean1 = new GoodBean();
        goodBean1.setImg(1);
        goodBean1.setContent("121");
        goodBean1.setPrice(1.22f);
        GoodBean goodBean2 = new GoodBean();
        goodBean2.setImg(1);
        goodBean2.setContent("122");
        goodBean2.setPrice(1.22f);
        GoodBean goodBean3 = new GoodBean();
        goodBean3.setImg(1);
        goodBean3.setContent("123");
        goodBean3.setPrice(1.22f);
        goodBeanList.add(goodBean1);
        goodBeanList.add(goodBean2);
        goodBeanList.add(goodBean3);
    }
}
