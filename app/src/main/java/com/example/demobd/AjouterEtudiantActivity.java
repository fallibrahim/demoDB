package com.example.demobd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AjouterEtudiantActivity extends AppCompatActivity {
    EditText nom, prenom, age;
    Button ajout_btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_etudiant);
        //instanciation des champs de saisie
        nom = (EditText) findViewById(R.id.idNom);
        prenom = (EditText) findViewById(R.id.idPrenom);
        age = (EditText) findViewById(R.id.idAge);
        //instanciation du button ajouter
        ajout_btnn = (Button) findViewById(R.id.ajout_btnn);
        ajout_btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BDHelper myBdHelper = new BDHelper(AjouterEtudiantActivity.this);
                String nomValues = nom.getText().toString().trim();
                String prenomValues = prenom.getText().toString().trim();
                 int ageValues = Integer.valueOf(age.getText().toString().trim());
                 myBdHelper.ajoutEtudiant(nomValues,prenomValues,ageValues);
            }
        });
    }
}