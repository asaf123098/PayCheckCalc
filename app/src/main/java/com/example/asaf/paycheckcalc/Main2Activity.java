package com.example.asaf.paycheckcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.asaf.paycheckcalc.Objects.Shift;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity{

    private static  ArrayList shiftsList;
    private ListView listView;
    private ShiftsAdapter adapter;


    public static Shift getItem(int pos)
    {
        return (Shift) shiftsList.get(pos);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        shiftsList  = new ArrayList();

        listView = (ListView)findViewById(R.id.listview);

        adapter = new ShiftsAdapter(this, R.layout.shifts_list_item, shiftsList);

        listView.setAdapter(adapter);
    }

    public void addShift(View v)
    {
        Shift shift = new Shift();

        shiftsList.add(shift);
        adapter.notifyDataSetChanged();
    }
}
