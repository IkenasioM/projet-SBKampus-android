package com.example.ikena.sbkampus;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DescriptifActivity extends AppCompatActivity {
    private EditText editText_description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descriptif);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        editText_description = (EditText) findViewById(R.id.editText_desciption);

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String codemandeur = intent.getStringExtra("CODEMANDEUR");
                String destinataire = intent.getStringExtra("DESTINATAIRE");
                String categorie = intent.getStringExtra("CATEGORIE");

                Intent scan = new Intent(DescriptifActivity.this, ScanActivity.class);

                String date = getValueDate();

                scan.putExtra("CODEMANDEUR", codemandeur);
                scan.putExtra("DESTINATAIRE", destinataire);
                scan.putExtra("CATEGORIE", categorie);
                scan.putExtra("DESCRIPTIF", editText_description.getText().toString());
                scan.putExtra("DATE", date);

                startActivity(scan);
            }
        });
    }

    //Paramètre DatePicker pour mettre la date d'aujourd'hui
    public void setCurrentDateOnView() {
        final DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);

        //Récupère la date d'aujourd'hui
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // change la date du Datepicker à celle d'aujourd'hui
        datePicker.init(year, month, day, null);

    }

    public String getValueDate(){
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date(datePicker.getYear()-1900,datePicker.getMonth(),datePicker.getDayOfMonth()));
        return date;
    }
}
