package com.decoverri.treasuregenerator.task;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;

import com.decoverri.treasuregenerator.activity.GeneratorActivity;
import com.decoverri.treasuregenerator.fragment.ResultFragment;
import com.decoverri.treasuregenerator.model.GenerationResult;
import com.decoverri.treasuregenerator.model.Treasure;
import com.decoverri.treasuregenerator.model.TypeValueDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by decoverri on 29/02/16.
 */
public class GenerateTask extends AsyncTask<TypeValueDTO, Object, GenerationResult> {

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
    protected GenerationResult doInBackground(TypeValueDTO... params) {
        TypeValueDTO typeValue = params[0];
        List<Treasure> treasures = new LootClient().post(typeValue);
        return new GenerationResult(typeValue, treasures);
    }

    @Override
    protected void onPostExecute(GenerationResult result) {
        progress.dismiss();
        if(result.getTreasures() != null){
            ResultFragment resultFragment = new ResultFragment();
            activity.setResultFragment(resultFragment);
            activity.changeReturnableFragmentWithArgument(resultFragment, "result", result);
        }else {
            new AlertDialog.Builder(activity).setTitle("Dragon in the server!").setMessage("Please try again later.")
                    .setPositiveButton("Ok", null).show();
        }
    }
}
