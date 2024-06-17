package com.gilazani.watercounter;

import android.os.Bundle;

import com.gilazani.common.MainActivityBase;

public class MainActivity extends MainActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new WaterDataManager();

        super.onCreate(savedInstanceState);
    }

}