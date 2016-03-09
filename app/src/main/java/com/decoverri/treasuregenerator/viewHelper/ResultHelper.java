package com.decoverri.treasuregenerator.viewHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.fragment.ResultFragment;
import com.decoverri.treasuregenerator.model.Treasure;

import java.text.NumberFormat;
import java.util.List;

/**
 * Created by decoverri on 08/03/16.
 */
public class ResultHelper {
    private ResultFragment fragment;

    private TableLayout table;

    private List<Treasure> treasures;

    public ResultHelper(View view, ResultFragment fragment) {
        this.fragment = fragment;

        treasures = (List<Treasure>) fragment.getArguments().getSerializable("result");

        table = (TableLayout) view.findViewById(R.id.result_table);
    }

    public void fillResultTable(LayoutInflater inflater, ViewGroup container) {

        for (Treasure treasure : treasures) {
            TableRow row = (TableRow) inflater.inflate(R.layout.result_row, container, false);

            TextView name = (TextView) row.findViewById(R.id.result_name);
            name.setText(treasure.getName());

            TextView value = (TextView) row.findViewById(R.id.result_value);
            value.setText(treasure.getFormattedValue());

            table.addView(row);
        }

        TableRow row = (TableRow) inflater.inflate(R.layout.result_row, container, false);
        row.setBackgroundColor(fragment.getResources().getColor(R.color.result_footer));

        TextView name = (TextView) row.findViewById(R.id.result_name);
        name.setText("Total:");

        TextView value = (TextView) row.findViewById(R.id.result_value);
        value.setText(getFormattedTotal(treasures));

        table.addView(row);

    }

    private String getFormattedTotal(List<Treasure> treasures) {
        double total = 0;
        for (Treasure treasure : treasures) {
            total += treasure.getValue();
        }
        return NumberFormat.getInstance().format(total) + " gp";
    }

    public String getShareableResult() {
        StringBuilder builder = new StringBuilder();
        builder.append("Treasure Generator Result:\n\n");
        for (Treasure treasure : treasures) {
            builder.append(treasure.getName() + " - " + treasure.getFormattedValue() + ";\n");
        }
        builder.append("\nTotal: " + getFormattedTotal(treasures));
        return builder.toString();
    }
}
