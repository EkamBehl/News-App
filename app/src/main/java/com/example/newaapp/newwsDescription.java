package com.example.newaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class newwsDescription extends AppCompatActivity {
    /**
     * newsView which includes the Related Stories recyclerView
     * */


    //implementation of all widgets in the xml layout
    TextView titletext,descriptiontext;
    ImageView imgView;
    String title,Content,imageToUrl,description;
    RecyclerView recyclerView;
    verticalAdapter vr;  //getting the vertical adapter for the recycler which shows related stories
    ArrayList<newsArticles> newsArticles; //stores all articles
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newws_description);
        Intent getint=getIntent(); //get intent for getting all values from last activity
        title=getint.getStringExtra("title");//gets the tile for the news
        Content=getint.getStringExtra("con"); //gets the content of the news
        description=getint.getStringExtra("description"); //gets the description of the article
        imageToUrl=getint.getStringExtra("img"); //gets the url for the image
        recyclerView=findViewById(R.id.recycler1); //to access the recycler view
        Bundle data=getIntent().getExtras(); //to get the custom Array list from last activity



        newsArticles=(ArrayList<newsArticles>) data.getSerializable("articles"); //gets serializable Arrayliost of type newsArticles and stores it in newsArticvles
        vr= new verticalAdapter(newsArticles,this);//sets the adapter of the recycler



        //ArrayList<newsArticles> newlist= (ArrayList<newsArticles>)data.getParcelable("articles");

        //for accessing all widgets
        titletext=findViewById(R.id.textView);
        descriptiontext=findViewById(R.id.textView2);
        imgView=findViewById(R.id.imageView);

        titletext.setText(title);
        descriptiontext.setText(description);
        Picasso.get().load(imageToUrl).into(imgView);
        recyclerView.setAdapter(vr);
        //setting the layout manager to linear layout
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}