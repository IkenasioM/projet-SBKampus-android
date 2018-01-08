package com.example.ikena.sbkampus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class CategorieActivity extends AppCompatActivity {
    final private String[] subCat_Materiels = new String[]{
            "Ecran", "Clavier", "Souris", "Video Projecteur", "Lumière"
    };

    final private String[] subCat_Logiciels = new String[]{
            "Licences", "Bug"
    };

    private Spinner spinnerCategorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Bouton retour
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Liste déroulante des catégories
        spinnerCategorie = (Spinner) findViewById(R.id.spinnerCategorie);

        //Définition de la liste déroulante (Contenue)
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerCategorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategorie.setAdapter(adapter);

        //Action dès lors du choix de la catégorie
        spinnerCategorie.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Affichage des sous catégries
                listAction(spinnerCategorie.getSelectedItem().toString());
        }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                listAction("Materiels");
            }
        });

    }

    //Affichage des sous catégories
    public void listAction(String param){
        final ListView listCategorie = (ListView) findViewById(R.id.listSubcategorie);

        if (param.equals("Matériels")){
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(CategorieActivity.this,
                    android.R.layout.simple_list_item_1, subCat_Materiels);
            listCategorie.setAdapter(adapter);
        }

        if (param.equals("Logiciels")){
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(CategorieActivity.this,
                    android.R.layout.simple_list_item_1, subCat_Logiciels);
            listCategorie.setAdapter(adapter);
        }

        listCategorie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = getIntent();
                String codemandeur = intent.getStringExtra("CODEMANDEUR");
                String destinataire = intent.getStringExtra("DESTINATAIRE");

                String categorie = spinnerCategorie.getSelectedItem().toString();
                categorie += " - " + listCategorie.getItemAtPosition(i).toString();

                Intent descriptif = new Intent(CategorieActivity.this, DescriptifActivity.class);

                descriptif.putExtra("CATEGORIE", categorie);
                descriptif.putExtra("CODEMANDEUR", codemandeur);
                descriptif.putExtra("DESTINATAIRE", destinataire);

                Toast.makeText(getApplicationContext(), categorie, Toast.LENGTH_SHORT).show();

                startActivity(descriptif);
            }
        });
    }
}
