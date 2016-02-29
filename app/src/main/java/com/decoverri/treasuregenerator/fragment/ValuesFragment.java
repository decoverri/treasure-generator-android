package com.decoverri.treasuregenerator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.decoverri.treasuregenerator.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by decoverri on 12/02/16.
 */
public class ValuesFragment extends Fragment {

    private List<Double> values;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        values = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        View view = inflater.inflate(R.layout.values, container, false);
        ListView listView = (ListView) view.findViewById(R.id.values);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, values));
        return view;
    }
}
