package com.zhangqie.discrete.DiscreteRecyclerView.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.zhangqie.discrete.DiscreteRecyclerView.DiscreteRecyclerView;


public class ScrollListenerAdapter<T extends RecyclerView.ViewHolder> implements DiscreteRecyclerView.ScrollStateChangeListener<T> {

    private DiscreteRecyclerView.ScrollListener<T> adaptee;

    public ScrollListenerAdapter(@NonNull DiscreteRecyclerView.ScrollListener<T> adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void onScrollStart(@NonNull T currentItemHolder, int adapterPosition) {

    }

    @Override
    public void onScrollEnd(@NonNull T currentItemHolder, int adapterPosition) {

    }

    @Override
    public void onScroll(float scrollPosition,
                         int currentIndex, int newIndex,
                         @Nullable T currentHolder, @Nullable T newCurrentHolder) {
        adaptee.onScroll(scrollPosition, currentIndex, newIndex, currentHolder, newCurrentHolder);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScrollListenerAdapter) {
            return adaptee.equals(((ScrollListenerAdapter) obj).adaptee);
        } else {
            return super.equals(obj);
        }
    }
}
