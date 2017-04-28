package com.example.asaf.paycheckcalc;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TimePicker;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity{


    private RelativeLayout shiftsOrganizer;
    private Time startTime;
    private Time finishTime;
    private Date date;
    private ArrayList shifts;
    private Button addShift;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog startTimePickerDialog;
    private TimePickerDialog finishTimePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        addShift = (Button)findViewById(R.id.addShift);
        shiftsOrganizer = (RelativeLayout)findViewById(R.id.organizer);

        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date = new Date (dayOfMonth,month, year);
                datePickerDialog.dismiss();
                startTimePickerDialog.show();
            }
        }, 2017,5,1);
        datePickerDialog.setTitle("When did you work?");


        startTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                startTime = new Time(hourOfDay,minute);
                startTimePickerDialog.dismiss();
                finishTimePickerDialog.show();
            }
        }, 0,0,true);
        startTimePickerDialog.setTitle("When did you start?");



        finishTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                finishTime = new Time(hourOfDay,minute);
                Shift shift = new Shift(date,startTime,finishTime);


                Log.d("date",String.valueOf(date.getDay()));
                Log.d("start",String.valueOf(startTime.getHour()));
                Log.d("finish",String.valueOf(finishTime.getHour()));

                finishTimePickerDialog.dismiss();

            }
        }, 0,0,true);
        finishTimePickerDialog.setTitle("When did you finish?");



        shifts = new ArrayList();

    }

    public void addShift(View v)
    {

        datePickerDialog.show();



    }



   /* private LinearLayout makeShift()
    {

        return layout;
    }*/
}
