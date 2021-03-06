package com.camp.cammvc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseApi<T> implements Serializable {


    private boolean isSuccessfull;
    private String message;
    private String Date;
    private List<T> data;
    private Page<T> page;


    public ResponseApi() {
    }

    public ResponseApi(boolean isSuccessfull, String message, String date, List<T> data) {
        this.isSuccessfull = isSuccessfull;
        this.message = message;
        Date = date;
        this.data = data;
    }

    public ResponseApi(boolean isSuccessfull, String message, String date, List<T> data, Page<T> page) {
        this.isSuccessfull = isSuccessfull;
        this.message = message;
        Date = date;
        this.data = data;
        this.page=page;
    }

    public Page<T> getPage() {
        return page;
    }

    public void setPage(Page<T> page) {
        this.page = page;
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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }


}
