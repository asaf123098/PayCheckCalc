package com.example.asaf.paycheckcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Shifts_Details extends AppCompatActivity {

    private TextView paySum;
    private TextView hours;
    private TextView hoursSum;
    private Button editShift;
    private Shift shift;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shifts__details);

        paySum = (TextView)findViewById(R.id.pay_sum);
        hours = (TextView)findViewById(R.id.hours);
        hoursSum = (TextView)findViewById(R.id.hours_sum);
        editShift = (Button) findViewById(R.id.editShift);

        int pos = getIntent().getIntExtra("Shift_pos", 0);

        if( Main2Activity.getItem(pos) !=null)
        {
            shift =  Main2Activity.getItem(pos);
        }

        /*if (Main2Activity.SHIFTS.get(pos) != null)
        {
            shift = (Shift)Main2Activity.SHIFTS.get(pos);
        }*/

        paySum.setText(String.valueOf(shift.howMuchMoney()) + "$");
        hours.setText(shift.getStart().ToString() + " - " + shift.getFinish().ToString());
        hoursSum.setText("Total: " + String.valueOf(shift.getLength().ToString()));

    }
}
