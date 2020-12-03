package com.yuan.multy_item;

import android.view.View;

/**
 * Created by yuan 2019/2/13.
 */

public interface IItemVew {

    View getItemView();

    <T extends IItemData>void setData(int position, T data);
}

