package com.example.asaf.paycheckcalc.Objects;

import com.example.asaf.paycheckcalc.MainActivity;

/**
 * Created by Asaf on 28/04/2017.
 */

public class Shift {

    private Date date;
    private Time start;
    private Time finish;
    private Time length;

    public Shift(Date date,Time start, Time finish)
    {
        this.date = date;
        this.start = start;
        this.finish = finish;
        this.length = new Time(finish.getHour()-start.getHour(),finish.getMinutes()-start.getMinutes());
    }

    public Shift()
    {

    }

    public Date getDate() {
        return date;
    }

    public Time getStart() {
        return start;
    }

    public Time getFinish() {
        return finish;
    }

    public Time getLength() {
        return length;
    }

    public double howMuchMoney() {
        return this.length.getHour()* MainActivity.perHourRate + ((this.length.getMinutes()/60)*MainActivity.perHourRate);
    }
}
