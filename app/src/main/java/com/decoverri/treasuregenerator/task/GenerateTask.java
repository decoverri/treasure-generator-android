package com.decoverri.treasuregenerator.task;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import com.decoverri.treasuregenerator.activity.GeneratorActivity;
import com.decoverri.treasuregenerator.fragment.ResultFragment;
import com.decoverri.treasuregenerator.model.Treasure;
import com.decoverri.treasuregenerator.model.TypeValueDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by decoverri on 29/02/16.
 */
public class GenerateTask extends AsyncTask<TypeValueDTO, Object, List<Treasure>> {

    private GeneratorActivity activity;
    private ProgressDialog progress;

    public GenerateTask(GeneratorActivity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        progress = ProgressDialog.show(activity, null, "Looting...");
    }

    @Override
    protected List<Treasure> doInBackground(TypeValueDTO... params) {
        return new LootClient().post(params[0]);
    }

    @Override
    protected void onPostExecute(List<Treasure> treasures) {
        progress.dismiss();
        if(treasures != null){
            activity.changeReturnableFragmentWithArgument(new ResultFragment(), "result", (Serializable) treasures);
        }else {
            new AlertDialog.Builder(activity).setTitle("Dragon in the server!").setMessage("Please try again later.")
                    .setPositiveButton("Ok", null).show();
        }
    }
}
