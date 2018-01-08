package com.example.ikena.sbkampus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.Serializable;

public class DestinataireActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destinataire);
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

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final EditText editText_codemandeur = (EditText) findViewById(R.id.editText_codemandeur);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DestinataireActivity.this, CategorieActivity.class);


                if(editText_codemandeur.getText().toString().equals("")){
                    intent.putExtra("DESTINATAIRE", spinner.getSelectedItem().toString());
                    intent.putExtra("CODEMANDEUR", editText_codemandeur.getText().toString());
                    startActivity(intent);
                }
                else{
                    boolean res = editText_codemandeur.getText().toString().matches("^[a-zA-Z][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
                    if(!res){
                        Toast.makeText(getApplication(), "Entrez une adresse mail valide", Toast.LENGTH_LONG).show();
                    }
                    else{
                        intent.putExtra("DESTINATAIRE", spinner.getSelectedItem().toString());
                        intent.putExtra("CODEMANDEUR", editText_codemandeur.getText().toString());
                        startActivity(intent);
                    }
                }

            }
        });
    }

}
