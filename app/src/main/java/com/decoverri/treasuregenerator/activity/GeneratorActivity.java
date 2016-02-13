package com.decoverri.treasuregenerator.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.fragment.TreasureTypesFragment;

public class GeneratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        changeReturnableFragment(new TreasureTypesFragment());
    }

    public void changeReturnableFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.generator_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
