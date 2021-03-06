package com.deepshooter.uicomponentsone.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.deepshooter.uicomponentsone.R;
import com.deepshooter.uicomponentsone.bean.Data;

import java.util.List;

/**
 * Created by Avinashmishra on 02-05-2017.
 */

public class RecyclerViewListAdapter extends RecyclerView.Adapter<RecyclerViewListAdapter.MyViewHolder> {

    Context context;
    List<Data> dataList;
    int selectPosition = -1 ;

    public RecyclerViewListAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recycler_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,  final int position) {

         holder.mNumberText.setText(dataList.get(position).getmNumber());
         holder.mText.setText(dataList.get(position).getmText());

        if (selectPosition == position) {

            holder.mNumberText.setTextColor(context.getResources().getColor(R.color.white));
            holder.mText.setTextColor(context.getResources().getColor(R.color.white));
            holder.mLinearLayout.setBackgroundResource(R.drawable.list_item_background_four);

        } else {

            holder.mNumberText.setTextColor(context.getResources().getColor(R.color.grey));
            holder.mText.setTextColor(context.getResources().getColor(R.color.grey));
            holder.mLinearLayout.setBackgroundResource(R.drawable.list_item_background_three);

        }

        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (selectPosition == position) {

                    selectPosition = position;
                    holder.mNumberText.setTextColor(context.getResources().getColor(R.color.white));
                    holder.mText.setTextColor(context.getResources().getColor(R.color.white));
                    holder.mLinearLayout.setBackgroundResource(R.drawable.list_item_background_four);
                    notifyDataSetChanged();

                } else {

                    selectPosition = position;
                    holder.mNumberText.setTextColor(context.getResources().getColor(R.color.grey));
                    holder.mText.setTextColor(context.getResources().getColor(R.color.grey));
                    holder.mLinearLayout.setBackgroundResource(R.drawable.list_item_background_three);
                    notifyDataSetChanged();

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

        TextView mNumberText,mText;
        LinearLayout mLinearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);

            mNumberText = (TextView) itemView.findViewById(R.id.vT_number);
            mText = (TextView) itemView.findViewById(R.id.vT_Text);
            mLinearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }


}
