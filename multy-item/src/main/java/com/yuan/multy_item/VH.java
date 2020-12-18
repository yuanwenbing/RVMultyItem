package com.yuan.multy_item;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class VH extends RecyclerView.ViewHolder {
    private final IItemVew itemVew;

    public VH(IItemVew itemView) {
        super((View) itemView.getItemView());
        this.itemVew = itemView;
    }

    <T extends IItemData> void bindData(int position, @NonNull T data, @Nullable IItemEvent itemEvent) {
        try {
            itemVew.setData(position, data, itemEvent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}