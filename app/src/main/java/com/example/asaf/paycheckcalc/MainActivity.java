package com.example.asaf.paycheckcalc;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private int perHourRate;
    private Dialog dialog;
    private ArrayAdapter<String> arrayAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createDialog();
        listView.setOnItemClickListener(this);
    }

    private void createDialog()
    {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.rate_dialog);
        listView = (ListView) dialog.findViewById(R.id.list_item);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item);
        for(int i = 0 ; i<=100; i++) {
            arrayAdapter.add(String.valueOf(i));
        }
        listView.setAdapter(arrayAdapter);
        dialog.show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        perHourRate = position+1;
    }
}
