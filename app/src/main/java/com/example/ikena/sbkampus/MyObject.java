package com.example.ikena.sbkampus;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ikena on 28/11/2017.
 */

class MyObject implements Parcelable{
    private String numero;
    private String destinataire;
    private String codemandeur;
    private String categorie;
    private String status;
    private String descriptif;
    private String date;


    private String scan;
    private String media;

    public MyObject(String numero, String destinataire, String categorie, String descriptif, String status) {
        this.numero = numero;
        this.destinataire = destinataire;
        this.categorie = categorie;
        this.descriptif = descriptif;
        this.status = status;
    }

    public MyObject(String numero, String destinataire, String categorie, String descriptif, String date, String scan, String media) {
        this.numero = numero;
        this.destinataire = destinataire;
        this.categorie = categorie;
        this.descriptif = descriptif;
        this.date = date;
        this.scan = scan;
        this.media = media;
    }

    public MyObject(String numero, String destinataire, String codemandeur, String categorie, String descriptif, String date, String scan, String media) {
        this.numero = numero;
        this.destinataire = destinataire;
        this.codemandeur = codemandeur;
        this.categorie = categorie;
        this.descriptif = descriptif;
        this.date = date;
        this.scan = scan;
        this.media = media;
    }

    protected MyObject(Parcel in) {
        numero = in.readString();
        destinataire = in.readString();
        codemandeur = in.readString();
        categorie = in.readString();
        status = in.readString();
        descriptif = in.readString();
        date = in.readString();
        scan = in.readString();
        media = in.readString();
    }

    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        @Override
        public MyObject createFromParcel(Parcel in) {
            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getCodemandeur() {
        return codemandeur;
    }

    public void setCodemandeur(String codemandeur) {
        this.codemandeur = codemandeur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScan() {
        return scan;
    }

    public void setScan(String scan) {
        this.scan = scan;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(numero);
        parcel.writeString(destinataire);
        parcel.writeString(codemandeur);
        parcel.writeString(categorie);
        parcel.writeString(status);
        parcel.writeString(descriptif);
        parcel.writeString(date);
        parcel.writeString(scan);
        parcel.writeString(media);
    }


    //getters & setters
}
