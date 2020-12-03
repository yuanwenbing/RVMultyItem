package com.yuan.processor;

/**
 * Created by yuan 2020/12/3.
 */
class ItemElement {
    private String simpleName;
    private String packageName;
    private int value; // 注解元素值

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
