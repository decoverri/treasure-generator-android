package com.decoverri.treasuregenerator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.activity.GeneratorActivity;
import com.decoverri.treasuregenerator.model.TreasureType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by decoverri on 12/02/16.
 */
public class ValuesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        TreasureType type = (TreasureType) getArguments().getSerializable("selectedType");

        ArrayList<Double> values = type.getValues();

        View view = inflater.inflate(R.layout.values, container, false);

        ListView listView = (ListView) view.findViewById(R.id.values);

        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, values));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GeneratorActivity activity = (GeneratorActivity) getActivity();
                activity.changeReturnableFragment(new ResultFragment());
            }
        });

        return view;
    }

}
