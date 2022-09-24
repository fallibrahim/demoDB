package com.example.demobd;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewolder> {
    Context context;
    ArrayList id_etu, nom, prenom, age;
    Activity activity;
    CustomAdapter( Activity activity, Context c, ArrayList id_etum, ArrayList nom_etum,ArrayList prenom_etu,ArrayList age_etu)
    {
        this.activity = activity;
        this.context = c;
        this.id_etu = id_etum;
        this.nom = nom_etum;
        this.prenom = prenom_etu;
        this.age = age_etu;
    }

    @NonNull
    @Override
    public MyViewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = new LayoutInflater(context);
        View v = inflater.inflate(R.layout.my_row, parent, false);
        return MyViewolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewolder holder, int position) {
      holder.id_etud.setText(String.valueOf(id_etu.get(position)));
      holder.nom_etu.setText(String.valueOf(nom.get(position)));
      holder.prenom_etu.setText(String.valueOf(prenom.get(position)));
      holder.age_etu.setText(String.valueOf(age.get(position)));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewolder {
     TextView id_etud, nom_etu, prenom_etu, age_etu;
     LinearLayout mainlayout;
    }
}
