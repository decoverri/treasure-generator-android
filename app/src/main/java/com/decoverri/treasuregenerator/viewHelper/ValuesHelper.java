package com.decoverri.treasuregenerator.viewHelper;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.model.TreasureType;
import com.decoverri.treasuregenerator.model.Value;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by decoverri on 02/03/16.
 */
public class ValuesHelper {

    private LinearLayout header;
    private Activity activity;
    private TextView nameView;
    private TextView letterView;
    private ListView valuesView;

    public ValuesHelper(View view, Activity activity) {
        this.activity = activity;
        header = (LinearLayout) view.findViewById(R.id.type_header);
        nameView = (TextView) view.findViewById(R.id.type_name);
        letterView = (TextView) view.findViewById(R.id.type_letter);
        valuesView = (ListView) view.findViewById(R.id.values);
    }

    public void fillViews(TreasureType type) {
        header.setBackgroundColor(activity.getResources().getColor(activity.getResources()
                .getIdentifier("type" + type.getLetter(), "color", activity.getPackageName())));

        nameView.setText(type.getName());
        letterView.setText("(Type " + type.getLetter() + ")");
        valuesView.setAdapter(new ArrayAdapter<>(activity, R.layout.value_item, type.getValues()));
    }

    public ListView getValuesView() {
        return valuesView;
    }
}
