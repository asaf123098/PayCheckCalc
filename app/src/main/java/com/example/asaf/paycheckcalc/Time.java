package com.example.asaf.paycheckcalc;

/**
 * Created by Asaf on 28/04/2017.
 */

public class Time {

    private int hour;
    private int minutes;

    public Time(int hour, int minutes)
    {
        this.minutes = minutes;
        this.hour = hour;
    }

    public Time()
    {}

    public int getMinutes()
    {
        return this.minutes;
    }

    public int getHour()
    {
        return this.hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}

