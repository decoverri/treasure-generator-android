package com.decoverri.treasuregenerator.task;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.decoverri.treasuregenerator.activity.GeneratorActivity;
import com.decoverri.treasuregenerator.fragment.ResultFragment;
import com.decoverri.treasuregenerator.model.Treasure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by decoverri on 29/02/16.
 */
public class GenerateTask extends AsyncTask<Object, Object, List<Treasure>> {

    private GeneratorActivity activity;
    private ProgressDialog progress;

    public GenerateTask(GeneratorActivity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(activity, "Loot!", "wait patiently");
    }

    @Override
    protected List<Treasure> doInBackground(Object[] params) {
        List<Treasure> treasures = new ArrayList<>();

        Treasure treasure1 = new Treasure();
        treasure1.setName("tesouro1");
        treasure1.setValue(1000.0);
        treasures.add(treasure1);

        Treasure treasure2 = new Treasure();
        treasure2.setName("tesouro2");
        treasure2.setValue(1500.0);
        treasures.add(treasure2);

        Treasure treasure3 = new Treasure();
        treasure3.setName("tesouro3");
        treasure3.setValue(200.0);
        treasures.add(treasure3);

        return treasures;
    }

    @Override
    protected void onPostExecute(List<Treasure> treasures) {
        progress.dismiss();
        activity.changeReturnableFragmentWithArgument(new ResultFragment(), "result", (Serializable) treasures);
    }
}
