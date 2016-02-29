package com.decoverri.treasuregenerator.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.fragment.TreasureTypesFragment;
import com.decoverri.treasuregenerator.model.TreasureType;
import com.decoverri.treasuregenerator.util.TreasureTypeFactory;

import java.io.Serializable;
import java.util.List;

public class GeneratorActivity extends AppCompatActivity {

    private List<TreasureType> treasureTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        treasureTypes = new TreasureTypeFactory(this).createFromJson(R.raw.treasure_types);

        changeReturnableFragmentWithArgument(new TreasureTypesFragment(), "treasureType", (Serializable) treasureTypes);

        getResources().getIdentifier("coins", "drawable", getPackageName());
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
}
