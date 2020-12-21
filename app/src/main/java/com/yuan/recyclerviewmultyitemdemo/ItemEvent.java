package com.yuan.recyclerviewmultyitemdemo;

import android.view.View;
import android.widget.Toast;

import com.yuan.multy_item.IItemData;
import com.yuan.multy_item.IItemEvent;
/**
 * Created by yuan 2020/12/3.
 */
public class ItemEvent implements IItemEvent {
    @Override
    public <T extends IItemData> void onItemClick(View view, int position, T data) {
        Toast.makeText(view.getContext(), "type:" + data.getViewType() + " position:" + position, Toast.LENGTH_SHORT).show();
    }
}
