package com.decoverri.treasuregenerator.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.fragment.ResultFragment;
import com.decoverri.treasuregenerator.fragment.TreasureTypesFragment;
import com.decoverri.treasuregenerator.fragment.ValuesFragment;
import com.decoverri.treasuregenerator.model.TreasureType;
import com.decoverri.treasuregenerator.model.dto.GenerationResult;
import com.decoverri.treasuregenerator.task.PingTask;

import java.io.Serializable;

public class GeneratorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        if(savedInstanceState == null){
            new PingTask(this).execute();
            putTreasureTypesFragment();
        }

    }

    private void putTreasureTypesFragment() {
        TreasureTypesFragment fragment = new TreasureTypesFragment();
        if(isTablet()){
            changeFragment(R.id.treasure_types_fragment, fragment);
        }else {
            changeFragment(R.id.generator_fragment, fragment);
        }
    }

    public void putValuesFragment(String key, TreasureType type) {
        ValuesFragment fragment = new ValuesFragment();
        if (isTablet()){
            changeFragmentWithArgument(R.id.values_fragment, fragment, key, type);
        }else {
            changeReturnableFragmentWithArgument(R.id.generator_fragment, fragment, key, type);
        }
    }

    public void putResultFragment(String key, GenerationResult result) {
        ResultFragment fragment = new ResultFragment();
        if (isTablet()){
            changeFragmentWithArgument(R.id.result_fragment, fragment, key, result);
        }else {
            changeReturnableFragmentWithArgument(R.id.generator_fragment, fragment, key, result);
        }
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }

    private void changeFragment(int frame, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frame, fragment);
        transaction.commit();
    }

    private void changeFragmentWithArgument(int frame, Fragment fragment, String key, Serializable argument){
        Bundle bundle = new Bundle();
        bundle.putSerializable(key, argument);
        fragment.setArguments(bundle);
        changeFragment(frame, fragment);
    }

    private void changeReturnableFragment(int frame, Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void changeReturnableFragmentWithArgument(int frame, Fragment fragment, String key, Serializable argument){
        Bundle bundle = new Bundle();
        bundle.putSerializable(key, argument);
        fragment.setArguments(bundle);
        changeReturnableFragment(frame, fragment);
    }
}
