package com.pieroyendilotto.climaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.pieroyendilotto.climaapp.clima.RetrofitInstance;
import com.pieroyendilotto.climaapp.clima.getForecastDataService;
import com.pieroyendilotto.climaapp.clima.manager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pronosticoExtendido extends AppCompatActivity {

    private ListView listaDias;
    private TextView txtCiudad;
    private ProgressBar progressBar;
    private ArrayList<renglonBase> data;
    private renglonAdapter adapter;
    private manager dataRetrofit;
    private String nombreCiudad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pronostico_extendido);
        //LINKEO OBJETOS XML:
        linkearXML();
        //SETEO EL PROGRESO:
        progressBar.setProgress(0);
        //OBTENGO EL INTENT Y SETEO EL TITULO DE LA VENTANA:
        Intent intent = getIntent();
        nombreCiudad = intent.getStringExtra("ciudad");
        txtCiudad.setText(nombreCiudad);

        //SETEO EL ARRAYLIST QUE ALIMENTA EL RENGLON CON LOS DATOS DE RETROFIT:
        if (savedInstanceState == null){

            getAndShowData();
        }
        else
            {
                data = savedInstanceState.getParcelableArrayList("savedData");
                getAndShowData();
            }
    }

    ///////////////////////////////////////////////////////////////////

    private void linkearXML(){

        listaDias = (ListView)findViewById(R.id.listaCiudades);
        txtCiudad = (TextView)findViewById(R.id.txtCiudad);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    ///////////////////////////////////////////////////////////////////

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("savedData", data);
        super.onSaveInstanceState(outState);
    }

    ///////////////////////////////////////////////////////////////////

    public String formatoFecha(String entrada) {
        //FORMATEO LA FECHA DE 'YYYY-MM-DD' A 'DD-MM'
        String fecha = "";
        fecha= fecha + entrada.charAt(entrada.length()-2);
        fecha= fecha + entrada.charAt(entrada.length()-1);
        fecha=fecha+ "-";//-
        fecha=fecha+entrada.charAt(entrada.length()-5);
        fecha=fecha+entrada.charAt(entrada.length()-4);

        return fecha;
    }

    ///////////////////////////////////////////////////////////////////

    public void getAndShowData(){

        //OBTENGO EL POJO DE RETROFIT:
        getForecastDataService service = RetrofitInstance.getRetrofitInstance().create(getForecastDataService.class);

        Call<manager> call = service.get_forecast("f62cdff1422d4cddab6184959190702", nombreCiudad,"5", "es");

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<manager>() {
            @Override
            public void onResponse(Call<manager> call, Response<manager> response) {
                dataRetrofit = new manager();
                //OBTENGO LA RESPUESTA:
                dataRetrofit = response.body();
                //ARMO EL ADAPTADOR DE RENGLONES:

                data = new ArrayList<renglonBase>();

                data.add(new renglonBase(formatoFecha(dataRetrofit.get_forecast().getArrayForecastDay().get(0).getDate()), dataRetrofit.get_forecast().getArrayForecastDay().get(0).getDay().get_condition().getText(), "http:"+dataRetrofit.get_forecast().getArrayForecastDay().get(0).getDay().get_condition().getIcon(), dataRetrofit.get_forecast().getArrayForecastDay().get(0).getDay().getMaxtemp_c()+"º", dataRetrofit.get_forecast().getArrayForecastDay().get(0).getDay().getMintemp_c()+"º"));
                data.add(new renglonBase(formatoFecha(dataRetrofit.get_forecast().getArrayForecastDay().get(1).getDate()), dataRetrofit.get_forecast().getArrayForecastDay().get(1).getDay().get_condition().getText(), "http:"+dataRetrofit.get_forecast().getArrayForecastDay().get(1).getDay().get_condition().getIcon(), dataRetrofit.get_forecast().getArrayForecastDay().get(1).getDay().getMaxtemp_c()+"º", dataRetrofit.get_forecast().getArrayForecastDay().get(1).getDay().getMintemp_c()+"º"));
                data.add(new renglonBase(formatoFecha(dataRetrofit.get_forecast().getArrayForecastDay().get(2).getDate()), dataRetrofit.get_forecast().getArrayForecastDay().get(2).getDay().get_condition().getText(), "http:"+dataRetrofit.get_forecast().getArrayForecastDay().get(2).getDay().get_condition().getIcon(), dataRetrofit.get_forecast().getArrayForecastDay().get(2).getDay().getMaxtemp_c()+"º", dataRetrofit.get_forecast().getArrayForecastDay().get(2).getDay().getMintemp_c()+"º"));
                data.add(new renglonBase(formatoFecha(dataRetrofit.get_forecast().getArrayForecastDay().get(3).getDate()), dataRetrofit.get_forecast().getArrayForecastDay().get(3).getDay().get_condition().getText(), "http:"+dataRetrofit.get_forecast().getArrayForecastDay().get(3).getDay().get_condition().getIcon(), dataRetrofit.get_forecast().getArrayForecastDay().get(3).getDay().getMaxtemp_c()+"º", dataRetrofit.get_forecast().getArrayForecastDay().get(3).getDay().getMintemp_c()+"º"));
                data.add(new renglonBase(formatoFecha(dataRetrofit.get_forecast().getArrayForecastDay().get(4).getDate()), dataRetrofit.get_forecast().getArrayForecastDay().get(4).getDay().get_condition().getText(), "http:"+dataRetrofit.get_forecast().getArrayForecastDay().get(4).getDay().get_condition().getIcon(), dataRetrofit.get_forecast().getArrayForecastDay().get(4).getDay().getMaxtemp_c()+"º", dataRetrofit.get_forecast().getArrayForecastDay().get(4).getDay().getMintemp_c()+"º"));

                adapter = new renglonAdapter(pronosticoExtendido.this, data);

                listaDias.setAdapter(adapter);
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<manager> call, Throwable t) {
                Toast.makeText(pronosticoExtendido.this, getResources().getString(R.string.error_internet)+ " " + t.getMessage(), Toast.LENGTH_LONG).show();
                progressBar.setVisibility(View.INVISIBLE);
            }
        });

    }

}
