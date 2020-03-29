package com.sun.gateway.entity;


public class MyException {
    private int status=200;
    private String message="";
    private String path="";
    private String error="";

    public MyException() {
    }

    public MyException(int status, String message, String path,String error) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.error=error;
    }

    public MyException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "status=" + status +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", error='" + error + '\'';
    }
}
