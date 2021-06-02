package com.alma.methoda;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TransactionDataModel implements Serializable {
    @SerializedName("id")
    @Expose
    private int id;

    private String name_t, from_s, to_s;

    public TransactionDataModel(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_t() {
        return name_t;
    }

    public void setName_t(String name_t) {
        this.name_t = name_t;
    }

    public String getFrom_s() {
        return from_s;
    }

    public void setFrom_s(String from_s) {
        this.from_s = from_s;
    }

    public String getTo_s() {
        return to_s;
    }

    public void setTo_s(String to_s) {
        this.to_s = to_s;
    }
}