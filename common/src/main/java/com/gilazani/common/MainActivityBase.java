package com.gilazani.common;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

public class MainActivityBase extends AppCompatActivity {
    private MaterialTextView counterValue;
    private AppCompatImageView counterImage;
    private MaterialButton plusButton;
    private MaterialButton minusButton;
    private MaterialButton resetButton;

    protected DataManagerBase dataManagerBase;

    private CounterManager counterManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterManager = new CounterManager(dataManagerBase, this);

        findViews();

        fetchCounter();

        setOnClick();
    }


    private void setOnClick() {

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterValue.setText("" + counterManager.counterPlus());
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterValue.setText("" + counterManager.counterMinus());
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterValue.setText("" + counterManager.reset());
            }
        });
    }

    private void fetchCounter() {
        CounterBase counterBase = counterManager.getCounterBase();
        counterValue.setText("" + counterBase.getCount());
        counterImage.setImageResource(counterBase.getImageResourceId());

        if(counterBase.isResettable()){
            resetButton.setVisibility(View.VISIBLE);
        }else {
            resetButton.setVisibility(View.INVISIBLE);
        }
    }

    private void findViews() {
        counterValue = findViewById(R.id.counterValue);
        counterImage = findViewById(R.id.counterImage);
        plusButton = findViewById(R.id.plusButton);
        minusButton = findViewById(R.id.minusButton);
        resetButton = findViewById(R.id.resetButton);
    }

    @Override
    protected void onStop() {
        super.onStop();

        counterManager.saveCounter();
    }
}