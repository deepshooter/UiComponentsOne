package com.deepshooter.uicomponentsone.expandablelistview;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.deepshooter.uicomponentsone.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListViewActivity extends AppCompatActivity {


    ExpandableListView vL_expandableListView ;
    ExpandableListAdapter expandableListAdapter;

    List<String> listDataHeader;
    HashMap<String, List<Item>> listDataChild;


    //fonts
    public static Typeface lnvm;
    public static Typeface lnvmbd;

    ImageView arrowUp, arrowDown;
    String mTitle;

    private int lastExpandedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_listview);

        initializeView();
        toolbarSetup();
    }



    private void initializeView()
    {
        lnvm  = Typeface.createFromAsset(getAssets(), "lvnm.ttf");
        lnvmbd  = Typeface.createFromAsset(getAssets(), "lvnmbd.ttf");

        mTitle = getIntent().getStringExtra("expandablelist");

        vL_expandableListView = (ExpandableListView) findViewById(R.id.vL_expandableListView);

        setValues();
    }



    private void setValues() {

        prepareListData();

        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        vL_expandableListView.setAdapter(expandableListAdapter);


        vL_expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                arrowDown = (ImageView) v.findViewById(R.id.arrowDown);
                arrowUp = (ImageView) v.findViewById(R.id.arrowUp);


                Toast.makeText(ExpandableListViewActivity.this,listDataHeader.get(groupPosition)+"",Toast.LENGTH_SHORT).show();

                if (parent.isGroupExpanded(groupPosition)) {

                    arrowDown.setVisibility(View.VISIBLE);
                    arrowUp.setVisibility(View.GONE);

                }else {
                    arrowDown.setVisibility(View.GONE);
                    arrowUp.setVisibility(View.VISIBLE);
                }




                return false;
            }
        });


        vL_expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(ExpandableListViewActivity.this,listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition).getItem()+"",Toast.LENGTH_SHORT).show();
                return false;


            }
        });



        vL_expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {

                    vL_expandableListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;
            }
        });


    }




    private void prepareListData() {


        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Item>>();


        // Adding child data
        listDataHeader.add("Hair Spa");
        listDataHeader.add("Women's Beauty Package");
        listDataHeader.add("Waxing");
        listDataHeader.add("Mens Hair");
        listDataHeader.add("Make Up");
        listDataHeader.add("Body Massage");


        List<Item> hairspalist = new ArrayList<Item>();

        Item hairspa = new Item();
        hairspa.setItem("Loreal Nursing");
        hairspa.setPrice("700");
        hairspalist.add(hairspa);

        Item hairspa1 = new Item();
        hairspa1.setItem("Hair Spa");
        hairspa1.setPrice("1000");
        hairspalist.add(hairspa1);

        Item hairspa2= new Item();
        hairspa2.setItem("Mythic Spa");
        hairspa2.setPrice("1500");
        hairspalist.add(hairspa2);

        Item hairspa3= new Item();
        hairspa3.setItem("Rejuvena Treatment");
        hairspa3.setPrice("1700");
        hairspalist.add(hairspa3);

        List<Item> wbplist = new ArrayList<Item>();

        Item wbp1= new Item();
        wbp1.setItem("Loreal Nursing");
        wbp1.setPrice("700");
        wbplist.add(wbp1);

        Item wbp= new Item();
        wbp.setItem("Hair Spa");
        wbp.setPrice("1000");
        wbplist.add(wbp);


        List<Item> waxinglist = new ArrayList<Item>();

        Item wax= new Item();
        wax.setItem("Loreal Nursing");
        wax.setPrice("700");
        waxinglist.add(wax);

        Item wax1= new Item();
        wax1.setItem("Hair Spa");
        wax1.setPrice("1000");
        waxinglist.add(wax1);

        List<Item> menhairlist = new ArrayList<Item>();

        Item mh= new Item();
        mh.setItem("Loreal Nursing");
        mh.setPrice("700");
        menhairlist.add(mh);

        Item mh1= new Item();
        mh1.setItem("Hair Spa");
        mh1.setPrice("1000");

        menhairlist.add(mh1);

        List<Item> makeuplist = new ArrayList<Item>();

        Item mu = new Item();
        mu.setItem("Hair Spa");
        mu.setPrice("1000");
        makeuplist.add(mu);


        Item mu1 = new Item();
        mu1.setItem("Loreal Nursing");
        mu1.setPrice("700");
        makeuplist.add(mu1);


        List<Item> bodymasglist = new ArrayList<Item>();


        Item bm = new Item();
        bm.setItem("Hair Spa");
        bm.setPrice("1000");
        bodymasglist.add(bm);

        Item bm1 = new Item();
        bm1.setItem("Loreal Nursing");
        bm1.setPrice("700");
        bodymasglist.add(bm1);


        listDataChild.put(listDataHeader.get(0), hairspalist); // Header, Child data
        listDataChild.put(listDataHeader.get(1), wbplist);
        listDataChild.put(listDataHeader.get(2), waxinglist);
        listDataChild.put(listDataHeader.get(3), menhairlist);
        listDataChild.put(listDataHeader.get(4), makeuplist);
        listDataChild.put(listDataHeader.get(5), bodymasglist);



    }

    public class ExpandableListAdapter extends BaseExpandableListAdapter
    {

        private Context _context;

        private List<String> _listDataHeader; // header titles

        // child data in format of header title, child title
        private HashMap<String, List<Item>> _listDataChild;


        public ExpandableListAdapter(Context _context, List<String> _listDataHeader, HashMap<String, List<Item>> _listDataChild) {
            this._context = _context;
            this._listDataHeader = _listDataHeader;
            this._listDataChild = _listDataChild;
        }

        @Override
        public int getGroupCount() {
            return this._listDataHeader.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {

            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return this._listDataHeader.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                    .get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            String headerTitle = (String) getGroup(groupPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.group_item, null);
            }

            TextView lblListHeader = (TextView) convertView
                    .findViewById(R.id.textview1);

            lblListHeader.setTypeface(lnvmbd);
            lblListHeader.setText(headerTitle);

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            // final String childText = (String) getChild(groupPosition, childPosition);

            Item item = (Item) getChild(groupPosition, childPosition);

            if (convertView == null) {
                LayoutInflater infalInflater = (LayoutInflater) this._context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = infalInflater.inflate(R.layout.child_item, null);
            }





            TextView txtListChild = (TextView) convertView
                    .findViewById(R.id.textview2);

            TextView price = (TextView) convertView.findViewById(R.id.textview3);

            txtListChild.setText(item.getItem());
            txtListChild.setTypeface(lnvm);
            price.setText("Rs "+item.getPrice());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
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
