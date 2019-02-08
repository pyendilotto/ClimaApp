package com.pieroyendilotto.climaapp;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pieroyendilotto.climaapp.clima.DownloadImageTask;

public class renglonAdapter extends BaseAdapter
{
    static class ViewHolder
    {
        TextView fecha;
        TextView detalle;
        ImageView icono;
        TextView max;
        TextView min;
    }

    private static final String TAG = "CustomAdapter";
    private static int convertViewCounter = 0;

    private ArrayList<renglonBase> data;
    private LayoutInflater inflater = null;

    public renglonAdapter(Context c, ArrayList<renglonBase> d)
    {
        Log.v(TAG, "Constructing CustomAdapter");

        this.data = d;
        inflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount()
    {
        Log.v(TAG, "in getCount()");
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        Log.v(TAG, "in getItem() for position " + position);
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        Log.v(TAG, "in getItemId() for position " + position);
        return position;
    }

    @Override
    public int getViewTypeCount()
    {
        Log.v(TAG, "in getViewTypeCount()");
        return 1;
    }

    @Override
    public int getItemViewType(int position)
    {
        Log.v(TAG, "in getItemViewType() for position " + position);
        return 0;
    }

    @Override
    public void notifyDataSetChanged()
    {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ViewHolder holder;

        Log.v(TAG, "in getView for position " + position + ", convertView is "
                + ((convertView == null) ? "null" : "being recycled"));

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.renglon_ciudad, null);

            convertViewCounter++;
            Log.v(TAG, convertViewCounter + " convertViews have been created");

            holder = new ViewHolder();

            holder.fecha = (TextView) convertView.findViewById(R.id.fecha);
            holder.detalle = (TextView) convertView.findViewById(R.id.detalle);
            holder.icono = (ImageView) convertView.findViewById(R.id.icono);
            holder.max = (TextView) convertView.findViewById(R.id.max);
            holder.min = (TextView) convertView.findViewById(R.id.min);

            convertView.setTag(holder);

        } else
            holder = (ViewHolder) convertView.getTag();

        holder.fecha.setText(data.get(position).getFecha());
        holder.detalle.setText(data.get(position).getDetalle());

        //SETEO EL ICONO EN BASE A LA URL TRAIDA DE RETROFIT:
        new DownloadImageTask(holder.icono).execute(data.get(position).getUrlIcono());

        holder.max.setText(data.get(position).getMax());
        holder.min.setText(data.get(position).getMin());

        return convertView;
    }

}
