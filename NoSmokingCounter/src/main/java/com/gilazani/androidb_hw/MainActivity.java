package com.gilazani.androidb_hw;

import android.os.Bundle;

import com.gilazani.common.MainActivityBase;

public class MainActivity extends MainActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManagerBase = new NoSmokingDataManager();

        super.onCreate(savedInstanceState);
    }

}