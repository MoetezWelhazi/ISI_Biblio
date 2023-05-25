package com.example.isi_biblio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.HiddenSidesPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {

    @FXML
    private TableColumn<?, ?> AbonnéEmpruntsClm;

    @FXML
    private TableColumn<?, ?> AuteurLivreClm;

    @FXML
    private TableColumn<?, ?> DteEmprtEmpruntsClm;

    @FXML
    private TableColumn<?, ?> DteLimEmpruntsClm;

    @FXML
    private TableColumn<?, ?> GenreLivreClm;

    @FXML
    private TableColumn<?, ?> GroupAbonnésClm;

    @FXML
    private TableColumn<?, ?> IdAbonnésClm;

    @FXML
    private TableColumn<?, ?> IdEmpruntsClm;

    @FXML
    private TableColumn<?, ?> NPAbonnésClm;

    @FXML
    private TableColumn<?, ?> QuantitéLivreClm;

    @FXML
    private TableColumn<?, ?> SpecAbonnésClm;

    @FXML
    private TableColumn<?, ?> StatusEmpruntsClm;

    @FXML
    private TableColumn<?, ?> TitreEmpruntsClm;

    @FXML
    private TableColumn<?, ?> TitreLivreClm;

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
    private TableColumn<?, ?> idLivreClm;

    @FXML
    private TableView<?> listAbonnés;

    @FXML
    private TableView<?> listEmprunts;

    @FXML
    private TableView<?> listLivres;

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
    private Spinner<?> modQtt;

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

    @Override
    public void initialize(URL url, ResourceBundle resources) {

    }

    @FXML
    public void handleBtnActions(ActionEvent actionEvent) {
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
    }


}