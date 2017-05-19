package com.example.asaf.paycheckcalc;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;


/**
 * Created by Asaf on 05/05/2017.
 */

public class ShiftsAdapter extends ArrayAdapter <Shift> implements View.OnClickListener{

    private Date date;
    private Time startTime;
    private Time finishTime;

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog startTimePickerDialog;
    private TimePickerDialog finishTimePickerDialog;

    private Button startButton;
    private Button finishButton;


    public ShiftsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Shift> shifts) {
        super(context, resource, shifts);


        datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date = new Date (dayOfMonth,month, year);
            }
        }, 2017,5,1);
        datePickerDialog.setTitle("When did you work?");

        startTimePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                startTime = new Time(hourOfDay,minute);
                startButton.setText(String.format("%02d:%02d", hourOfDay, minute));
            }
        }, 0,0,true);
        startTimePickerDialog.setTitle("When did you start?");


        finishTimePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                finishTime = new Time(hourOfDay,minute);
                finishButton.setText(String.format("%02d:%02d", hourOfDay, minute));
            }
        }, 0,0,true);
        finishTimePickerDialog.setTitle("When did you finish?");

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.shifts_list_item, null);
        }

        Shift p = getItem(position);

        if (p != null) {
            startButton = (Button) v.findViewById(R.id.startTime);
            startButton.setOnClickListener(this);
            finishButton= (Button) v.findViewById(R.id.finishTime);
            finishButton.setOnClickListener(this);
            TextView payment = (TextView) v.findViewById(R.id.payment);
        }
        return v;
    }

    private double howManyMinutes (Time startTime, Time finishTime)
    {
        //calculate how many minutes are between start and finish.
        int startInMinutes = (startTime.getHour()*60)+startTime.getMinutes();
        int finishInMinutes = (finishTime.getHour()*60)+finishTime.getMinutes();
        double howManyMinutes =(double) finishInMinutes-startInMinutes;

        return howManyMinutes;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.startTime:
            {
                //To know which startTime button was pressed.
                startButton = (Button)v;
                startTimePickerDialog.show();
            }
            break;
            case R.id.finishTime:
            {
                //To know which finishTime button was pressed.
                finishButton = (Button)v;
                finishTimePickerDialog.show();
            }
            break;
        }
    }
}
