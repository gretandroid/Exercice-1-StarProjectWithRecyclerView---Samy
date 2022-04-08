package com.example.tpandroid_recyclerview_exercice1_06_04_2022;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<TextViewHolder> {

    // Atrributes
    private String[] movies;
    private String[] ratings;

    // On récupère le contexte afin d'accéder à nos ressources dans strings.xml
    public CustomAdapter(@NonNull Context context) {
        this.movies = context.getResources().getStringArray(R.array.movies);
        this.ratings = context.getResources().getStringArray(R.array.movies);
    }

    // Créé le bon nombre de View qui correspond à la taille de notre RecyclerView dans notre activity_main.xml
    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row, parent, false);
        return new TextViewHolder(view);
    }

    // Lie les bonnes données à chaque ViewHolder correspondant
    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        // On affiche le bon texte sur le movieTextView
        holder.setMovieTextView(movies[position]);
        // On définit un OnClickListener sur chaque étoile de la ligne
        for(int i = 0; i < holder.getIcons().length; i++) {
            final int indexOfSelectedImageView = i;
            holder.getIcons()[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for(int j = 0; j < 5; j++) {
                        if(j <= indexOfSelectedImageView) {
                            // On met une étoile dorée à toutes les images à gauche de celle ou l'on clique
                            holder.getIcons()[j].setImageResource(android.R.drawable.star_big_on);
                        } else {
                            // On met une étoile non-dorée à toutes celle à droite
                            holder.getIcons()[j].setImageResource(android.R.drawable.btn_star_big_off);
                        }
                    }
                    // On affiche le bon texte sur notre ratingTextView
                    holder.setRatingTextView(ratings[indexOfSelectedImageView]);
                }
            });
        }
    }

    // Obligatoire pour fixer la limite d'item de la liste.
    @Override
    public int getItemCount() {
        return movies.length;
    }

    // Permet d'éviter les duplications de données quand on scroll, en les réinialisant quand la View est recyclée.
    @Override
    public int getItemViewType(int position) {
        return position;
    }
}