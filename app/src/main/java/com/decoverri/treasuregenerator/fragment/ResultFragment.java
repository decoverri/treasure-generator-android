package com.decoverri.treasuregenerator.fragment;

import android.graphics.Color;
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
import com.decoverri.treasuregenerator.model.Treasure;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by decoverri on 29/02/16.
 */
public class ResultFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.result_table);

        List<Treasure> treasures = (List<Treasure>) getArguments().getSerializable("result");

        for (Treasure treasure : treasures) {
            TableRow row = (TableRow) inflater.inflate(R.layout.result_row, container, false);

            TextView name = (TextView) row.findViewById(R.id.result_name);
            name.setText(treasure.getName());

            TextView value = (TextView) row.findViewById(R.id.result_value);
            value.setText(treasure.getFormattedValue());

            table.addView(row);
        }

        TableRow row = (TableRow) inflater.inflate(R.layout.result_row, container, false);
        row.setBackgroundColor(getResources().getColor(R.color.result_footer));

        TextView name = (TextView) row.findViewById(R.id.result_name);
        name.setText("Total:");

        TextView value = (TextView) row.findViewById(R.id.result_value);
        value.setText(getFormattedTotal(treasures));

        table.addView(row);

        return view;
    }

    private String getFormattedTotal(List<Treasure> treasures) {
        double total = 0;
        for (Treasure treasure : treasures) {
            total += treasure.getValue();
        }
        return NumberFormat.getInstance().format(total) + " gp";
    }
}
