package com.example.tpandroid_recyclerview_exercice1_06_04_2022;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TextViewHolder extends RecyclerView.ViewHolder {

    // Attributes
    private TextView movieTextView, ratingTextView;
    private ImageView[] icons;

    // Getters
    public ImageView[] getIcons() {
        return icons;
    }

    // Setters
    public void setMovieTextView(String string) {
        this.movieTextView.setText(string);
    }
    public void setRatingTextView(String string) {
        this.ratingTextView.setText(string);
    }

    // Constructor
    public TextViewHolder(@NonNull View parent) {
        super(parent);

        // On récupère tout nos UI components depuis row.xml
        movieTextView = parent.findViewById(R.id.movieTextView);
        ratingTextView = parent.findViewById(R.id.ratingTextView);
        icons = new ImageView[]{
                parent.findViewById(R.id.icon1),
                parent.findViewById(R.id.icon2),
                parent.findViewById(R.id.icon3),
                parent.findViewById(R.id.icon4),
                parent.findViewById(R.id.icon5)
        };
    }
}