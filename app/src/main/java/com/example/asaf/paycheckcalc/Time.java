package com.example.asaf.paycheckcalc;

/**
 * Created by Asaf on 28/04/2017.
 */

public class Time {

    private int hour;
    private int minutes;

    public Time(int minutes, int hour)
    {
        this.minutes = minutes;
        this.hour = hour;
    }

    public int getMinutes()
    {
        return this.minutes;
    }

    public int getHour()
    {
        return this.hour;
    }
}
