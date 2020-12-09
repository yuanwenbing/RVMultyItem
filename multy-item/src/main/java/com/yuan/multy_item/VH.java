package com.yuan.multy_item;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class VH extends RecyclerView.ViewHolder {
    private IItemVew itemVew;

    public VH(IItemVew itemView) {
        super(itemView.getItemView());
        this.itemVew = itemView;
    }

    <T extends IItemData> void bindData(int position, @NonNull T data, @Nullable IItemEvent itemEvent) {
        if (data != null) {
            try {
                itemVew.setData(position, data, itemEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}