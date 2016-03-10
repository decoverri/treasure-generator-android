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

        changeFragment(new TreasureTypesFragment());

        Log.i("DECO STATEFUL", "activity onCreate");

        if(savedInstanceState != null){
            valuesFragment = getSupportFragmentManager().getFragment(savedInstanceState, "values");
            if(valuesFragment != null){
                changeReturnableFragment(valuesFragment);
            }

            resultFragment = getSupportFragmentManager().getFragment(savedInstanceState, "result");
            if(resultFragment != null){
                changeReturnableFragment(resultFragment);
            }
        }

    }

    public void changeFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.generator_fragment, fragment);
        transaction.commit();
    }

    public void changeReturnableFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.generator_fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void changeReturnableFragmentWithArgument(Fragment fragment, String key, Serializable argument){
        Bundle bundle = new Bundle();
        bundle.putSerializable(key, argument);
        fragment.setArguments(bundle);
        changeReturnableFragment(fragment);
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

    public void setValuesFragment(Fragment valuesFragment) {
        this.valuesFragment = valuesFragment;
    }

    public void setResultFragment(ResultFragment resultFragment) {
        this.resultFragment = resultFragment;
    }

}
