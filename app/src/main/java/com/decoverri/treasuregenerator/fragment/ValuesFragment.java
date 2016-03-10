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
import com.decoverri.treasuregenerator.helper.view.ValuesHelper;
import com.decoverri.treasuregenerator.model.TreasureType;
import com.decoverri.treasuregenerator.model.Value;
import com.decoverri.treasuregenerator.model.dto.TypeValue;
import com.decoverri.treasuregenerator.task.GenerateTask;

/**
 * Created by decoverri on 12/02/16.
 */
public class ValuesFragment extends Fragment {

    private GeneratorActivity activity;

    private ValuesHelper helper;

    private TreasureType selectedType;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.values, container, false);
        activity = (GeneratorActivity) getActivity();

        helper = new ValuesHelper(view, activity);

        setSelectedType(savedInstanceState);

        helper.fillViews(this.selectedType);

        helper.getValuesView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TypeValue typeValue = new TypeValue(((Value) parent.getItemAtPosition(position)).getValue(), ValuesFragment.this.selectedType.getLetter());
                new GenerateTask(activity).execute(typeValue);
            }
        });

        return view;
    }

    private void setSelectedType(@Nullable Bundle savedInstanceState) {
        selectedType = (TreasureType) getArguments().getSerializable("selectedType");
        if (savedInstanceState != null) {
            TreasureType savedType = (TreasureType) savedInstanceState.getSerializable("selectedType");
            if (savedType != null) {
                selectedType = savedType;
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("selectedType", selectedType);
    }

}
