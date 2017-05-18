package com.deepshooter.uicomponentsone.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.deepshooter.uicomponentsone.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avinashmishra on 02-05-2017.
 */

public class RecyclerViewGridHeaderAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_ITEM = 1;

    private final View header;
    private final List<String> labels;
    Context context;

    public RecyclerViewGridHeaderAdapter(View header, int count , Context context) {

        if (header == null) {
            throw new IllegalArgumentException("header may not be null");
        }

        this.header = header;
        this.labels = new ArrayList<String>(count);
        this.context = context;

        for (int i = 0; i < count; ++i) {
            labels.add(String.valueOf(i));
        }

    }

    public boolean isHeader(int position) {
        return position == 0;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_VIEW_TYPE_HEADER) {
            return new MyViewHolder(header);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_grid_with_header, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        if (isHeader(position)) {
            return;
        }

        final String label = labels.get(position - 1);  // Subtract 1 for header
        holder.vT_ads_schemeName.setText(label);

    }


    @Override
    public int getItemViewType(int position) {
        return isHeader(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
    }



    @Override
    public int getItemCount() {
        return labels.size() + 1;
    }
}
