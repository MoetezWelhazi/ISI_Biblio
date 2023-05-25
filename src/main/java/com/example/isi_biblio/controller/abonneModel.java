package com.example.isi_biblio.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
public class abonneModel {
    private SimpleIntegerProperty idab;
    private SimpleStringProperty nom_prenom;
    private SimpleStringProperty speciality;
    private SimpleStringProperty grp;

    public IntegerProperty idabProperty() {
        return idab;
    }

    public StringProperty nom_prenomProperty() {
        return nom_prenom;
    }

    public StringProperty specialityProperty() {
        return speciality;
    }

    public StringProperty grpProperty() {
        return grp;
    }

    public abonneModel(Integer idab, String nom_prenom, String speciality, String grp) {
        this.idab = new SimpleIntegerProperty(idab);
        this.nom_prenom = new SimpleStringProperty(nom_prenom);
        this.speciality = new SimpleStringProperty(speciality);
        this.grp = new SimpleStringProperty(grp);

    }
    public int getIdab() {
        return idab.get();
    }

    public String getNom_prenom() {
        return nom_prenom.get();
    }


    public String getSpeciality() {
        return speciality.get();
    }


    public String getGrp() {
        return grp.get();
    }
    public void setIdab(int idab) {
        this.idab = new SimpleIntegerProperty(idab);
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = new SimpleStringProperty(nom_prenom);
    }
    public void setSpeciality(String speciality) {
        this.speciality = new SimpleStringProperty(speciality);
    }

    public void setGrp(String grp) {
        this.grp = new SimpleStringProperty(grp);
    }

}
