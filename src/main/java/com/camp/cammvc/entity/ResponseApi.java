package com.camp.cammvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseApi implements Serializable {


    private boolean isSuccessfull;
    private String message;
    private String Date;
    private List<AppUser> data;

    public ResponseApi() {
    }

    public ResponseApi(boolean isSuccessfull, String message, String date, List<AppUser> data) {
        this.isSuccessfull = isSuccessfull;
        this.message = message;
        Date = date;
        this.data = data;
    }

    public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String error) {
        this.message = error;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public List<AppUser> getData() {
        return data;
    }

    public void setData(List<AppUser> data) {
        this.data = data;
    }


}
