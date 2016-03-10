package com.decoverri.treasuregenerator.helper;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by decoverri on 10/03/16.
 */
public class ResourceHelper {
    private Activity activity;

    public ResourceHelper(Activity activity) {
        this.activity = activity;
    }

    public int getTreasureColor(Character typeLetter) {
        return ContextCompat.getColor(activity, activity.getResources()
                .getIdentifier("type" + typeLetter, "color", activity.getPackageName()));
    }

    public Drawable getTreasureIcon(Character typeLetter) {
        return ContextCompat.getDrawable(activity, activity.getResources()
                .getIdentifier("type_" + Character.toLowerCase(typeLetter), "drawable", activity.getPackageName()));
    }
}
