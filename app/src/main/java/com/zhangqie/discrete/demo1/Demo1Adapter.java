package com.zhangqie.discrete.demo1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangqie.discrete.R;

import java.util.List;

/**
 * Created by zhangqie on 2019/3/15
 * Describe:
 */
public class Demo1Adapter extends  RecyclerView.Adapter<Demo1Adapter.ViewHolder>{

    private Context context;
    private List<GoodBean> goodBeanList;
    private Integer[] strImages = new Integer[]{R.drawable.shop1,R.drawable.shop2,R.drawable.shop3};

    public Demo1Adapter(Context context, List<GoodBean> goodBeanList){
        this.context = context;
        this.goodBeanList = goodBeanList;
    }

    @Override
    public int getItemCount() {
        return goodBeanList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  view = LayoutInflater.from(context).inflate(R.layout.item1,viewGroup,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.iv_goods_icon.setImageResource(strImages[i]);
        viewHolder.tv_goods_content.setText(goodBeanList.get(i).getContent());
        viewHolder.tv_price.setText("$"+goodBeanList.get(i).getPrice());
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_goods_icon;
        TextView tv_goods_content;
        TextView tv_price;

        public ViewHolder(View view){
            super(view);
            iv_goods_icon = view.findViewById(R.id.iv_goods_icon);
            tv_goods_content = view.findViewById(R.id.tv_goods_content);
            tv_price = view.findViewById(R.id.tv_price);

        }

    }


}
