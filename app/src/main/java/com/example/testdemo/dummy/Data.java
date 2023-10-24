package com.example.testdemo.dummy;


import com.example.testdemo.R;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<IPhone> getIPhoneList() {
        List<IPhone> IPhoneList = new ArrayList<>();

        IPhone White = new IPhone();
        White.setName("White");
        White.setImage(R.drawable.iphone_white);
        White.setColor("#F0F2F2");
        White.setCapacity(List.of("65","125","256","512"));

        IPhoneList.add(White);

        IPhone Black = new IPhone();
        Black.setName("Black");
        Black.setImage(R.drawable.iphone_black);
        Black.setColor("#403E3D");
        Black.setCapacity(List.of("125","256","512"));


        IPhoneList.add(Black);

        IPhone Gold = new IPhone();
        Gold.setName("Gold");
        Gold.setImage(R.drawable.iphone_gold);
        Gold.setColor("#F4E8CE");
        Gold.setCapacity(List.of("256","512"));


        IPhoneList.add(Gold);

        IPhone Purple = new IPhone();
        Purple.setName("Purple");
        Purple.setImage(R.drawable.purple);
        Purple.setColor("#594F63");
        Purple.setCapacity(List.of("512"));

        IPhoneList.add(Purple);


        return IPhoneList;
    }

}
