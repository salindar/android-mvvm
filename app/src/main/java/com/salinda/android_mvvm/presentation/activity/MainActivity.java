package com.salinda.android_mvvm.presentation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.salinda.android_mvvm.R;
import com.salinda.android_mvvm.presentation.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}