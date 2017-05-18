package com.deepshooter.uicomponentsone.listview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.deepshooter.uicomponentsone.R;
import com.deepshooter.uicomponentsone.bean.Data;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {


    ListView vL_listView ;
    ArrayList<Data> dataArrayList;
    ListViewAdapter listViewAdapter;

    String mTitle;

    int selPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        initializeView();
        toolbarSetup();
    }


    public void initializeView()
    {

        mTitle = getIntent().getStringExtra("listview");
        vL_listView = (ListView) findViewById(R.id.vL_listView);

        setValues();
    }

    private void setValues()
    {

        prepareData();

        listViewAdapter = new ListViewAdapter();
        vL_listView.setAdapter(listViewAdapter);
        listViewAdapter.notifyDataSetChanged();


    }



    private class ListViewAdapter extends BaseAdapter {


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
        public View getView(final int position, View convertView, ViewGroup parent) {

            final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.adapter_listview, parent, false);

            final TextView mNumberText = (TextView) view.findViewById(R.id.vT_number);
            final TextView mText = (TextView) view.findViewById(R.id.vT_text);


            mNumberText.setText(dataArrayList.get(position).getmNumber());
            mText.setText(dataArrayList.get(position).getmText());


            if (selPos == position) {

                mNumberText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.orange));
                mText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.orange));

            } else {

                mNumberText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.teal));
                mText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.teal));


            }



            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (selPos == position) {

                        selPos = position;

                        mNumberText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.orange));
                        mText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.orange));

                        listViewAdapter.notifyDataSetChanged();


                    } else {

                        selPos = position;

                        mNumberText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.teal));
                        mText.setTextColor(ContextCompat.getColor(ListViewActivity.this,R.color.teal));


                        listViewAdapter.notifyDataSetChanged();

                    }


                    Toast.makeText(ListViewActivity.this, dataArrayList.get(position).getmText(), Toast.LENGTH_SHORT).show();
                }
            });



            return view;
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
