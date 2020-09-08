package com.example.apphoctienganhapi02062020.model.response;

public class ResponseData<T> {

    private int totalpage;
    private String currentpage;
    private boolean success;
    private String message;
    private T data;

    public ResponseData(int totalpage, String currentpage, boolean success, String message, T data) {
        this.totalpage = totalpage;
        this.currentpage = currentpage;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResponseData() {
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public String getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(String currentpage) {
        this.currentpage = currentpage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
