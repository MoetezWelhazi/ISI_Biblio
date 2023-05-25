package com.example.isi_biblio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("fxml/Home.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/home.fxml"));
        //Parent root = fxmlLoader.getRoot();
        primaryStage.setScene(new Scene(fxmlLoader.load()));
        primaryStage.setTitle("ISI Biblio");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("icons/DGU(v2)_Logo_Dark_NoBG.png")));
        primaryStage.show();
    }

    //you can download the glyph browser - link provided.
    public static void main(String[] args) {
        launch(args);
    }
}
