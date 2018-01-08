package com.example.ikena.sbkampus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class ScanActivity extends AppCompatActivity {
    ImageView imgScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
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

        Button btnScan = (Button) findViewById(R.id.button_scan);
        Button btnNext = (Button) findViewById(R.id.next);
        imgScan = (ImageView) findViewById(R.id.imageView_Scan);

        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent scanner =  new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(scanner,0);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();

                String codemandeur = intent.getStringExtra("CODEMANDEUR");
                String destinataire = intent.getStringExtra("DESTINATAIRE");
                String categorie = intent.getStringExtra("CATEGORIE");
                String descriptif = intent.getStringExtra("DESCRIPTIF");
                String date = intent.getStringExtra("DATE");

                Intent recap = new Intent(getApplicationContext(), RecapitulatifActivity.class);

                recap.putExtra("CODEMANDEUR", codemandeur);
                recap.putExtra("DESTINATAIRE", destinataire);
                recap.putExtra("CATEGORIE", categorie);
                recap.putExtra("DESCRIPTIF", descriptif);
                recap.putExtra("DATE", date);

                startActivity(recap);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        imgScan.setImageBitmap(bitmap);
    }
}
