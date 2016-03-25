package com.decoverri.treasuregenerator.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.activity.GeneratorActivity;
import com.decoverri.treasuregenerator.adapter.TreasureTypeAdapter;
import com.decoverri.treasuregenerator.model.TreasureType;
import com.decoverri.treasuregenerator.util.TreasureTypeFactory;

import java.util.ArrayList;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureTypesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.treasure_types, container, false);

        GridView treasuresView = (GridView) view.findViewById(R.id.treasure_types);

        ArrayList<TreasureType> treasureTypes = new TreasureTypeFactory(getActivity()).createFromJson(R.raw.treasure_types);

        treasuresView.setAdapter(new TreasureTypeAdapter(getActivity(), treasureTypes));

        treasuresView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GeneratorActivity activity = (GeneratorActivity) getActivity();
                TreasureType selectedType = (TreasureType) parent.getItemAtPosition(position);
                activity.putValuesFragment("selectedType", selectedType);
            }
        });

        return view;
    }

}
