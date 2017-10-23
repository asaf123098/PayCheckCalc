package com.example.asaf.paycheckcalc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity{

    private static  ArrayList SHIFTS = new ArrayList();
    private ListView listView;
    private ShiftsAdapter adapter;


    public static Shift getItem(int pos)
    {
        return (Shift) SHIFTS.get(pos);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView)findViewById(R.id.listview);

        adapter = new ShiftsAdapter(this, R.layout.shifts_list_item, SHIFTS);

        listView.setAdapter(adapter);
    }

    public void addShift(View v)
    {
        Shift shift = new Shift();

        SHIFTS.add(shift);
        adapter.notifyDataSetChanged();
    }
}
