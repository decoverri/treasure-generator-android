package com.decoverri.treasuregenerator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
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

        selectedType = (TreasureType) getArguments().getSerializable("selectedType");

        helper.fillViews(this.selectedType);

        helper.getValuesView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (activity.isOnline()) {
                    TypeValue typeValue = new TypeValue(((Value) parent.getItemAtPosition(position)).getValue(), ValuesFragment.this.selectedType);
                    new GenerateTask(activity).execute(typeValue);
                } else {
                    new AlertDialog.Builder(activity)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("No Internet Connection")
                            .setMessage("Maybe you could try a Sending spell?")
                            .setPositiveButton("Dismiss",null).show();
                }
            }
        });

        return view;
    }
}
