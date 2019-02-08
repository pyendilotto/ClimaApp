package com.pieroyendilotto.climaapp.clima;

import com.google.gson.annotations.SerializedName;

public class day {

    @SerializedName("maxtemp_c")
    String maxtemp_c;

    @SerializedName("condition")
    condition _condition;

    @SerializedName("mintemp_c")
    String mintemp_c;

    public String getMaxtemp_c() {
        return maxtemp_c;
    }

    public void setMaxtemp_c(String maxtemp_c) {
        this.maxtemp_c = maxtemp_c;
    }


    public String getMintemp_c() {
        return mintemp_c;
    }

    public void setMintemp_c(String mintemp_c) {
        this.mintemp_c = mintemp_c;
    }

    public condition get_condition() {
        return _condition;
    }

    public void set_condition(condition _condition) {
        this._condition = _condition;
    }



}
