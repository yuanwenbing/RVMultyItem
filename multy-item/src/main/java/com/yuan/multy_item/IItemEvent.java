package com.yuan.multy_item;

import android.view.View;

public interface IItemEvent {
    <T extends IItemData>void onItemClick(View view, int position, T data);
}
