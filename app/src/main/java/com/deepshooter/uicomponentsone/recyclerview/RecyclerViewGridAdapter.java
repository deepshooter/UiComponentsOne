package com.deepshooter.uicomponentsone.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.deepshooter.uicomponentsone.R;
import com.deepshooter.uicomponentsone.bean.Data;

import java.util.List;

/**
 * Created by Avinashmishra on 02-05-2017.
 */

public class RecyclerViewGridAdapter extends RecyclerView.Adapter<RecyclerViewGridAdapter.MyViewHolder>  {

    Context context;
    List<Data> dataList;

    public RecyclerViewGridAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_grid, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.mNumberText.setText(dataList.get(position).getmNumber());
        holder.mText.setText(dataList.get(position).getmText());

    }


    @Override
    public int getItemCount() {
        if (dataList == null || dataList.size() == 0)
            return 0;
        return dataList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mNumberText,mText;

        public MyViewHolder(View itemView) {
            super(itemView);

            mNumberText = (TextView) itemView.findViewById(R.id.vT_number);
            mText = (TextView) itemView.findViewById(R.id.vT_Text);
        }

    }

}
