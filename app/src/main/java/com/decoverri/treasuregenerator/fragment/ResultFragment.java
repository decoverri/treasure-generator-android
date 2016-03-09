package com.decoverri.treasuregenerator.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.model.GenerationResult;
import com.decoverri.treasuregenerator.viewHelper.ResultHelper;

/**
 * Created by decoverri on 29/02/16.
 */
public class ResultFragment extends Fragment {

    private ResultHelper helper;

    private GenerationResult result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result, container, false);

        helper = new ResultHelper(view, this);

        setResult(savedInstanceState);

        helper.fillData(inflater, container, result);

        setHasOptionsMenu(true);

        return view;
    }

    private void setResult(@Nullable Bundle savedInstanceState) {
        result = (GenerationResult) getArguments().getSerializable("result");
        if(savedInstanceState != null){
            GenerationResult savedResult = (GenerationResult) savedInstanceState.getSerializable("result");
            if(savedResult != null){
                result = savedResult;
            }
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem shareMenu = menu.add("Share");
        shareMenu.setIcon(android.R.drawable.ic_menu_share);
        shareMenu.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        final String shareableResult = helper.getShareableResult();

        shareMenu.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, shareableResult);
                startActivity(Intent.createChooser(intent, "Choose your destiny:"));
                return true;
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("result", result);
    }
}
