package com.example.administrator.homework_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvDsDiaDiem;
    List<DiaDiem> listDiaDiem;
    DiaDiemAdapter diaDiemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        lvDsDiaDiem = findViewById(R.id.lvDsDiaDiem);
        listDiaDiem = new ArrayList<>();
        listDiaDiem.add(new DiaDiem(
                "Phúc Long Coffee", "http://www.trasuaphuclong.com",
                10.753925, 106.655473
        ));
        listDiaDiem.add(new DiaDiem(
                "Gong Cha", "http://gongcha.com.vn",
                10.755259, 106.657557
        ));
        listDiaDiem.add(new DiaDiem(
                "Koi Thé", "https://www.koithe.com",
                10.743775, 106.610809
        ));
        listDiaDiem.add(new DiaDiem(
                "Royal Tea", "http://royaltea.com.vn",
                10.798035, 106.689838
        ));
        listDiaDiem.add(new DiaDiem(
                "Coffee House", "http://www.thecoffeehouse.com",
                10.764944, 106.647360
        ));
        listDiaDiem.add(new DiaDiem(
                    "The Coffee Bean & Tea Leaf", "https://www.coffeebean.com",
                10.774758, 106.688337
        ));
        listDiaDiem.add(new DiaDiem(
                "Highland Coffee", "http://www.highlandscoffee.com.vn/vi/home",
                10.776374, 106.680519
        ));
        listDiaDiem.add(new DiaDiem(
                "MyLife Coffee", "http://mylifecoffee.vn",
                10.764660, 106.692185
        ));
        listDiaDiem.add(new DiaDiem(
                "Viva Star Coffee", "http://vivastarcoffee.com",
                10.774910, 106.676408
        ));
        listDiaDiem.add(new DiaDiem(
                "Toco Toco", "http://tocotocotea.com",
                10.763117, 106.668399
        ));

        diaDiemAdapter = new DiaDiemAdapter(this, R.layout.diadiem_item, listDiaDiem);
        lvDsDiaDiem.setAdapter(diaDiemAdapter);
    }
}
