package com.example.ikena.sbkampus;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ikena on 28/11/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder{

    private TextView numero;
    private TextView destinataire;
    private TextView categorie;
    private TextView descriptif;
    private ImageView imageView_status;


    //itemView est la vue correspondante à 1 cellule
    public MyViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView

        numero = (TextView) itemView.findViewById(R.id.title);
        destinataire = (TextView) itemView.findViewById(R.id.destinataire);
        categorie = (TextView) itemView.findViewById(R.id.categorie);
        descriptif = (TextView) itemView.findViewById(R.id.description);
        imageView_status = (ImageView) itemView.findViewById(R.id.imageView_status);

    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(MyObject myObject){
        numero.setText("Demande de travaux : #" + myObject.getNumero());
        destinataire.setText("Destinataire : " + myObject.getDestinataire());
        categorie.setText("Catégorie : " + myObject.getCategorie());
        descriptif.setText("Description : \n" + myObject.getDescriptif());

        if(myObject.getStatus().equals("Prise en charge")){
            imageView_status.setImageResource(R.drawable.status_rouge);
        }
        if(myObject.getStatus().equals("En cours")){
            imageView_status.setImageResource(R.drawable.status_orange);
        }
        if(myObject.getStatus().equals("Resolue")){
            imageView_status.setImageResource(R.drawable.status_green);
        }
    }
}