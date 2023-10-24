package com.example.testdemo;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.testdemo.dummy.IPhone;

import java.util.List;


public class PhoneAdapter extends BaseAdapter  {
    private Context context;
    private List<IPhone> IPhoneList;

    public PhoneAdapter(Context context, List<IPhone> IPhoneList) {
        this.context = context;
        this.IPhoneList = IPhoneList;
    }

    @Override
    public int getCount() {
        return IPhoneList != null ? IPhoneList.size() : 0;
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
                .inflate(R.layout.item_phone, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.name);
        View color= rootView.findViewById(R.id.color);

        txtName.setText(IPhoneList.get(i).getName());

        GradientDrawable shape = (GradientDrawable) color.getBackground();
        shape.setColor(Color.parseColor(IPhoneList.get(i).getColor()));
        return rootView;
    }


}
