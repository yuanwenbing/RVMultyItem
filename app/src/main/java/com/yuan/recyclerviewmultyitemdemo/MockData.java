package com.yuan.recyclerviewmultyitemdemo;

/**
 * Created by yuan 2019/2/15.
 */
public class MockData implements IItemData {

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
