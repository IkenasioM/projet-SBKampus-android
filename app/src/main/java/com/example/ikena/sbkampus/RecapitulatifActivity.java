package com.example.ikena.sbkampus;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RecapitulatifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapitulatif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recap_tab();

        Button send = (Button) findViewById(R.id.button_valider);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RecapitulatifActivity.this);
                builder.setMessage("Êtes-vous sûre d'envoyer la demande ?").setTitle("Confirmation d'envoie");
                builder.setCancelable(true)
                        .setPositiveButton("Oui", new OkOnCLickListener())
                        .setNegativeButton("Non", new NoOnClickListener());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void recap_tab(){
        Intent intent = getIntent();
        String codemandeur = intent.getStringExtra("CODEMANDEUR");
        String destinataire = intent.getStringExtra("DESTINATAIRE");
        String categorie = intent.getStringExtra("CATEGORIE");
        String descriptif = intent.getStringExtra("DESCRIPTIF");
        String date = intent.getStringExtra("DATE");

        TextView textView_destinataire = (TextView) findViewById(R.id.destinataire_recap);
        TextView textView_codemandeur = (TextView) findViewById(R.id.codemandeur_recap);
        TextView textView_categorie = (TextView) findViewById(R.id.categorie_recap);
        TextView textView_date = (TextView) findViewById(R.id.date_recap);
        TextView textView_description = (TextView) findViewById(R.id.descirptif_recap);

        textView_destinataire.setText(destinataire);
        textView_codemandeur.setText(codemandeur);
        textView_categorie.setText(categorie);
        textView_date.setText(date);
        textView_description.setText(descriptif);
    }

    private final class OkOnCLickListener implements
      DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "Oui",
                    Toast.LENGTH_LONG).show();
        }
    }

    private final class NoOnClickListener implements
      DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getApplicationContext(), "Non",
                    Toast.LENGTH_LONG).show();
        }
    }
}
