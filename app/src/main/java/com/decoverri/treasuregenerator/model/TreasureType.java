package com.decoverri.treasuregenerator.model;

import com.decoverri.treasuregenerator.R;

/**
 * Created by decoverri on 04/02/16.
 */
public class TreasureType {
    private Long id;
    private Integer drawable;

    public TreasureType(int drawable) {
        this.drawable = drawable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDrawable() {
        return drawable;
    }
}
