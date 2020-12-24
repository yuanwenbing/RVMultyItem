package com.yuan.multy_item;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public abstract class BaseItemView extends LinearLayout{

    public BaseItemView(Context context) {
        this(context, null);
    }

    public BaseItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView();
    }

    private void setView() {
        if(getContentView() == 0) return;
        inflate(getContext(), getContentView(), this);
        setPadding(getPadding()[0], getPadding()[1], getPadding()[2], getPadding()[3]);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    protected abstract @LayoutRes int getContentView();

    protected @Size(min = 4, max = 4) int[] getPadding(){
        return new int[]{0, 20, 0, 0};
    }

}
