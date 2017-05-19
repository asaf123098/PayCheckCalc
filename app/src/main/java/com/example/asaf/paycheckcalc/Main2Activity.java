package com.example.asaf.paycheckcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity{

    private ArrayList shifts;
    private ListView listView;
    private ShiftsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView)findViewById(R.id.listview);

        shifts = new ArrayList();
        adapter = new ShiftsAdapter(this, R.layout.shifts_list_item, shifts);

        listView.setAdapter(adapter);
    }

    public void addShift(View v)
    {
        Shift shift = new Shift();

        shifts.add(shift);
        adapter.notifyDataSetChanged();
    }
}
