package com.decoverri.treasuregenerator.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.dao.TreasureTypeDao;
import com.decoverri.treasuregenerator.model.TreasureType;

import java.util.List;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureTypeAdapter extends BaseAdapter {
    private Activity activity;
    private List<TreasureType> types;

    public TreasureTypeAdapter(Activity activity) {
        this.activity = activity;
        this.types = createTreasureIcons();
    }

    private List<TreasureType> createTreasureIcons() {
        return new TreasureTypeDao(activity).list();
    }

    @Override
    public int getCount() {
        return types.size();
    }

    @Override
    public Object getItem(int position) {
        return types.get(position);
    }

    @Override
    public long getItemId(int position) {
        return types.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.treasure_icon, parent, false);
        TreasureType icon = types.get(position);
        ImageView image = (ImageView) view.findViewById(R.id.tresure_image);
        image.setImageDrawable(activity.getResources().getDrawable(icon.getDrawable()));
        return view;
    }
}
