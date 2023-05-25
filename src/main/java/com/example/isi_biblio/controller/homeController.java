package com.example.isi_biblio.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    private TextField modGenre;

    @FXML
    private ComboBox<Integer> modStatusCombo;

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
    ObservableList<empModel> emprunts;
    public void emptable()
    {
        Connect();
         emprunts = FXCollections.observableArrayList();
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

        listEmprunts.setRowFactory( tv -> {
            TableRow<empModel> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    int myIndex = listEmprunts.getSelectionModel().getSelectedIndex();
                    int id = Integer.parseInt(String.valueOf(listEmprunts.getItems().get(myIndex).getIdemp()));
                    //modIdAbn.setText(String.valueOf(id));
                    modLivre.setText(listEmprunts.getItems().get(myIndex).getTitre());
                    modAbn.setText(listEmprunts.getItems().get(myIndex).getNomPrenom());
                    modStatusCombo.setValue(listEmprunts.getItems().get(myIndex).getStatus());
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date_emp = LocalDate.parse(listEmprunts.getItems().get(myIndex).getDateEmp(), formatter);
                    modEmprDteLim.setValue(date_emp);
                    LocalDate date_limit = LocalDate.parse(listEmprunts.getItems().get(myIndex).getDateLimit(), formatter);
                    modEmprDteLim1.setValue(date_limit);


                }
            });
            return myRow;
        });
        searchemp();
    }
    ObservableList<livreModel> livres;
    public void livretable()
    {
        Connect();
        livres = FXCollections.observableArrayList();
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
        searchLivres();
        listLivres.setRowFactory( tv -> {
            TableRow<livreModel> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    int myIndex = listLivres.getSelectionModel().getSelectedIndex();
                    int id = Integer.parseInt(String.valueOf(listLivres.getItems().get(myIndex).getIdLivre()));
                    modIdLivre.setText(String.valueOf(id));
                    modTitre.setText(listLivres.getItems().get(myIndex).getTitre());
                    modAuteur.setText(listLivres.getItems().get(myIndex).getAutheur());
                    modGenre.setText(listLivres.getItems().get(myIndex).getGenre());
                    modQtt.setText(String.valueOf(listLivres.getItems().get(myIndex).getQte()));



                }
            });
            return myRow;
        });



    }
    ObservableList<abonneModel> abonnes;
    public void abonnetable()
    {
        Connect();
        abonnes = FXCollections.observableArrayList();
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
        searchAbonnes();
        listAbonnés.setRowFactory( tv -> {
            TableRow<abonneModel> myRow = new TableRow<>();
            myRow.setOnMouseClicked (event ->
            {
                if (event.getClickCount() == 1 && (!myRow.isEmpty()))
                {
                    int myIndex = listAbonnés.getSelectionModel().getSelectedIndex();
                    int id = Integer.parseInt(String.valueOf(listAbonnés.getItems().get(myIndex).getIdab()));
                    modIdAbn.setText(String.valueOf(id));
                    modNP.setText(listAbonnés.getItems().get(myIndex).getNom_prenom());
                    modSpec.setText(listAbonnés.getItems().get(myIndex).getSpeciality());
                    modGroup.setText(listAbonnés.getItems().get(myIndex).getGrp());

                }
            });
            return myRow;
        });

    }





    @Override
    public void initialize(URL url, ResourceBundle resources) {
            Connect();
            livretable();

            abonnetable();

            emptable();

            ObservableList<Integer> options =
                    FXCollections.observableArrayList(
                            0,
                            1,
                           null
                    );
            modStatusCombo.setItems(options);




        }

        public void searchLivres(){
            FilteredList<livreModel> filteredData = new FilteredList<>(livres, b -> true);

            livresSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(livre -> {
                    // If filter text is empty, display all livres.

                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }


                    String lowerCaseFilter = newValue.toLowerCase();

                    if (livre.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                        return true; // Filter matches first name.
                    } else if (livre.getAutheur().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches last name.
                    }else if (livre.getGenre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                        return true; // Filter matches last name.
                    }
                    else if (String.valueOf(livre.getIdLivre()).indexOf(lowerCaseFilter)!=-1)
                        return true;
                    else
                        return false; // Does not match.
                });
            });

            // 3. Wrap the FilteredList in a SortedList.
            SortedList<livreModel> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            // 	  Otherwise, sorting the TableView would have no effect.
            sortedData.comparatorProperty().bind(listLivres.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            listLivres.setItems(sortedData);

        }
    public void searchAbonnes(){
        FilteredList<abonneModel> filteredData = new FilteredList<>(abonnes, b -> true);

        abonnésSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(abonne -> {
                // If filter text is empty, display all livres.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }


                String lowerCaseFilter = newValue.toLowerCase();

                if (abonne.getGrp().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (abonne.getNom_prenom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (abonne.getSpeciality().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(abonne.getIdab()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<abonneModel> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(listAbonnés.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        listAbonnés.setItems(sortedData);

    }

    public void searchemp(){
        FilteredList<empModel> filteredData = new FilteredList<>(emprunts, b -> true);

        empruntSearchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(emp -> {
                // If filter text is empty, display all livres.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }


                String lowerCaseFilter = newValue.toLowerCase();

                if (emp.getNomPrenom().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (emp.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (emp.getDateLimit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }else if (String.valueOf(emp.getStatus()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else if (String.valueOf(emp.getIdemp()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<empModel> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(listEmprunts.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        listEmprunts.setItems(sortedData);

    }

    public void deleteLivre(){
        int myIndex = listLivres.getSelectionModel().getSelectedIndex();
        int id=Integer.parseInt(String.valueOf(listLivres.getItems().get(myIndex).getIdLivre()));
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("delete from livre where idlivre = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        livretable();
    }

    public void deleteabonne(){
        int myIndex = listAbonnés.getSelectionModel().getSelectedIndex();
        int id=Integer.parseInt(String.valueOf(listAbonnés.getItems().get(myIndex).getIdab()));
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("delete from abonne where idab = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        abonnetable();
    }

    public void deleteEmp(){
        int myIndex = listEmprunts.getSelectionModel().getSelectedIndex();
        int id=Integer.parseInt(String.valueOf(listEmprunts.getItems().get(myIndex).getIdemp()));
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("delete from livre where idemprunt = ? ");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        emptable();
    }
    public void updatelivre()
    {
        String ch1,ch2,ch3,ch4;
        int ch5;
        ch1=modTitre.getText();
        ch2=modAuteur.getText();
        ch3=modGenre.getText();
        ch4=modQtt.getText();
        int myIndex = listLivres.getSelectionModel().getSelectedIndex();
        ch5=Integer.parseInt(String.valueOf(listLivres.getItems().get(myIndex).getIdLivre()));
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("UPDATE livre SET titre=?,autheur=?,genre=?,quantite=? WHERE  idlivre=?");
            pst.setString(1, ch1);
            pst.setString(2, ch2);
            pst.setString(3, ch3);
            pst.setString(4, ch4);
            pst.setInt(5, ch5);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        livretable();

    }

    public void updateabonne()
    {
        String ch1,ch2,ch3,ch4;
        int ch5;
        ch1=modNP.getText();
        ch2=modSpec.getText();
        ch3=modGroup.getText();
        int myIndex = listAbonnés.getSelectionModel().getSelectedIndex();
        ch5=Integer.parseInt(String.valueOf(listAbonnés.getItems().get(myIndex).getIdab()));
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("UPDATE abonne SET nom_prenom=?,speciality=?,grp=? WHERE idab=?");
            pst.setString(1, ch1);
            pst.setString(2, ch2);
            pst.setString(3, ch3);
            pst.setInt(4, ch5);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        abonnetable();
    }


    public void updateEmp()
    {
        String ch1,ch2,ch3,ch4;
        int ch5;
        ch1=modEmprDteLim.getValue().toString();
        ch2=modEmprDteLim1.getValue().toString();
        ch3=modStatusCombo.getValue().toString();
        int myIndex = listEmprunts.getSelectionModel().getSelectedIndex();
        ch5=Integer.parseInt(String.valueOf(listEmprunts.getItems().get(myIndex).getIdemp()));
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("UPDATE emprunts SET dateemprt=?,datalimit=?,status=? WHERE idemprunt=?");
            pst.setString(1, ch1);
            pst.setString(2, ch2);
            pst.setString(3, ch3);
            pst.setInt(4, ch5);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        emptable();
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
            modLivre.clear();
            modAbn.clear();
            modEmprDteLim.getEditor().clear();
            modEmprDteLim1.getEditor().clear();
            modStatusCombo.getEditor().clear();
        }
    }


        }