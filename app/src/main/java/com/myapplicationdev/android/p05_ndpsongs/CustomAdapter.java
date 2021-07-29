package com.myapplicationdev.android.p05_ndpsongs;

import android.content.Context;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context context;
    int resource;
    ArrayList<Song> al;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Song> al) {
        super(context, resource, al);

        this.context = context;
        this.resource = resource;
        this.al = al;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        TextView tvpurple = rowView.findViewById(R.id.Title);
        TextView tvplain = rowView.findViewById(R.id.year);
        TextView tvblue = rowView.findViewById(R.id.singer);
        ImageView imageView = rowView.findViewById(R.id.imageView3);
        RatingBar ratingBar = rowView.findViewById(R.id.ratingBar);


        Song currentSong = al.get(position);

        tvpurple.setText(currentSong.getTitle());
        tvplain.setText(currentSong.getYearReleased() + "");
        tvblue.setText(currentSong.getSingers());
        ratingBar.setRating(currentSong.getStars());

        if(currentSong.getYearReleased() >= 2019){
            imageView.setImageResource(R.drawable.ps);
        }
        else{
            imageView.setVisibility(View.INVISIBLE);
        }

        return rowView;

    }
}
