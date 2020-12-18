package com.yuan.multy_item;

import android.content.Context;

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
    public <T extends IItemData> void setData(int position, T data, IItemEvent itemEvent) {

    }
}
