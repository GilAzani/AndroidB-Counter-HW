package com.gilazani.androidb_hw;

import android.content.Context;
import android.content.SharedPreferences;

import com.gilazani.common.CounterBase;
import com.gilazani.common.DataManagerBase;

public class NoSmokingDataManager extends DataManagerBase {

    private final String COUNTER_NAME = "NO_SMOKING";
    @Override
    public CounterBase loadCurrentCounter(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        int count = sharedPreferences.getInt(COUNTER_NAME, 0); // 0 is the default value if the key doesn't exist

        return new CounterBase()
                .setCount(count)
                .setResettable(true)
                .setImageResourceId(R.drawable.no_smoking);
    }

    @Override
    public void storeCounter(Context context, int count) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_NAME, count);
        editor.commit();
    }
}
