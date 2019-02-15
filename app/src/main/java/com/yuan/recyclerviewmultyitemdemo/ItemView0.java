package com.yuan.recyclerviewmultyitemdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by yuan 2019/2/13.
 */
public class ItemView0 extends LinearLayout implements IItemVew{

    private TextView mTextView;

    public ItemView0(Context context) {
        this(context, null);
    }

    public ItemView0(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ItemView0(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    protected void initialize() {
        inflate(getContext(), R.layout.item_layout_0, this);
        setPadding(0, 20, 0, 0);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setLayoutParams(layoutParams);
        mTextView = findViewById(R.id.textView);
    }

    @Override
    public View getItemView() {
        return this;
    }

    @Override
    public void setData(int position, IItemData data) {
        MockData mockData = (MockData) data;
        mTextView.setText(mockData.getTitle());
    }
}
