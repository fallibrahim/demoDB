package com.example.demobd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
FloatingActionButton ajout_btn;
RecyclerView recyclerView;
ArrayList<String> id, nom, prenom, age;
CustomAdapter customAdapter;
BDHelper myBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBD = new BDHelper(MainActivity.this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ajout_btn = (FloatingActionButton) findViewById(R.id.ajout_btn);
        ajout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, AjouterEtudiantActivity.class);
                startActivity(intent);
            }
        });
    }
    void recuperDonnees(){
        Cursor c = myBD.getAllData();
        if(c.getCount() == 0)
        {
            Toast.makeText(this, "Pas de donnees ! ",Toast.LENGTH_LONG).show();
        }
    }

}