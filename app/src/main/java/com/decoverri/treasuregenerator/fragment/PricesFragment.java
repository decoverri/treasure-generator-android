package com.decoverri.treasuregenerator.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.dao.PricesDao;

import java.util.List;

/**
 * Created by decoverri on 12/02/16.
 */
public class PricesFragment extends Fragment {

    private List<Double> prices;

    public PricesFragment(long id) {
        prices = new PricesDao(getActivity()).getPrices(id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.prices, container, false);
        ListView listView = (ListView) view.findViewById(R.id.prices);
        listView.setAdapter(new ArrayAdapter<Double>(getActivity(), android.R.layout.simple_list_item_1, prices));
        return view;
    }
}
