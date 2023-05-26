module com.example.isi_biblio {
    requires javafx.controls;
    requires javafx.fxml;
    requires animateFX;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.controlsfx.controls;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.isi_biblio to javafx.fxml;
    opens com.example.isi_biblio.controller to javafx.fxml;
    exports com.example.isi_biblio;
}