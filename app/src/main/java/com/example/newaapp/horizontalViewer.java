package com.example.newaapp;

public class horizontalViewer {
    private String imageUrl;
    private String headline;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public horizontalViewer(String imageUrl, String headline) {
        this.imageUrl = imageUrl;
        this.headline = headline;
    }


}
