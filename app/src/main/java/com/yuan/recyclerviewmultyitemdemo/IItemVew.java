package com.yuan.recyclerviewmultyitemdemo;

import android.view.View;

/**
 * Created by yuan 2019/2/13.
 */
public interface IItemVew {

    int VIEW_TYPE_0 = 0;
    int VIEW_TYPE_1 = 1;
    int VIEW_TYPE_2 = 2;

    View getItemView();

    <T extends IItemData>void setData(int position, T data);
}

