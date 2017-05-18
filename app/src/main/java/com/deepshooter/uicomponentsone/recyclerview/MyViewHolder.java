package com.deepshooter.uicomponentsone.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.deepshooter.uicomponentsone.R;


public class MyViewHolder extends RecyclerView.ViewHolder {

  public TextView vT_ads_schemeName;
  ImageView vI_ads_schemeImage;
  LinearLayout vL_ads_layout;

  public MyViewHolder(View itemView) {
    super(itemView);
    vT_ads_schemeName = (TextView) itemView.findViewById(R.id.vT_ads_schemeName);
    vI_ads_schemeImage = (ImageView) itemView.findViewById(R.id.vI_ads_schemeImage);
    vL_ads_layout = (LinearLayout) itemView.findViewById(R.id.vL_ads_layout);
  }

}