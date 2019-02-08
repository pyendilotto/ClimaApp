package com.pieroyendilotto.climaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class renglonBase implements Parcelable {

    private String fecha;
    private String detalle;
    private String urlIcono;
    private String max;
    private String min;

    public renglonBase(String fecha, String detalle, String urlicono, String max, String min) {
        this.fecha = fecha;
        this.detalle = detalle;
        this.urlIcono = urlicono;
        this.max = max;
        this.min = min;

    }

    public renglonBase(Parcel in){

        this.fecha =  in.readString();
        this.detalle =  in.readString();
        this.urlIcono = in.readString();
        this.max =  in.readString();
        this.min =  in.readString();
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDetalle() {
        return detalle;
    }


    public void setUrlIcono(String urlIcono) {
        this.urlIcono = urlIcono;
    }

    public String getUrlIcono() {
        return urlIcono;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMax() {
        return max;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMin() {
        return min;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getFecha());
        dest.writeString(getDetalle());
        dest.writeString(getUrlIcono());
        dest.writeString(getMax());
        dest.writeString(getMin());
    }

    public static final Parcelable.Creator<renglonBase> CREATOR = new Parcelable.Creator<renglonBase>() {
        public renglonBase createFromParcel(Parcel in) {
            return new renglonBase(in);
        }

        public renglonBase[] newArray(int size) {
            return new renglonBase[size];
        }
    };
}
