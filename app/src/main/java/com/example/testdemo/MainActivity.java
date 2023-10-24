package com.example.testdemo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testdemo.dummy.Data;


public class MainActivity extends AppCompatActivity implements CustomSpinner.OnSpinnerEventsListener{

    private CustomSpinner spinner_iphones,spinner_capacity;
    private ImageView imageView;

    private PhoneAdapter adapter;

    private CapacityAdapter adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_iphones = findViewById(R.id.spinner_phones);
        spinner_capacity = findViewById(R.id.spinner_capacity);
        spinner_iphones.setBackground(getResources().getDrawable(R.drawable.bg_spinner_down));
        spinner_capacity.setBackground(getResources().getDrawable(R.drawable.bg_spinner_down));


        imageView = findViewById(R.id.image_view);
        imageView.setImageResource(Data.getIPhoneList().get(0).getImage());

        spinner_iphones.setSpinnerEventsListener(this);
        spinner_capacity.setSpinnerEventsListener2(this);

        adapter = new PhoneAdapter(MainActivity.this, Data.getIPhoneList());
        spinner_iphones.setAdapter(adapter);

        adapters = new CapacityAdapter(MainActivity.this, Data.getIPhoneList().get(0).getCapacity());
        spinner_capacity.setAdapter(adapters);
    }

    @Override
    public void onPopupWindowOpened(Spinner spinner) {
        spinner_iphones.setBackground(getResources().getDrawable(R.drawable.bg_spinner_up));}

    @Override
    public void onPopupWindowClosed(Spinner spinner) {
        spinner_iphones.setBackground(getResources().getDrawable(R.drawable.bg_spinner_down));
      int lo=  spinner_iphones.getSelectedItemPosition();
        imageView.setImageResource(Data.getIPhoneList().get(lo).getImage());

        adapters = new CapacityAdapter(MainActivity.this, Data.getIPhoneList().get(lo).getCapacity());
        spinner_capacity.setAdapter(adapters);
    }

    @Override
    public void onPopupWindowOpened2(Spinner spinner) {
        spinner_capacity.setBackground(getResources().getDrawable(R.drawable.bg_spinner_up));}

    @Override
    public void onPopupWindowClosed2(Spinner spinner) {
        spinner_capacity.setBackground(getResources().getDrawable(R.drawable.bg_spinner_down));
        int lo=  spinner_capacity.getSelectedItemPosition();
        if(lo!=0){Toast.makeText(getApplicationContext(),".........Calling API and Refresh........",Toast.LENGTH_LONG).show();}
    }
}