package com.yuan.recyclerviewmultyitemdemo.item;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;

import com.yuan.annotation.Item;
import com.yuan.multy_item.BaseItemView;
import com.yuan.multy_item.IItemData;
import com.yuan.multy_item.IItemEvent;
import com.yuan.multy_item.IItemVew;
import com.yuan.recyclerviewmultyitemdemo.ColorTemplate;
import com.yuan.recyclerviewmultyitemdemo.R;

/**
 * Created by yuan 2019/2/13.
 */

@Item(type = 1)
public class ItemView1 extends BaseItemView implements IItemVew {

    public ItemView1(Context context) {
        super(context);
    }

    @Override
    protected int getContentView() {
        return R.layout.item_layout_1;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void setData(int position, IItemData data, IItemEvent itemEvent) {
        TextView textView = findViewById(R.id.textView);
        textView.setText("类型: " + data.getViewType() );
        setBackgroundColor(Color.parseColor(ColorTemplate.COLOR_1));
        setOnClickListener(v -> itemEvent.onItemClick(ItemView1.this, position, data));
    }

}
