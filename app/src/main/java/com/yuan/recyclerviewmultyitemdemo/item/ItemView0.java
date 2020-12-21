package com.yuan.recyclerviewmultyitemdemo.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.yuan.annotation.Item;
import com.yuan.multy_item.BaseItemView;
import com.yuan.multy_item.IItemData;
import com.yuan.multy_item.IItemEvent;
import com.yuan.multy_item.IItemVew;
import com.yuan.recyclerviewmultyitemdemo.ColorTemplate;
import com.yuan.recyclerviewmultyitemdemo.R;

/**
 * Created by yuan 2020/12/3.
 */
@Item(type = 0)
public class ItemView0 extends BaseItemView implements IItemVew {

    public ItemView0(Context context) {
        super(context);
    }

    @Override
    protected int getContentView() {
        return R.layout.item_layout_0;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setData(RecyclerView.ViewHolder holder, int position, IItemData data, IItemEvent itemEvent) {
        TextView textView = findViewById(R.id.textView);
        textView.setText("类型: " + data.getViewType());
        setBackgroundColor(Color.parseColor(ColorTemplate.COLOR_0));
        setOnClickListener(v -> itemEvent.onItemClick(ItemView0.this, position, data));
    }
}
