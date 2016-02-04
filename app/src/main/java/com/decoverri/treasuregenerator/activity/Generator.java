package com.decoverri.treasuregenerator.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.fragment.TreasureFragment;

public class Generator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.generator_fragment, new TreasureFragment());
        transaction.commit();
    }
}
