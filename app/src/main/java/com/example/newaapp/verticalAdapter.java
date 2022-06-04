package com.example.newaapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class verticalAdapter extends RecyclerView.Adapter<verticalAdapter.ViewHolder> implements Serializable{
    ArrayList<newsArticles> list;
    Context con;
    //Constructor
    public verticalAdapter(ArrayList<newsArticles> list, Context con) {
        this.list = list;
        this.con = con;
    }

    @NonNull
    @Override
    public verticalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.newllistres,parent,false);
        return new verticalAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull verticalAdapter.ViewHolder holder, int position) {
        newsArticles articles=list.get(position);
        Picasso.get().load(articles.getUrlToImage()).into(holder.img);
        holder.heading.setText(articles.getTitle());
        holder.info.setText(articles.getDescription());

        //onclick fir the recyclerviuew
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for sending values across activity
                Intent sendNews=new Intent(con,newwsDescription.class);
                Bundle args=new Bundle();
                args.putSerializable("articles",(Serializable)list);
                sendNews.putExtra("title",articles.getTitle());
                sendNews.putExtra("description",articles.getDescription());
                sendNews.putExtra("img",articles.getUrlToImage());
                sendNews.putExtra("con",articles.getContent());
                sendNews.putExtras(args);
                con.startActivity(sendNews);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //inner class fot the adapter
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading;
        TextView info;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            info=itemView.findViewById(R.id.newsText);
            heading=itemView.findViewById(R.id.headingText);
            img=itemView.findViewById(R.id.vnewsId);
            RecyclerView recyclerView=itemView.findViewById(R.id.verticalRecycler);


        }
    }
}
