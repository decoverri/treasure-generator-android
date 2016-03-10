package com.decoverri.treasuregenerator.helper.view;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.helper.ResourceHelper;
import com.decoverri.treasuregenerator.model.TreasureType;

/**
 * Created by decoverri on 02/03/16.
 */
public class ValuesHelper {

    private View header;
    private Activity activity;
    private TextView nameView;
    private TextView letterView;
    private ListView valuesView;

    public ValuesHelper(View view, Activity activity) {
        this.activity = activity;
        header = view.findViewById(R.id.type_header);
        nameView = (TextView) view.findViewById(R.id.type_name);
        letterView = (TextView) view.findViewById(R.id.type_letter);
        valuesView = (ListView) view.findViewById(R.id.values);
    }

    public void fillViews(TreasureType type) {
        header.setBackgroundColor(new ResourceHelper(activity).getTreasureColor(type.getLetter()));

        nameView.setText(type.getName());
        letterView.setText("(Type " + type.getLetter() + ")");
        valuesView.setAdapter(new ArrayAdapter<>(activity, R.layout.value_item, type.getValues()));
    }

    public ListView getValuesView() {
        return valuesView;
    }
}
