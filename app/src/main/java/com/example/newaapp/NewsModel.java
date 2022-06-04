package com.example.newaapp;

import java.io.Serializable;
import java.util.ArrayList;

public class NewsModel implements Serializable {
    String status;
    String totalResults;
    ArrayList<newsArticles> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<newsArticles> getNewsArticlesArrayList() {
        return articles;
    }

    public void setNewsArticlesArrayList(ArrayList<newsArticles> newsArticlesArrayList) {
        this.articles = newsArticlesArrayList;
    }

    public NewsModel(String status, String totalResults, ArrayList<newsArticles> newsArticlesArrayList) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = newsArticlesArrayList;
    }
}
