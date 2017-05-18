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

public class RecyclerViewListHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Data> dataList;

    public RecyclerViewListHeaderAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }



    @Override
    public int getItemViewType(int position) {
        return (position==0)?0:1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == 0)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_adapter_header, parent, false);
            return new MyViewHolderHeader(itemView);

        }else {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_list, parent, false);
            return new MyViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(position == 0) {

            MyViewHolderHeader myViewHolderHeader = (MyViewHolderHeader) holder;
            myViewHolderHeader.mMainTitle.setText(("Main Title"));
            myViewHolderHeader.mTitle.setText(("Title"));

        }
        else {
            MyViewHolder myViewHolder = (MyViewHolder) holder;

            myViewHolder.mNumberText.setText(dataList.get(position).getmNumber());
            myViewHolder.mText.setText(dataList.get(position).getmText());
        }
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


    public class MyViewHolderHeader extends RecyclerView.ViewHolder {

        TextView mMainTitle,mTitle;

        public MyViewHolderHeader(View itemView) {
            super(itemView);

            mMainTitle = (TextView) itemView.findViewById(R.id.vT_adsh_headerMainTitle);
            mTitle = (TextView) itemView.findViewById(R.id.vT_adsh_headerSchemeTitle);

        }
    }


}
