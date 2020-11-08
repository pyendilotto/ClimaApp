package com.pieroyendilotto.climaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView listaCiudades;
    private String[] ciudades = new String[]{"Mar del Plata","Capital Federal","Londres","Turin","Helsinki","Rio de Janeiro"};
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //LINKEO OBJETOS XML:
        linkearXML();
        //INICIALIZO Y RELLENO EL LIST:
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ciudades) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                TextView tv = (TextView) super.getView(position, convertView, parent);

                tv.setGravity(Gravity.CENTER | Gravity.CENTER | Gravity.CENTER_VERTICAL);

                return tv;
            }
        };
        listaCiudades.setAdapter(adapter);
    }

    ///////////////////////////////////////////////////////////////////

    private void linkearXML(){

        listaCiudades = (ListView)findViewById(R.id.listaCiudades);

        listaCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                //AL TOCAR UN ITEM LE PASO EL NOMBRE ABRIENDO LA OTRA VENTANA:
                String ciudad=(String)parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, pronosticoExtendido.class);
                String message = ciudad;
                intent.putExtra("ciudad", message);
                startActivity(intent);
            }
        });
    }

    ///////////////////////////////////////////////////////////////////


}
