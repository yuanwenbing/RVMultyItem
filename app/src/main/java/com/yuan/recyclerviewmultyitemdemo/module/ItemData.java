package com.yuan.recyclerviewmultyitemdemo.module;

import com.yuan.annotation.Path;
import com.yuan.multy_item.IItemData;

/**
 * Created by yuan 2020/12/3.
 */
@Path(path = "com.yuan.recyclerviewmultyitemdemo")
public class ItemData implements IItemData {

    private int type;

    private String title;

    private String content;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int getViewType() {
        return type;
    }
}
