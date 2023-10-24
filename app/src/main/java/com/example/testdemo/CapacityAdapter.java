package com.example.testdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CapacityAdapter  extends BaseAdapter {
    private Context context;
    private List<String> capacityList;

    public CapacityAdapter(Context context, List<String> capacityList) {
        this.context = context;
        this.capacityList = capacityList;
    }

    @Override
    public int getCount() {
        return capacityList != null ? capacityList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_capacity, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.capacity_VF);

        txtName.setText(capacityList.get(i).toString());

        return rootView;
    }


}
