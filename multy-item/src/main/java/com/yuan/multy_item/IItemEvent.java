package com.yuan.multy_item;

public interface IItemEvent {
    <T extends IItemData>void onItemClick(int position, T data);
}
