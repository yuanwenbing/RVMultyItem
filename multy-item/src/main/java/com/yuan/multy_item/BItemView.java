package com.yuan.multy_item;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public abstract class BItemView extends LinearLayout{
    public BItemView(Context context) {
        this(context, null);
    }

    public BItemView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setView();
        initialize();
    }

    private void setView() {
        inflate(getContext(), getContentView(), this);
        setPadding(getPadding()[0], getPadding()[1], getPadding()[2], getPadding()[3]);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
    }

    protected abstract @LayoutRes
    int getContentView();

    protected abstract void initialize();

    protected abstract @Size(min = 4, max = 4)
    int[] getPadding();


}
