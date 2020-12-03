package com.yuan.recyclerviewmultyitemdemo.item;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuan.annotation.Item;
import com.yuan.multy_item.IItemData;
import com.yuan.multy_item.IItemVew;
import com.yuan.recyclerviewmultyitemdemo.model.Data;
import com.yuan.recyclerviewmultyitemdemo.R;

/**
 * Created by yuan 2019/2/13.
 */

@Item(type = 1)
public class ItemView1 extends LinearLayout implements IItemVew {


    private TextView mTextView;

    public ItemView1(Context context) {
        this(context, null);
    }

    public ItemView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ItemView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    protected void initialize() {
        inflate(getContext(), R.layout.item_layout_1, this);
        setPadding(0, 20, 0, 0);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        this.setLayoutParams(layoutParams);
        mTextView = findViewById(R.id.textView);
    }

    @Override
    public View getItemView() {
        return this;
    }

    @Override
    public void setData(int position, IItemData data) {
        Data mockData = (Data) data;
        mTextView.setText(mockData.getTitle());
    }
}