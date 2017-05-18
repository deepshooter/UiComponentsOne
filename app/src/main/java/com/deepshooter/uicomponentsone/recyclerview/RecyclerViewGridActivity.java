package com.deepshooter.uicomponentsone.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.deepshooter.uicomponentsone.R;
import com.deepshooter.uicomponentsone.bean.Data;

import java.util.ArrayList;

public class RecyclerViewGridActivity extends AppCompatActivity {

    RecyclerView mGridRecyclerView;
    ArrayList<Data> dataArrayList;
    RecyclerViewGridAdapter recyclerViewGridAdapter;
    String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_grid);

        initializeView();
        toolbarSetup();
    }


    private void initializeView()
    {
        mTitle = getIntent().getStringExtra("recyclergrid");

        mGridRecyclerView = (RecyclerView) findViewById(R.id.vR_recyclerViewGrid);

        setValues();
    }


    private void setValues()
    {
          prepareData();

         //mGridRecyclerView.addItemDecoration(SpacesItemDecoration.newInstance(5, 4, 3));
        //mGridRecyclerView.setHasFixedSize(true);

        final GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 3);
        mGridRecyclerView.setLayoutManager(manager);
        recyclerViewGridAdapter = new RecyclerViewGridAdapter(RecyclerViewGridActivity.this,dataArrayList);
        mGridRecyclerView.setAdapter(recyclerViewGridAdapter);
    }



    private void prepareData()
    {
        dataArrayList = new ArrayList<>();

        Data data1 = new Data();
        data1.setmNumber("1");
        data1.setmText("One");
        dataArrayList.add(data1);

        Data data2 = new Data();
        data2.setmNumber("2");
        data2.setmText("Two");
        dataArrayList.add(data2);

        Data data3 = new Data();
        data3.setmNumber("3");
        data3.setmText("Three");
        dataArrayList.add(data3);

        Data data4 = new Data();
        data4.setmNumber("4");
        data4.setmText("Four");
        dataArrayList.add(data4);

        Data data5 = new Data();
        data5.setmNumber("5");
        data5.setmText("Five");
        dataArrayList.add(data5);

        Data data6 = new Data();
        data6.setmNumber("6");
        data6.setmText("Six");
        dataArrayList.add(data6);

        Data data7 = new Data();
        data7.setmNumber("7");
        data7.setmText("Seven");
        dataArrayList.add(data7);

        Data data8 = new Data();
        data8.setmNumber("8");
        data8.setmText("Eight");
        dataArrayList.add(data8);

        Data data9 = new Data();
        data9.setmNumber("9");
        data9.setmText("Nine");
        dataArrayList.add(data9);

        Data data10 = new Data();
        data10.setmNumber("10");
        data10.setmText("Ten");
        dataArrayList.add(data10);

        Data data11 = new Data();
        data11.setmNumber("11");
        data11.setmText("Eleven");
        dataArrayList.add(data11);

        Data data12 = new Data();
        data12.setmNumber("12");
        data12.setmText("Twelve");
        dataArrayList.add(data12);

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
