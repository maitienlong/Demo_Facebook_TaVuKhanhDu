package com.example.demotavukhanhdu;

// COPYRIGHT BY MAI TIEN LONG

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.demotavukhanhdu.adapter.RV1Adapter;
import com.example.demotavukhanhdu.model.HoaDon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RV1Adapter rv1Adapter;
    private RecyclerView rv1;
    private LinearLayoutManager linearLayoutManager;
    List<HoaDon> hoaDonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = findViewById(R.id.rv1);

// THÊM DỮ LIỆU VÀO LIST
        hoaDonList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            HoaDon hoaDon = new HoaDon();
            hoaDon.id = "PH000" + i;
            hoaDon.name = "Mai Tien Long";

            hoaDonList.add(hoaDon);
        }

        Log.e("LIST", hoaDonList.size() + "");

// SET RECYCLERVIEW LÊN ACTIVITY

        linearLayoutManager = new LinearLayoutManager(this);

        rv1Adapter = new RV1Adapter(this, hoaDonList);

        rv1.setAdapter(rv1Adapter);

        rv1.setLayoutManager(linearLayoutManager);

// BĂT SỰ KIỆN KHI CLICK VÀO ITEM CỦA RV

        RV1Adapter.ItemClickSupport.addTo(rv1).setOnItemClickListener(new RV1Adapter.ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_recycleview2);

                Window window = dialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.CENTER;
                wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
                window.setAttributes(wlp);
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();

                RecyclerView rv2 = dialog.findViewById(R.id.rv2);

                // SET RV LÊN DIALOG
                // LƯU Ý: 2 RECYCLERVIEW NÀY DÙNG CHUNG DỮ LIỆU

                linearLayoutManager = new LinearLayoutManager(MainActivity.this);

                rv1Adapter = new RV1Adapter(MainActivity.this, hoaDonList);

                rv2.setAdapter(rv1Adapter);

                rv2.setLayoutManager(linearLayoutManager);


            }
        });
    }
}
