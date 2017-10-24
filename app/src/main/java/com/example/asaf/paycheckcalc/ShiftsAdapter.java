package com.example.asaf.paycheckcalc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.asaf.paycheckcalc.Objects.Shift;

import java.util.ArrayList;


/**
 * Created by Asaf on 05/05/2017.
 */

public class ShiftsAdapter extends ArrayAdapter <Shift> implements View.OnClickListener {


    private TextView shifts_date;

    private Shift currentShift;


    public ShiftsAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull final ArrayList<Shift> shifts) {
        super(context, resource, shifts);

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

        currentShift = getItem(position);

        if (currentShift != null) {
            shifts_date = (TextView) v.findViewById(R.id.shifts_date);
            shifts_date.setOnClickListener(this);
        }
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shifts_date: {

                Intent intent = new Intent(getContext(),ShiftsDetails.class);
                intent.putExtra("Shift_pos",getPosition(currentShift));
                getContext().startActivity(intent);
            }
            break;
        }
    }
}
