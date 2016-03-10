package com.decoverri.treasuregenerator.helper;

import android.app.Activity;
import android.graphics.drawable.Drawable;

/**
 * Created by decoverri on 10/03/16.
 */
public class ResourceHelper {
    private Activity activity;

    public ResourceHelper(Activity activity) {
        this.activity = activity;
    }

    public int getTreasureColor(Character typeLetter) {
        return activity.getResources().getColor(activity.getResources()
                .getIdentifier("type" + typeLetter, "color", activity.getPackageName()));
    }

    public Drawable getTreasureIcon(Character typeLetter) {
        return activity.getResources().getDrawable(activity.getResources()
                .getIdentifier("type_" + Character.toLowerCase(typeLetter), "drawable", activity.getPackageName()));
    }
}
