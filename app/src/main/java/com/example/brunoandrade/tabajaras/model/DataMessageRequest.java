
package com.example.brunoandrade.tabajaras.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataMessageRequest implements Serializable{

    @SerializedName("data")
    private Data data;


    public DataMessageRequest(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
