package com.pieroyendilotto.climaapp.clima;

import com.google.gson.annotations.SerializedName;


public class manager {

        @SerializedName("forecast")
        private forecast _forecast;

        public forecast get_forecast() {
            return _forecast;
        }

        public void set_forecast(forecast _forecast) {
            this._forecast = _forecast;
        }

    }

