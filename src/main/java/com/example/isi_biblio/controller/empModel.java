package com.example.isi_biblio.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class empModel {
    private SimpleIntegerProperty idemp;
    private SimpleIntegerProperty idLivre;
    private SimpleIntegerProperty idab;
    private SimpleStringProperty dateEmp;
    private SimpleStringProperty dateLimit;

    public  empModel(Integer idemp,Integer idlivre,Integer idab,String dateEmp,String dateLimit){
        this.idab = new SimpleIntegerProperty(idab);
        this.idLivre = new SimpleIntegerProperty(idlivre);
        this.dateEmp=new SimpleStringProperty(dateEmp);
        this.dateLimit= new SimpleStringProperty(dateLimit);
        this.idemp=new SimpleIntegerProperty(idemp);

    }

    public int getIdemp() {
        return idemp.get();
    }

    public void setIdemp(int idemp) {
        this.idemp= new SimpleIntegerProperty(idemp);
    }

    public void setIdLivre(int idLivre) {
        this.idLivre= new SimpleIntegerProperty(idLivre);
    }

    public void setIdab(int idab) {
        this.idab= new SimpleIntegerProperty(idab);
    }

    public void setDateEmp(String dateEmp) {
        this.dateEmp = new SimpleStringProperty(dateEmp);
    }

    public void setDateLimit(String dateLimit) {
        this.dateLimit = new SimpleStringProperty(dateLimit);
    }

    public int getIdLivre() {
        return idLivre.get();
    }



    public int getIdab() {
        return idab.get();
    }




    public String getDateEmp() {
        return dateEmp.get();
    }



    public String getDateLimit() {
        return dateLimit.get();
    }


}

