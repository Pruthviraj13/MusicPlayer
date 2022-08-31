package com.example.mymusic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class musicAdapter extends RecyclerView.Adapter<musicAdapter.viewHolder> {
   ArrayList<audioModel> songList;
   Context context;

    public musicAdapter(ArrayList<audioModel> songList, Context context) {
        this.songList = songList;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycle_item,parent,false);
        return new musicAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder( viewHolder holder, int position) {
        audioModel songData=songList.get(position);
        holder.titletext.setText(songData.getTitle());
        if(MyMediaPlayer.currentIndex==position){
            holder.titletext.setTextColor(Color.parseColor("#FF0000"));
        }else{
            holder.titletext.setTextColor(Color.parseColor("#000000"));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //navigate
            MyMediaPlayer.getInstance().reset();
            MyMediaPlayer.currentIndex=position;
                Intent intent=new Intent(context,MusicPlayer.class);
                intent.putExtra("LIST",songList);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView titletext;
        ImageView titleimage;

        public viewHolder( View itemView) {
            super(itemView);
            titleimage=itemView.findViewById(R.id.icon);
            titletext=itemView.findViewById(R.id.Title);
        }
    }
}
