package com.deepshooter.uicomponentsone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.deepshooter.uicomponentsone.customs.SimpleDividerItemDecoration;
import com.deepshooter.uicomponentsone.expandablelistview.ExpandableListViewActivity;
import com.deepshooter.uicomponentsone.gridview.GridViewActivity;
import com.deepshooter.uicomponentsone.listview.ListViewActivity;
import com.deepshooter.uicomponentsone.progressdialog.DialogTestActivity;
import com.deepshooter.uicomponentsone.recyclerview.HorizontalRecyclerViewActivity;
import com.deepshooter.uicomponentsone.recyclerview.RecyclerViewGridActivity;
import com.deepshooter.uicomponentsone.recyclerview.RecyclerViewGridWithHeaderActivity;
import com.deepshooter.uicomponentsone.recyclerview.RecyclerViewListActivity;
import com.deepshooter.uicomponentsone.recyclerview.RecyclerViewListWithHeaderActivity;
import com.deepshooter.uicomponentsone.twowaygriddemo.TwoWayGridActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    ArrayList<String> arrayList;
    RecyclerViewAdapter recyclerViewAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
        toolbarSetup();

    }


    private void initializeView()
    {
        mRecyclerView = (RecyclerView) findViewById(R.id.vR_recyclerView);

        setValues();
    }


    private void setValues() {

        prepareData();

        recyclerViewAdapter = new RecyclerViewAdapter(arrayList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setHasFixedSize(false);

        mRecyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

    }


    private void prepareData()
    {
        arrayList = new ArrayList<>();
        arrayList.add("ListView");
        arrayList.add("GridView");
        arrayList.add("TwoWayGridView");
        arrayList.add("ExpandableListView");
        arrayList.add("RecyclerView List");
        arrayList.add("RecyclerView Grid");
        arrayList.add("RecyclerView List With Header");
        arrayList.add("RecyclerView Grid With Header");
        arrayList.add("Horizontal RecyclerView");
        arrayList.add("Custom Progress Dialog");

    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
    {

        List<String> dataList;

        public RecyclerViewAdapter(List<String> dataList) {
            this.dataList = dataList;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_view, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {

            holder.mTextViewTitle.setText(dataList.get(position));

            holder.mTextViewTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(dataList.get(position).equalsIgnoreCase("ListView"))
                    {
                        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                        intent.putExtra("listview",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("GridView"))
                    {
                        Intent intent = new Intent(MainActivity.this, GridViewActivity.class);
                        intent.putExtra("gridview",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("TwoWayGridView"))
                    {

                        Intent intent = new Intent(MainActivity.this, TwoWayGridActivity.class);
                        intent.putExtra("twowaygrid",arrayList.get(position));
                        startActivity(intent);

                    }
                    else  if(dataList.get(position).equalsIgnoreCase("ExpandableListView"))
                    {

                        Intent intent = new Intent(MainActivity.this, ExpandableListViewActivity.class);
                        intent.putExtra("expandablelist",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("RecyclerView List"))
                    {

                        Intent intent = new Intent(MainActivity.this, RecyclerViewListActivity.class);
                        intent.putExtra("recyclerlist",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("RecyclerView Grid"))
                    {

                        Intent intent = new Intent(MainActivity.this, RecyclerViewGridActivity.class);
                        intent.putExtra("recyclergrid",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("RecyclerView List With Header"))
                    {

                        Intent intent = new Intent(MainActivity.this, RecyclerViewListWithHeaderActivity.class);
                        intent.putExtra("recyclerlistH",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("RecyclerView Grid With Header"))
                    {

                        Intent intent = new Intent(MainActivity.this, RecyclerViewGridWithHeaderActivity.class);
                        intent.putExtra("recyclergridH",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("Horizontal RecyclerView"))
                    {

                        Intent intent = new Intent(MainActivity.this, HorizontalRecyclerViewActivity.class);
                        intent.putExtra("horizontalrecyclerview",arrayList.get(position));
                        startActivity(intent);
                    }
                    else  if(dataList.get(position).equalsIgnoreCase("Custom Progress Dialog"))
                    {

                        Intent intent = new Intent(MainActivity.this, DialogTestActivity.class);
                        intent.putExtra("customprogressdialog",arrayList.get(position));
                        startActivity(intent);
                    }

                }
            });


        }

        @Override
        public int getItemCount() {

            if (dataList == null || dataList.size() == 0)
                return 0;
            return dataList.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {

            TextView mTextViewTitle;

            public MyViewHolder(View itemView) {
                super(itemView);

                mTextViewTitle = (TextView) itemView.findViewById(R.id.textView);


            }
        }
    }

    private void toolbarSetup()
    {
        TextView mToolbarTitle = (TextView) findViewById(R.id.vT_title_toolbar);
        ImageView mBackIcon = (ImageView) findViewById(R.id.vI_back_toolbar);
        ImageView mNotificationIcon = (ImageView) findViewById(R.id.vI_notification);


        mToolbarTitle.setText("UI Component List");
        mNotificationIcon.setBackground(getResources().getDrawable(R.drawable.notification_bell));

        mBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}
