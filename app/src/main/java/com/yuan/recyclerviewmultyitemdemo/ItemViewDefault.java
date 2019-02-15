package com.yuan.recyclerviewmultyitemdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by yuan 2019/2/13.
 */
public class ItemViewDefault extends LinearLayout implements IItemVew{

    public ItemViewDefault(Context context) {
        this(context, null);
    }

    public ItemViewDefault(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public ItemViewDefault(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View getItemView() {
        return null;
    }

    @Override
    public void setData(int position, IItemData data) {

    }
}
