package com.decoverri.treasuregenerator.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.decoverri.treasuregenerator.R;
import com.decoverri.treasuregenerator.activity.GeneratorActivity;
import com.decoverri.treasuregenerator.helper.view.ResultHelper;
import com.decoverri.treasuregenerator.model.dto.GenerationResult;

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

        result = (GenerationResult) getArguments().getSerializable("result");

        helper.fillData(inflater, container, result);

        setHasOptionsMenu(true);

        return view;
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
                intent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(shareableResult));
                startActivity(Intent.createChooser(intent, "Choose your destiny:"));
                return true;
            }
        });
    }
}
