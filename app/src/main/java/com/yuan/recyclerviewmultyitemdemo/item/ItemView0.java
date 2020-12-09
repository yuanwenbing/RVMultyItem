package com.yuan.recyclerviewmultyitemdemo.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan.annotation.Item;
import com.yuan.multy_item.BItemView;
import com.yuan.multy_item.IItemData;
import com.yuan.multy_item.IItemEvent;
import com.yuan.multy_item.IItemVew;
import com.yuan.recyclerviewmultyitemdemo.R;
import com.yuan.recyclerviewmultyitemdemo.model.Data;

/**
 * Created by yuan 2019/2/13.
 */
@Item(type = 0)
public class ItemView0 extends BItemView implements IItemVew {

    private TextView mTextView;

    public ItemView0(Context context) {
        super(context);
    }

    public ItemView0(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemView0(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getContentView() {
        return R.layout.item_layout_0;
    }

    @Override
    protected void initialize() {
        mTextView = findViewById(R.id.textView);
    }


    @Override
    protected int[] getPadding() {
        return new int[]{0, 20, 0, 0};
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setData(int position, IItemData data, @Nullable IItemEvent itemEvent) {
        Data mockData = (Data) data;
        mTextView.setText("类型0：" + mockData.getTitle());
        handleItemClick(position, data, itemEvent);
    }

    @Override
    public View getItemView() {
        return this;
    }
}
