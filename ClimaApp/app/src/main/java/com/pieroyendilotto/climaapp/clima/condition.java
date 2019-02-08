package com.pieroyendilotto.climaapp.clima;

import com.google.gson.annotations.SerializedName;

public class condition {

    @SerializedName("icon")
    String icon;

    @SerializedName("text")
    String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}
