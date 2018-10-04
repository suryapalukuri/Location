package com.example.admin.location;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter extends BaseAdapter{
    Context context;
    ArrayList<String> arrayList;
    public CustomAdapter(Context context, ArrayList<String> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View customview;
      view= LayoutInflater.from(context).inflate(R.layout.activity_custom_view, viewGroup, false);
        TextView latitude=view.findViewById(R.id.t1);
        latitude.setText(arrayList.get(i));
        TextView longitude=view.findViewById(R.id.t2);
        longitude.setText(arrayList.get(i));
        customview=view;
        return customview;
    }
}
