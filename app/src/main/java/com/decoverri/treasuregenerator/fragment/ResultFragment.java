package com.decoverri.treasuregenerator.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.decoverri.treasuregenerator.R;

/**
 * Created by decoverri on 29/02/16.
 */
public class ResultFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TableLayout view = (TableLayout) inflater.inflate(R.layout.result, container, false);

        for (int i = 0; i < 5; i++){
            TableRow row = (TableRow) inflater.inflate(R.layout.result_row, container, false);

            TextView name = (TextView) row.findViewById(R.id.result_name);
            name.setText("tesouro 1");

            TextView value = (TextView) row.findViewById(R.id.result_value);
            value.setText("1000.0");

            view.addView(row);
        }

        return view;
    }
}
