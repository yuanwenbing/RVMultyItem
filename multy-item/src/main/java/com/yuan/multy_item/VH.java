package com.yuan.multy_item;

import android.support.v7.widget.RecyclerView;

public class VH extends RecyclerView.ViewHolder {
    private IItemVew itemVew;

    public VH(IItemVew itemView) {
        super(itemView.getItemView());
        this.itemVew = itemView;
    }

    <T extends IItemData> void bindData(int position, T data) {
        if (data != null) {
            try {
                itemVew.setData(position, data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}