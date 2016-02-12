package com.decoverri.treasuregenerator.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.adapter.TreasureTypeAdapter;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureTypesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.treasures, container, false);
        GridView treasuresView = (GridView) view.findViewById(R.id.treasures_list);
        treasuresView.setAdapter(new TreasureTypeAdapter(getActivity()));
        return view;
    }
}