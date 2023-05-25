package com.example.isi_biblio.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class empModel {
    private SimpleIntegerProperty idemp;
    private SimpleStringProperty titre;
    private SimpleStringProperty nom_prenom;
    private SimpleStringProperty dateEmp;
    private SimpleStringProperty dateLimit;
    private SimpleIntegerProperty status;

    public  empModel(Integer idemp,String titre,String nom_prenom,String dateEmp,String dateLimit,Integer status){
        this.nom_prenom = new SimpleStringProperty(nom_prenom);
        this.titre = new SimpleStringProperty(titre);
        this.dateEmp=new SimpleStringProperty(dateEmp);
        this.dateLimit= new SimpleStringProperty(dateLimit);
        this.idemp=new SimpleIntegerProperty(idemp);
        this.status=new SimpleIntegerProperty(status);

    }
    public IntegerProperty idempProperty() { return idemp; }
    public void setIdemp(int idemp) {
        this.idemp= new SimpleIntegerProperty(idemp);
    }
    public StringProperty titreProperty() { return titre; }
    public void setTitre(String titre) {
        this.titre= new SimpleStringProperty(titre);
    }
    public StringProperty nom_prenom_Property() { return nom_prenom; }
    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom= new SimpleStringProperty(nom_prenom);
    }
    public StringProperty dateemp_Property() { return dateEmp; }
    public void setDateEmp(String dateEmp) {
        this.dateEmp = new SimpleStringProperty(dateEmp);
    }
    public StringProperty datelimit_Property() { return dateLimit; }
    public void setDateLimit(String dateLimit) {
        this.dateLimit = new SimpleStringProperty(dateLimit);
    }
    public IntegerProperty statusProperty() { return status; }
    public void setStatus(int status) {
        this.status= new SimpleIntegerProperty(status);
    }
    public int getIdemp() {return idemp.get();}
    public String getTitre() {
        return titre.get();
    }
    public String getNomPrenom() {
        return nom_prenom.get();
    }
    public SimpleStringProperty getDateEmp() {
       return dateEmp;

    }
    public SimpleStringProperty getDateLimit() {
        return dateLimit;
    }
    public int getStatus() {return status.get();}
}

