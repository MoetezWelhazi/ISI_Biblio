package com.example.isi_biblio.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class homeController implements Initializable {

    @FXML
    private TextField abonnésSearchField;

    @FXML
    private Button btnAbn;

    @FXML
    private Button btnBib;

    @FXML
    private Button btnEmpr;

    @FXML
    private Button btnAjouterAbn;

    @FXML
    private Button btnAjouterEmpr;

    @FXML
    private Button btnAjouterLiv;

    @FXML
    private TextField empruntSearchField;

    @FXML
    private AnchorPane homeAnchor;

    @FXML
    private TableView<?> listAbonnés;

    @FXML
    private TableView<?> listEmprunts;

    @FXML
    private TableView<?> listLivres;

    @FXML
    private TextField livresSearchField;

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


        @Override
    public void initialize(URL url, ResourceBundle resources) {
            Connect();

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
            }


        }