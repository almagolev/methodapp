package com.alma.methoda;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class StatusDataModel implements Serializable {
    @SerializedName("id")
    @Expose
    private int id;

    private String name_s, label_s;

    public StatusDataModel(){}

    public int getId (){ return id;}

    public String getLabel_s() {
        return label_s;
    }

    public String getName_s() {
        return name_s;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName_s(String name_s) {
        this.name_s = name_s;
    }

    public void setLabel_s(String label_s) {
        this.label_s = label_s;
    }
}
