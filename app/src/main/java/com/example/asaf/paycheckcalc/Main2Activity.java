package com.example.asaf.paycheckcalc;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{

    private Button addShift;
    private ListView listView;
    private AdapterView adapterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView)findViewById(R.id.list);


        addShift =(Button)findViewById(R.id.add);
        addShift.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == addShift.getId())
        {

        }
    }
}
