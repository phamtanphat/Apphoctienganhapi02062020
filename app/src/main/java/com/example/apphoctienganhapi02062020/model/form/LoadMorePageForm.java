package com.example.apphoctienganhapi02062020.model.form;

public class LoadMorePageForm {
    private Integer page;
    private Integer numItems;

    public LoadMorePageForm(Integer page, Integer numItems) {
        this.page = page;
        this.numItems = numItems;
    }

    public LoadMorePageForm() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getNumItems() {
        return numItems;
    }

    public void setNumItems(Integer numItems) {
        this.numItems = numItems;
    }
}
