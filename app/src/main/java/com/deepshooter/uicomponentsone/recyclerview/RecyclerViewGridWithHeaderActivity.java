package com.deepshooter.uicomponentsone.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.deepshooter.uicomponentsone.R;
import com.deepshooter.uicomponentsone.bean.Data;
import com.deepshooter.uicomponentsone.customs.SpacesItemDecoration;

import java.util.ArrayList;

public class RecyclerViewGridWithHeaderActivity extends AppCompatActivity {


    TextView vT_adsh_headerSchemeTitle , vT_adsh_headerMainTitle;
    ImageView vI_adsh_headerSchemeImage;


    RecyclerView vR_recyclerViewGridH;
    ArrayList<Data> dataArrayList;
    String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_grid_with_header);

        initializeValue();
        toolbarSetup();

    }



    private void initializeValue()
    {
        mTitle = getIntent().getStringExtra("recyclergridH");
        vR_recyclerViewGridH = (RecyclerView) findViewById(R.id.vR_recyclerViewGridH);
        setValue();
    }


    private void setValue()
    {

        prepareData();

        vR_recyclerViewGridH.addItemDecoration(SpacesItemDecoration.newInstance(5, 4, 3));
        vR_recyclerViewGridH.setHasFixedSize(true);

        final GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 3);
        vR_recyclerViewGridH.setLayoutManager(manager);


        View header = LayoutInflater.from(getApplicationContext()).inflate(R.layout.grid_adapter_header, vR_recyclerViewGridH, false);

        vT_adsh_headerSchemeTitle = (TextView) header.findViewById(R.id.vT_adsh_headerSchemeTitle);
        vT_adsh_headerMainTitle = (TextView) header.findViewById(R.id.vT_adsh_headerMainTitle);
        vI_adsh_headerSchemeImage = (ImageView) header.findViewById(R.id.vI_adsh_headerSchemeImage);

        final RecyclerViewGridHeaderAdapter recyclerViewGridHeaderAdapter = new RecyclerViewGridHeaderAdapter(header,12,RecyclerViewGridWithHeaderActivity.this);
        vR_recyclerViewGridH.setAdapter(recyclerViewGridHeaderAdapter);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return recyclerViewGridHeaderAdapter.isHeader(position) ? manager.getSpanCount() : 1;
            }
        });

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
