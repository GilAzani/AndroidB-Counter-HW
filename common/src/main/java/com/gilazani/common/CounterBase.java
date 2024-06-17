package com.gilazani.common;

public class CounterBase {

    private int count;
    private boolean isResettable;

    private int imageResourceId; // Drawable resource ID

    public int getImageResourceId() {
        return imageResourceId;
    }

    public CounterBase setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
        return this;
    }

    public CounterBase() {
    }

    public int getCount() {
        return count;
    }

    public CounterBase setCount(int count) {
        this.count = count;
        return this;
    }

    public boolean isResettable() {
        return isResettable;
    }

    public CounterBase setResettable(boolean resettable) {
        isResettable = resettable;
        return this;
    }
}
