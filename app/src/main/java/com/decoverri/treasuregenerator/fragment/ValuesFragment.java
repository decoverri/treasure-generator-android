package com.decoverri.treasuregenerator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.activity.GeneratorActivity;
import com.decoverri.treasuregenerator.model.TreasureType;
import com.decoverri.treasuregenerator.model.TypeValueDTO;
import com.decoverri.treasuregenerator.task.GenerateTask;
import com.decoverri.treasuregenerator.viewHelper.ValuesHelper;

/**
 * Created by decoverri on 12/02/16.
 */
public class ValuesFragment extends Fragment {

    private ValuesHelper helper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.values, container, false);
        helper = new ValuesHelper(view, getActivity());

        final TreasureType type = (TreasureType) getArguments().getSerializable("selectedType");

        helper.fillViews(type);

        helper.getValuesView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GeneratorActivity activity = (GeneratorActivity) getActivity();

                TypeValueDTO typeValue = new TypeValueDTO((Double) parent.getItemAtPosition(position), type.getLetter());

                new GenerateTask(activity).execute(typeValue);
            }
        });

        return view;
    }

}
