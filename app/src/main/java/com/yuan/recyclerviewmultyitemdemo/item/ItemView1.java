package com.yuan.recyclerviewmultyitemdemo.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yuan.annotation.Item;
import com.yuan.multy_item.BItemView;
import com.yuan.multy_item.IItemData;
import com.yuan.multy_item.IItemVew;
import com.yuan.recyclerviewmultyitemdemo.model.Data;
import com.yuan.recyclerviewmultyitemdemo.R;

/**
 * Created by yuan 2019/2/13.
 */

@Item(type = 1)
public class ItemView1 extends BItemView implements IItemVew{

    private TextView mTextView;

    public ItemView1(Context context) {
        super(context);
    }

    public ItemView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setData(int position, IItemData data) {
        Data mockData = (Data) data;
        mTextView.setText("类型1：" + mockData.getTitle());
    }

    @Override
    protected void initialize() {
        mTextView = findViewById(R.id.textView);
    }

    @Override
    protected int getContentView() {
        return R.layout.item_layout_1;
    }

    @Override
    protected int[] getPadding() {
        return new int[]{0, 20, 0, 0};
    }

    @Override
    public View getItemView() {
        return this;
    }
}
