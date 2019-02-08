package com.pieroyendilotto.climaapp.clima;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class forecast {

    @SerializedName("forecastday")
    private ArrayList<forecastDay> arrayForecastDay;

    public ArrayList<forecastDay> getArrayForecastDay() {

        return arrayForecastDay;
    }

    public void setArrayForecastDay(ArrayList<forecastDay> arrayclima)
    {
        this.arrayForecastDay = arrayclima;
    }
}
