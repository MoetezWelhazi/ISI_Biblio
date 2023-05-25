package com.example.isi_biblio.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.CheckComboBox;

import java.sql.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class homeController implements Initializable {

    @FXML
    private TableColumn<?, ?> AbonnéEmpruntsClm;

    @FXML
    private TableColumn<livreModel,String> AuteurLivreClm;

    @FXML
    private TableColumn<?, ?> DteEmprtEmpruntsClm;

    @FXML
    private TableColumn<?, ?> DteLimEmpruntsClm;

    @FXML
    private TableColumn<livreModel,String> GenreLivreClm;

    @FXML
    private TableColumn<?, ?> GroupAbonnésClm;

    @FXML
    private TableColumn<?, ?> IdAbonnésClm;

    @FXML
    private TableColumn<?, ?> IdEmpruntsClm;

    @FXML
    private TableColumn<?, ?> NPAbonnésClm;

    @FXML
    private TableColumn<livreModel, Number> QuantitéLivreClm;

    @FXML
    private TableColumn<?, ?> SpecAbonnésClm;

    @FXML
    private TableColumn<?, ?> StatusEmpruntsClm;

    @FXML
    private TableColumn<?, ?> TitreEmpruntsClm;

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
    private TableView<?> listAbonnés;

    @FXML
    private TableView<?> listEmprunts;

    @FXML
    private TableView<livreModel> listLivres;

    @FXML
    private TextField livresSearchField;

    @FXML
    private TextField modAbn;

    @FXML
    private Pane modAbonnés;

    @FXML
    private TextField modAuteur;

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
    private TextField modIdLivre;

    @FXML
    private TextField modLivre;

    @FXML
    private Pane modLivres;

    @FXML
    private TextField modNP;

    @FXML
    private TextField modQtt;

    @FXML
    private TextField modSpec;

    @FXML
    private CheckComboBox<?> modStatusCombo;

    @FXML
    private TextField modTitre;

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

        @Override
    public void initialize(URL url, ResourceBundle resources) {
            Connect();
            livretable();

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
                }
                if(actionEvent.getSource() == toggleOptionsLiv) {
                    modLivres.toBack();
                }
                if(actionEvent.getSource() == toggleOptionsEmpr) {
                    modEmprunts.toBack();
                }
            }


        }