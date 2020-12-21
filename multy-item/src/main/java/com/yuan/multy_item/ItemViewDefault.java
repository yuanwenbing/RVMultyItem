package com.yuan.multy_item;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

/**
 * Created by yuan 2019/2/13.
 */
public class ItemViewDefault extends BaseItemView implements IItemVew {

    public ItemViewDefault(Context context) {
        super(context);
    }

    @Override
    protected int getContentView() {
        return 0;
    }

    @Override
    public <T extends IItemData> void setData(RecyclerView.ViewHolder viewHolder, int position, T data, IItemEvent itemEvent) {

    }
}
