package com.example.tpandroid_recyclerview_exercice1_06_04_2022;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère notre RecyclerView depuis activity_main.xml
        recyclerView = findViewById(R.id.recyclerview);
        // On lui définit un LayoutManager, obligatoire pour savoir comment sont organisés ses items.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // On instancie notre CustomAdapter
        customAdapter = new CustomAdapter(this);
        // on affecte notre CustomAdapater à notre RecyclerView
        recyclerView.setAdapter(customAdapter);
    }
}