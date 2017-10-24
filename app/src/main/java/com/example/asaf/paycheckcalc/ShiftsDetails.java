package com.example.asaf.paycheckcalc;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.asaf.paycheckcalc.Objects.Date;
import com.example.asaf.paycheckcalc.Objects.Shift;
import com.example.asaf.paycheckcalc.Objects.Time;

public class ShiftsDetails extends AppCompatActivity {

    private TextView paySum;
    private TextView hours;
    private TextView hoursSum;
    private Shift shift;


    private DatePickerDialog datePickerDialog;
    private TimePickerDialog startTimePickerDialog;
    private TimePickerDialog finishTimePickerDialog;

    private Date date;
    private Time startTime;
    private Time finishTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shifts__details);

        paySum = (TextView)findViewById(R.id.pay_sum);
        hours = (TextView)findViewById(R.id.hours);
        hoursSum = (TextView)findViewById(R.id.hours_sum);

        int pos = getIntent().getIntExtra("Shift_pos", 0);

        if( Main2Activity.getItem(pos) !=null)
        {
            shift =  Main2Activity.getItem(pos);
        }



        this.datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date = new Date(dayOfMonth, month, year);
            }
        }, 2017, 5, 1);
        this.datePickerDialog.setTitle("When did you work?");

        this.startTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                startTime = new Time(hourOfDay, minute);
            }
        }, 0, 0, true);
        this.startTimePickerDialog.setTitle("When did you start?");


        this.finishTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                finishTime = new Time(hourOfDay, minute);
            }
        }, 0, 0, true);
        this.finishTimePickerDialog.setTitle("When did you finish?");


    }

    public void editShift()
    {

        //paySum.setText("Sum: " + String.valueOf(shift.howMuchMoney()) + "$");
        //hours.setText("Hours: " + shift.getStart().ToString() + " - " + shift.getFinish().ToString());
        //hoursSum.setText("Total: " + String.valueOf(shift.getLength().ToString()));


    }


    /*case R.id.startTime:
            {
                //To know which startTime button was pressed.
                //startButton = (Button)v;
                startTimePickerDialog.show();
            }
            break;
            case R.id.finishTime:
            {
                //To know which finishTime button was pressed.
                //finishButton = (Button)v;
                finishTimePickerDialog.show();
            }
            break;*/


  /*  private String howMuchTime(Time startTime, Time finishTime) {
        //calculate how long was the time between start and finish.
        int startInMinutes = (startTime.getHour() * 60) + startTime.getMinutes();
        int finishInMinutes = (finishTime.getHour() * 60) + finishTime.getMinutes();
        double howManyMinutes = (double) finishInMinutes - startInMinutes;
        int howManyHours = (int) howManyMinutes/60;
        int minutes = (int) howManyMinutes - howManyHours*60;

        return howManyHours + ":" + minutes;
    }*/

}
