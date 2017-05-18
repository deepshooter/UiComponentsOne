package com.deepshooter.uicomponentsone.twowaygriddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.deepshooter.uicomponentsone.R;
import com.deepshooter.uicomponentsone.TwowayGrid.TwoWayAbsListView;

import java.util.ArrayList;
import java.util.List;

public class TwoWayGridActivity extends AppCompatActivity {


    TwoWayAbsListView  twoWayListView ;
    TwoWayTextListAdapter twoWayTextListAdapter ;

    List<String> charList = new ArrayList<String>();

    TextView mTextView;
    LinearLayout linearLayout;
    int selectPosition = 0 ;

    String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_way_grid);

        mTitle = getIntent().getStringExtra("twowaygrid");
        initializeView();
        toolbarSetup();
    }


    private void initializeView()
    {

        twoWayListView = (TwoWayAbsListView) findViewById(R.id.two_way_list);

        twoWayTextListAdapter = new TwoWayTextListAdapter();
        twoWayListView.setAdapter(twoWayTextListAdapter);

        setValues();
    }


    private void setValues()
    {
        setData();

    }


    private void setData()
    {
        charList.add("A");
        charList.add("B");
        charList.add("C");
        charList.add("D");
        charList.add("E");
        charList.add("F");
        charList.add("G");
        charList.add("H");
        charList.add("I");
        charList.add("J");
        charList.add("K");
        charList.add("L");
        charList.add("M");
        charList.add("N");
        charList.add("O");
        charList.add("P");
        charList.add("Q");
        charList.add("R");
        charList.add("S");
        charList.add("T");
        charList.add("U");
        charList.add("V");
        charList.add("W");
        charList.add("X");
        charList.add("Y");
        charList.add("Z");


    }


    private class TwoWayTextListAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return charList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int position, View view, ViewGroup viewGroup) {

            if (view == null) {

                view = getLayoutInflater().inflate(R.layout.adapter_text_list, viewGroup, false);

            }

            mTextView = (TextView) view.findViewById(R.id.text);
            linearLayout = (LinearLayout) view.findViewById(R.id.textlayout);


            for (int i = position; i <= charList.size(); i++) {

                mTextView.setText(charList.get(position));

            }

            if (selectPosition == position) {

                mTextView.setTextColor(getResources().getColor(R.color.white));
                linearLayout.setBackgroundResource(R.drawable.orange_circle_background);

            } else {

                mTextView.setTextColor(getResources().getColor(R.color.grey));
                linearLayout.setBackgroundResource(R.drawable.greycircle);

            }



            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (selectPosition == position) {

                        selectPosition = position;
                        mTextView.setTextColor(getResources().getColor(R.color.white));
                        linearLayout.setBackgroundResource(R.drawable.orange_circle_background);
                        twoWayTextListAdapter.notifyDataSetChanged();

                    } else {

                        selectPosition = position;
                        mTextView.setTextColor(getResources().getColor(R.color.grey));
                        linearLayout.setBackgroundResource(R.drawable.greycircle);
                        twoWayTextListAdapter.notifyDataSetChanged();

                    }
                }
            });


            return view;

        }
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
