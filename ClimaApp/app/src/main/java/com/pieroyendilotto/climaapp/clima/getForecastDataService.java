package com.pieroyendilotto.climaapp.clima;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface getForecastDataService {

        @GET("v1/forecast.json?")
        Call<manager> get_forecast(@Query("key") String key, @Query("q") String q, @Query("days") String days, @Query("lang") String lang);

    }

