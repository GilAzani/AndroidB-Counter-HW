package com.gilazani.common;

import android.content.Context;

import com.gilazani.common.CounterBase;

public abstract class DataManagerBase {

    protected String SP_KEY = "COUNTER";
    public abstract CounterBase loadCurrentCounter(Context context);

    public abstract void storeCounter(Context context, int value);
}
