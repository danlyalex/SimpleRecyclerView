package com.example.jiang.myrecyclerviewdemo.model;

/**
 * Created by jiang on 15/9/15.
 */
public class StaggerModel {
    private String title;

    public String getTitle() {
        return title;
    }

    public StaggerModel(String title, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public StaggerModel() {
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    private String imgUrl;
}
