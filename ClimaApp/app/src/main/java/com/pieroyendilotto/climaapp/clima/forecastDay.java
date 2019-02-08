package com.pieroyendilotto.climaapp.clima;

import com.google.gson.annotations.SerializedName;

public class forecastDay {

    @SerializedName("date")
    String date;
    @SerializedName("day")
    day day;

    public com.pieroyendilotto.climaapp.clima.day getDay() {
        return day;
    }

    public void setDay(com.pieroyendilotto.climaapp.clima.day day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



}
