package com.decoverri.treasuregenerator.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.model.TreasureIcon;

import java.util.List;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureAdapter extends BaseAdapter {
    private Activity activity;
    private List<TreasureIcon> treasureIcons;

    public TreasureAdapter(Activity activity, List<TreasureIcon> treasureIcons) {
        this.activity = activity;
        this.treasureIcons = treasureIcons;
    }

    @Override
    public int getCount() {
        return treasureIcons.size();
    }

    @Override
    public Object getItem(int position) {
        return treasureIcons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return treasureIcons.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = activity.getLayoutInflater().inflate(R.layout.treasure_icon, parent, false);
        return view;
    }
}
