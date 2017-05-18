package com.deepshooter.uicomponentsone.progressdialog;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepshooter.uicomponentsone.R;


public class DialogTestActivity extends AppCompatActivity {


    ProgressDialog pdLoading;
    String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_test);


        mTitle = getIntent().getStringExtra("customprogressdialog");

        toolbarSetup();

        pdLoading = CustomProgressDialog.ctor(DialogTestActivity.this);
        pdLoading.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        pdLoading.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        pdLoading.show();
        pdLoading.setCancelable(false);
        pdLoading.setCanceledOnTouchOutside(false);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

               pdLoading.cancel();
            }
        }, 10000);


    }



    private void toolbarSetup()
    {
        TextView mToolbarTitle = (TextView) findViewById(R.id.vT_title_toolbar);
        ImageView mBackIcon = (ImageView) findViewById(R.id.vI_back_toolbar);
        ImageView mNotificationIcon = (ImageView) findViewById(R.id.vI_notification);


        mToolbarTitle.setText(mTitle);
        mNotificationIcon.setBackground(getResources().getDrawable(R.drawable.notification_bell));

        mBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
