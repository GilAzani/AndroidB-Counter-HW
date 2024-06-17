package com.gilazani.watercounter;

import android.content.Context;
import android.content.SharedPreferences;

import com.gilazani.common.CounterBase;
import com.gilazani.common.DataManagerBase;

public class WaterDataManager extends DataManagerBase {

    private final String COUNTER_NAME = "WATER";

    @Override
    public CounterBase loadCurrentCounter(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        int count = sharedPreferences.getInt(COUNTER_NAME, 0); // 0 is the default value if the key doesn't exist

        return new CounterBase()
                .setCount(count)
                .setResettable(false)
                .setImageResourceId(R.drawable.water_cup_image);
    }

    @Override
    public void storeCounter(Context context, int count) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COUNTER_NAME, count);
        editor.commit();
    }
}
