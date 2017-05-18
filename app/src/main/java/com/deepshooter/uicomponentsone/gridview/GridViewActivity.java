package com.deepshooter.uicomponentsone.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.deepshooter.uicomponentsone.R;
import com.deepshooter.uicomponentsone.bean.Data;
import com.deepshooter.uicomponentsone.listview.ListViewActivity;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {


    ArrayList<Data> dataArrayList;
    GridView vG_gridView ;
    GridViewAdapter gridViewAdapter;

    String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        initializeValue();
        toolbarSetup();

    }


    private void initializeValue()
    {
        mTitle = getIntent().getStringExtra("gridview");
        vG_gridView = (GridView) findViewById(R.id.vG_gridView);

        setValues();

    }



    private void setValues()
    {
        prepareData();

        gridViewAdapter = new GridViewAdapter();
        vG_gridView.setAdapter(gridViewAdapter);
        gridViewAdapter.notifyDataSetChanged();


    }


    private class GridViewAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return dataArrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup viewGroup) {

            final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (convertView == null) {

                convertView = inflater.inflate(R.layout.adapter_gridview, viewGroup, false);

            }

            final TextView mNumberText = (TextView) convertView.findViewById(R.id.vT_number);
            final TextView mText = (TextView) convertView.findViewById(R.id.vT_text);


            mNumberText.setText(dataArrayList.get(position).getmNumber());
            mText.setText(dataArrayList.get(position).getmText());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(GridViewActivity.this, dataArrayList.get(position).getmText(), Toast.LENGTH_SHORT).show();
                }
            });



            return convertView;


        }
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
