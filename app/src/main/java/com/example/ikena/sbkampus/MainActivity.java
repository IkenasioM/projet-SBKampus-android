package com.example.ikena.sbkampus;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button createDT;
    private List<MyObject> DemandeTravaux = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Charge les DT
        load();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        createDT = (Button) findViewById(R.id.createDemande);


        //Charge les cards et adapte les informations
        //Information injecter dans MyViewHolder.class
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(DemandeTravaux));

        //Bouton pour une nouvelle demande de travaux
        createDT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DestinataireActivity.class);
                startActivity(intent);
            }
        });
    }

    public void load(){
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.data);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()){
            builder.append(scanner.nextLine());
        }
        ajoutDT(builder.toString());
    }

    private void ajoutDT(String s) {

        StringBuilder builder = new StringBuilder();

        try {
            JSONObject root = new JSONObject(s);
            JSONArray demandeTravaux = root.getJSONArray("DemandeTravaux");
            final int end = demandeTravaux.length();
            for(int i = 0; i < demandeTravaux.length(); i++){
                JSONObject DT = demandeTravaux.getJSONObject(i);
                DemandeTravaux.add(new MyObject(
                        DT.getString("numero"),
                        DT.getString("destinataire"),
                        DT.getString("categorie"),
                        DT.getString("descriptif"),
                        DT.getString("status")
                ));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
