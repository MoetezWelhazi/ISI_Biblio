package com.example.isi_biblio.controller;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class livreModel {
    private SimpleIntegerProperty idLivre;
    private SimpleStringProperty titre;
    private SimpleStringProperty genre;
    private SimpleStringProperty autheur;
    private SimpleIntegerProperty qte;

    public livreModel(Integer idlivre, String titre, String autheur,String genre,Integer qte) {
        this.idLivre = new SimpleIntegerProperty(idlivre);
        this.titre = new SimpleStringProperty(titre);
        this.autheur = new SimpleStringProperty(autheur);
        this.genre = new SimpleStringProperty(genre);
        this.qte = new SimpleIntegerProperty(qte);

    }
    public int getIdLivre() {
        return idLivre.get();
    }

    public void setIdLivre(int idlivre) {
        this.idLivre = new SimpleIntegerProperty(idlivre);
    }

    public String getTitre() {
        return titre.get();
    }

    public void setTitre(String titre) {
        this.titre = new SimpleStringProperty(titre);
    }

    public String getAutheur() {
        return autheur.get();
    }

    public void setAutheur(String autheur) {
        this.autheur = new SimpleStringProperty(autheur);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String titre) {
        this.genre = new SimpleStringProperty(titre);
    }

    public int getQte() {
        return qte.get();
    }

    public void setQte(int idlivre) {
        this.qte = new SimpleIntegerProperty(idlivre);
    }
}
