package com.example.newaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //2e8024062d2a45ada274fbb743a445db
    private RecyclerView HorizontalView,VerticalView;
    private ArrayList<newsArticles> verticalNews;
    private ArrayList<newsArticles> horizontalNews;
    verticalAdapter verticalAdapter;
    horizontalAdapter horizontalAdapter;
    ArrayList<newsArticles> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HorizontalView=findViewById(R.id.horizontalRecycler);
        VerticalView=findViewById(R.id.verticalRecycler);
        verticalNews=new ArrayList<>();
        horizontalNews=new ArrayList<>();


        verticalAdapter=new verticalAdapter(verticalNews,this);
        horizontalAdapter=new horizontalAdapter(horizontalNews,this);

        VerticalView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        VerticalView.setAdapter(verticalAdapter);
        //HorizontalView.setLayoutManager(new LinearLayoutManager(this));
        HorizontalView.setAdapter(horizontalAdapter);

        getNews();



    }
    private void getNews(){
        //verticalNews.clear();
        String url="https://newsapi.org/v2/top-headlines?excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apiKey=2e8024062d2a45ada274fbb743a445db";
        String BASE_URL="https://newsapi.org/";
        String topStoriesURL="https://newsapi.org/v2/top-headlines?country=au&excludeDomains=stackoverflow.com&sortBy=publishedAt&language=en&apiKey=2e8024062d2a45ada274fbb743a445db";
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitApi retrofitApi=retrofit.create(RetrofitApi.class);
        Call<NewsModel> call;
        call= retrofitApi.getAllNews(url);
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {

                NewsModel newsModel=response.body();
                articles=newsModel.getNewsArticlesArrayList();

                //Toast.makeText(MainActivity.this, articles.size(), Toast.LENGTH_SHORT).show();
                if(true){
                    for (int i = 0; i < 10 ; i++) {
                        verticalNews.add(new newsArticles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),articles.get(i).getUrl(),articles.get(i).getContent()));

                    }
                    verticalAdapter.notifyDataSetChanged();

                    //horizontalAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this, "nothing there", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed ", Toast.LENGTH_SHORT).show();
            }
        });
        Retrofit retrofits=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitApi retrofitApis=retrofits.create(RetrofitApi.class);
        Call<NewsModel> calls;
        calls= retrofitApis.getAllNews(topStoriesURL);
        calls.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {

                NewsModel newsModel=response.body();
                articles=newsModel.getNewsArticlesArrayList();

                //Toast.makeText(MainActivity.this, articles.size(), Toast.LENGTH_SHORT).show();
                if(true){
                    for (int i = 0; i < 10 ; i++) {
                        //verticalNews.add(new newsArticles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),articles.get(i).getUrl(),articles.get(i).getContent()));
                        horizontalNews.add(new newsArticles(articles.get(i).getTitle(),articles.get(i).getDescription(),articles.get(i).getUrlToImage(),articles.get(i).getUrl(),articles.get(i).getContent()));
                    }
                    //verticalAdapter.notifyDataSetChanged();

                    horizontalAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this, "nothing there", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed ", Toast.LENGTH_SHORT).show();
            }
        });



    }
}