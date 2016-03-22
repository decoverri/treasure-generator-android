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

    private Fragment valuesFragment;
    private Fragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        new PingTask(this).execute();

        putTreasureTypesFragment();

        Log.i("DECO", "onCreate da activity");

        if(savedInstanceState != null){
            valuesFragment = getSupportFragmentManager().getFragment(savedInstanceState, "values");
            if(valuesFragment != null){
                Log.i("DECO", "putando values fragment");
                putSavedValuesFragment(valuesFragment);
            }

            resultFragment = getSupportFragmentManager().getFragment(savedInstanceState, "result");
            if(resultFragment != null){
                Log.i("DECO", "putando result fragment");
                putSavedResultFragment(resultFragment);
            }
        }

    }

    private void putTreasureTypesFragment() {
        TreasureTypesFragment fragment = new TreasureTypesFragment();
        if(isTablet()){
            changeFragment(R.id.treasure_types_fragment, fragment);
        }else{
            changeFragment(R.id.generator_fragment, fragment);
        }
    }

    public void putValuesFragment(String key, TreasureType type) {
        ValuesFragment fragment = new ValuesFragment();
        valuesFragment = fragment;
        if (isTablet()){
            changeFragmentWithArgument(R.id.values_fragment, fragment, key, type);
        }else {
            changeReturnableFragmentWithArgument(R.id.generator_fragment, fragment, key, type);
        }
    }

    public void putSavedValuesFragment(Fragment valuesFragment) {
        if (isTablet()){
            changeFragment(R.id.values_fragment, valuesFragment);
        }else {
            changeReturnableFragment(R.id.generator_fragment, valuesFragment);
        }
    }

    public void putResultFragment(String key, GenerationResult result) {
        ResultFragment fragment = new ResultFragment();
        this.resultFragment = fragment;
        if (isTablet()){
            changeFragmentWithArgument(R.id.result_fragment, fragment, key, result);
        }else {
            changeReturnableFragmentWithArgument(R.id.generator_fragment, fragment, key, result);
        }
    }

    public void putSavedResultFragment(Fragment resultFragment) {
        if (isTablet()){
            changeFragment(R.id.result_fragment, resultFragment);
        } else {
            changeReturnableFragment(R.id.generator_fragment, resultFragment);
        }
    }

    private boolean isTablet() {
        return getResources().getBoolean(R.bool.isTablet);
    }

    private void changeFragment(int frame, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frame, fragment);
        Log.i("DECO", "commit do " + fragment);
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
        Log.i("DECO", "commit do " + fragment);
        transaction.commit();
    }

    private void changeReturnableFragmentWithArgument(int frame, Fragment fragment, String key, Serializable argument){
        Bundle bundle = new Bundle();
        bundle.putSerializable(key, argument);
        fragment.setArguments(bundle);
        changeReturnableFragment(frame, fragment);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(valuesFragment!=null) {
            fragmentManager.putFragment(outState, "values", valuesFragment);
        }
        if(resultFragment!=null) {
            fragmentManager.putFragment(outState, "result", resultFragment);
        }
    }
}
