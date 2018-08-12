package com.example.bch__8_11.myview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MyRecycle extends RecyclerView {
    public MyRecycle(Context context) {
        super(context);
    }

    public MyRecycle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecycle(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //makeMeasureSpec根据提供的大小值和模式创建一个测量值(格式)
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
