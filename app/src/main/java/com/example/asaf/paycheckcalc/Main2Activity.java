package com.example.asaf.paycheckcalc;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import static com.example.asaf.paycheckcalc.R.id.list_item;
import static com.example.asaf.paycheckcalc.R.id.startButton;

public class Main2Activity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView)findViewById(R.id.list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(id==startButton)
                    Log.d("id",String.valueOf(view.getId()));
            }
        });

        adapter = new ArrayAdapter(this,R.layout.list_item);

        listView.setAdapter(adapter);
        adapter.add(null);
    }
}
