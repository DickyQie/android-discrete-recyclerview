package com.zhangqie.discrete.DiscreteRecyclerView.transform;

import android.view.View;


public interface DiscreteScrollItemTransformer {
    void transformItem(View item, float position);
}
