package com.deepshooter.uicomponentsone.progressdialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

import com.deepshooter.uicomponentsone.R;


/**
 * Created by Avinashmishra on 04-05-2017.
 */

public class CustomProgressDialog extends ProgressDialog {

    WebView pDialgoue ;


    public static ProgressDialog ctor(Context context) {
        CustomProgressDialog dialog = new CustomProgressDialog(context);
        dialog.setIndeterminate(true);
        dialog.setCancelable(false);
        return dialog;
    }

    public CustomProgressDialog(Context context) {
        super(context);
    }

    public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.view_custom_progress_dialog);

        pDialgoue = (WebView) findViewById(R.id.pdialogue);
        // pDialgoue.setBackgroundColor(Color.TRANSPARENT);
        pDialgoue.getSettings().setUseWideViewPort(true);
        pDialgoue.getSettings().setLoadWithOverviewMode(true);
        pDialgoue.loadUrl("file:///android_asset/loading.gif");



    }
}
