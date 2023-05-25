package com.example.isi_biblio.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homeController implements Initializable {

    @FXML
    private TableColumn<empModel, String> AbonnéEmpruntsClm;

    @FXML
    private TableColumn<livreModel,String> AuteurLivreClm;

    @FXML
    private TableColumn<empModel, String> DteEmprtEmpruntsClm;

    @FXML
    private TableColumn<empModel, String> DteLimEmpruntsClm;

    @FXML
    private TableColumn<livreModel,String> GenreLivreClm;

    @FXML
    private TableColumn<abonneModel, String> GroupAbonnésClm;

    @FXML
    private TableColumn<abonneModel, Number> IdAbonnésClm;

    @FXML
    private TableColumn<empModel, Number> IdEmpruntsClm;

    @FXML
    private TableColumn<abonneModel, String> NPAbonnésClm;

    @FXML
    private TableColumn<livreModel, Number> QuantitéLivreClm;

    @FXML
    private TableColumn<abonneModel, String> SpecAbonnésClm;

    @FXML
    private TableColumn<empModel, Number> StatusEmpruntsClm;

    @FXML
    private TableColumn<empModel, String> TitreEmpruntsClm;

    @FXML
    private TableColumn<livreModel,String> TitreLivreClm;

    @FXML
    private TextField abonnésSearchField;

    @FXML
    private Button addAbonnés;

    @FXML
    private Button addEmprunt;

    @FXML
    private Button addLivre;

    @FXML
    private Button btnAbn;

    @FXML
    private Button btnBib;

    @FXML
    private Button btnEmpr;

    @FXML
    private TextField empruntSearchField;

    @FXML
    private AnchorPane homeAnchor;

    @FXML
    private TableColumn<livreModel, Number> idLivreClm;

    @FXML
    private TableView<abonneModel> listAbonnés;

    @FXML
    private TableView<empModel> listEmprunts;

    @FXML
    private TableView<livreModel> listLivres;

    @FXML
    private TextField livresSearchField;

    @FXML
    private TextField modAbn;

    @FXML
    private Pane modAbonnés;

    @FXML
    private TextField modAuteur; //BILEL

    @FXML
    private DatePicker modEmprDteLim;

    @FXML
    private DatePicker modEmprDteLim1;

    @FXML
    private Pane modEmprunts;

    @FXML
    private TextField modGroup;

    @FXML
    private TextField modIdAbn;

    @FXML
    private TextField modIdLivre; //BILEL

    @FXML
    private TextField modLivre;

    @FXML
    private Pane modLivres;

    @FXML
    private TextField modNP;

    @FXML
    private TextField modQtt; //BILEL

    @FXML
    private TextField modSpec;

    @FXML
    private TextField modGenre; //BILEL

    @FXML
    private ComboBox<Integer> modStatusCombo;

    @FXML
    private TextField modTitre; //BILEL

    @FXML
    private Button optionsAbonnés;

    @FXML
    private Button optionsEmprunts;

    @FXML
    private Button optionsLivres;

    @FXML
    private Pane paneAbonnés;

    @FXML
    private Pane paneEmprunts;

    @FXML
    private Pane paneLivres;

    Connection con;

    public void Connect()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/biblio","root","");
        }
        catch (ClassNotFoundException ex) {
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private Button supAbonnés;

    @FXML
    private Button supLivre;

    @FXML
    private Button toggleOptionsAbn;

    @FXML
    private Button toggleOptionsEmpr;

    @FXML
    private Button toggleOptionsLiv;

    @FXML
    private Button updAbonnés;

    @FXML
    private Button updEmprunt;

    @FXML
    private Button updLivre;

    public void emptable()
    {
        Connect();
        ObservableList<empModel> emprunts = FXCollections.observableArrayList();
        try
        {
            PreparedStatement pst = con.prepareStatement("SELECT idemprunt,titre,nom_prenom,dateemprt,datalimit,status FROM emprunts,abonne,livre WHERE emprunts.idlivre=livre.idlivre AND emprunts.idab=abonne.idab;");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    int id_emp = Integer.parseInt(rs.getString("idemprunt"));
                    String titre=rs.getString("titre");
                    String abonnee=rs.getString("nom_prenom");
                    String dateemprt=rs.getString("dateemprt");
                    String datelimit=rs.getString("datalimit");
                    int status=Integer.parseInt(rs.getString("status"));
                    empModel ep = new empModel(id_emp,titre,abonnee,dateemprt,datelimit,status);
                    emprunts.add(ep);
                }
            }
            listEmprunts.setItems(emprunts);
            IdEmpruntsClm .setCellValueFactory(f -> f.getValue().idempProperty());
            TitreEmpruntsClm.setCellValueFactory(f -> f.getValue().titreProperty());
            AbonnéEmpruntsClm.setCellValueFactory(f -> f.getValue().nom_prenom_Property());
            DteEmprtEmpruntsClm.setCellValueFactory(f -> f.getValue().dateemp_Property());
            DteLimEmpruntsClm.setCellValueFactory(f -> f.getValue().datelimit_Property());
            StatusEmpruntsClm.setCellValueFactory(f -> f.getValue().statusProperty());
        }

        catch (SQLException ex)
        {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void livretable()
    {
        Connect();
        ObservableList<livreModel> livres = FXCollections.observableArrayList();
        try
        {
            PreparedStatement pst = con.prepareStatement("select idlivre,titre,autheur,genre,quantite from livre");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    int id_liv = Integer.parseInt(rs.getString("idlivre"));
                    String titre=rs.getString("titre");
                    String autheur=rs.getString("autheur");
                    String genre=rs.getString("genre");
                    int qte=Integer.parseInt(rs.getString("quantite"));
                    livreModel lv = new livreModel(id_liv,titre,autheur,genre,qte);
                    livres.add(lv);
                }
            }
            listLivres.setItems(livres);
            idLivreClm.setCellValueFactory(f -> f.getValue().idlivreProperty());
            TitreLivreClm.setCellValueFactory(f -> f.getValue().titreProperty());
            AuteurLivreClm.setCellValueFactory(f -> f.getValue().autheurProperty());
            GenreLivreClm.setCellValueFactory(f -> f.getValue().genreProperty());
            QuantitéLivreClm.setCellValueFactory(f -> f.getValue().qteProperty());
        }

        catch (SQLException ex)
        {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;


    }

    public void abonnetable()
    {
        Connect();
        ObservableList<abonneModel> abonnes = FXCollections.observableArrayList();
        try
        {
            PreparedStatement pst = con.prepareStatement("select idab,nom_prenom,speciality,grp from abonne");
            ResultSet rs = pst.executeQuery();
            {
                while (rs.next())
                {
                    int idab = Integer.parseInt(rs.getString("idab"));
                    String nom_prenom=rs.getString("nom_prenom");
                    String speciality=rs.getString("speciality");
                    String grp=rs.getString("grp");
                    abonneModel ab = new abonneModel(idab,nom_prenom,speciality,grp);
                    abonnes.add(ab);
                }
            }
            listAbonnés.setItems(abonnes);
            IdAbonnésClm.setCellValueFactory(f -> f.getValue().idabProperty());
            NPAbonnésClm.setCellValueFactory(f -> f.getValue().nom_prenomProperty());
            SpecAbonnésClm.setCellValueFactory(f -> f.getValue().specialityProperty());
            GroupAbonnésClm.setCellValueFactory(f -> f.getValue().grpProperty());




        }

        catch (SQLException ex)
        {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ;


    }

        @Override
    public void initialize(URL url, ResourceBundle resources) {
            Connect();
            livretable();
            abonnetable();
            ObservableList<Integer> options =
                    FXCollections.observableArrayList(
                            0,
                            1,
                           null
                    );
            modStatusCombo.setItems(options);


        }

    @FXML
    public void handleBtnActions (ActionEvent actionEvent){
        if (actionEvent.getSource() == btnBib) {
            paneLivres.toFront();
        }
        if (actionEvent.getSource() == btnAbn) {
            paneAbonnés.toFront();
        }
        if (actionEvent.getSource() == btnEmpr) {
            //pnlOverview.setStyle("-fx-background-color : #02030A");
            paneEmprunts.toFront();
            emptable();
        }
        if(actionEvent.getSource() == optionsAbonnés) {
            modAbonnés.toFront();
        }
        if(actionEvent.getSource() == optionsLivres) {
            modLivres.toFront();
        }
        if(actionEvent.getSource() == optionsEmprunts) {
            modEmprunts.toFront();
        }
        if(actionEvent.getSource() == toggleOptionsAbn) {
            modAbonnés.toBack();
            modIdAbn.clear();
            modNP.clear();
            modSpec.clear();
            modGroup.clear();
        }
        if(actionEvent.getSource() == toggleOptionsLiv) {
            modLivres.toBack();
            modIdLivre.clear();
            modTitre.clear();
            modAuteur.clear();
            modGenre.clear();
            modQtt.clear();
        }
        if(actionEvent.getSource() == toggleOptionsEmpr) {
            modEmprunts.toBack();
            modIdLivre.clear();
            modIdAbn.clear();
            modEmprDteLim.getEditor().clear();
            modEmprDteLim1.getEditor().clear();
            modStatusCombo.getEditor().clear();
        }
    }


        }