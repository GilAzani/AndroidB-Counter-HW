package com.gilazani.common;

import android.content.Context;

import com.gilazani.common.CounterBase;
import com.gilazani.common.DataManagerBase;

public class CounterManager {

    private CounterBase counterBase;

    private DataManagerBase dataManagerBase;

    private Context context;

    public CounterManager(DataManagerBase dataManagerBase, Context context) {
        this.dataManagerBase = dataManagerBase;
        this.context = context;
        counterBase = dataManagerBase.loadCurrentCounter(context);
    }

    public void saveCounter(){
        dataManagerBase.storeCounter(context, counterBase.getCount());
    }

    public CounterBase getCounterBase(){
        return counterBase;
    }

    public int counterPlus(){
        int new_count = counterBase.getCount() + 1;

        counterBase.setCount(new_count);
        return new_count;
    }

    public int counterMinus(){
        int new_count = counterBase.getCount() - 1;

        if (new_count < 0){
            return 0; // cannot count negative numbers
        }
        counterBase.setCount(new_count);
        return new_count;
    }

    public int reset(){
        if (! counterBase.isResettable()){
            return -1;
        }
        counterBase.setCount(0);
        return 0;
    }
}
