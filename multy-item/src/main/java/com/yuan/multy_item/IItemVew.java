package com.yuan.multy_item;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by yuan 2019/2/13.
 */

public interface IItemVew {

    default IItemVew getItemView(){
        return this;
    }

    <T extends IItemData>void setData(RecyclerView.ViewHolder viewHolder, int position, T data, IItemEvent itemEvent);
}

