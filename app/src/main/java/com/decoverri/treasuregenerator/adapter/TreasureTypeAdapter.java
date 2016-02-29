package com.decoverri.treasuregenerator.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.model.TreasureType;

import java.util.List;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureTypeAdapter extends BaseAdapter {
    private Activity activity;
    private List<TreasureType> treasureTypes;

    public TreasureTypeAdapter(Activity activity, List<TreasureType> treasureTypes) {
        this.activity = activity;
        this.treasureTypes = treasureTypes;
    }

    @Override
    public int getCount() {
        return treasureTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return treasureTypes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.treasure_icon, parent, false);

        TreasureType type = treasureTypes.get(position);

        ImageView image = (ImageView) view.findViewById(R.id.treasure_image);
        image.setImageDrawable(activity.getResources().getDrawable(type.getDrawable()));
        image.setTag(type.getName());

        return view;
    }
}
