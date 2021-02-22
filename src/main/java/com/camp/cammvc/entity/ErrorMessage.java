package com.camp.cammvc.entity;

public class ErrorMessage {

    private String message;
    private String stackTrace;
    private String url;
    private String date;



    public ErrorMessage() {
    }

    public ErrorMessage(String message, String stackTrace, String url, String date) {
        this.message = message;
        this.stackTrace = stackTrace;
        this.url = url;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
