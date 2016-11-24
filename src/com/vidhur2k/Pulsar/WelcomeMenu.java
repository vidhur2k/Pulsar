package com.vidhur2k.Pulsar;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image ;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.Vector;

/**
 * Created by vidhur2k on 9/9/16.
 */
public class WelcomeMenu extends Application{

    public static void main(String[] args) {

        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Sets the skeleton of the User interface for com.vidhur2k.Pulsar.Pulsar.
        primaryStage.setTitle("Pulsar");
        primaryStage.setHeight(700);
        primaryStage.setWidth(700);


        final Group rootGroup = new Group();
        final Scene scene = new Scene(rootGroup, 700, 700, Color.AQUAMARINE);

        // Welcome message.
        final Text welcomeText = new Text(140, 175, "WELCOME TO PULSAR!");
        welcomeText.setFill(Color.CRIMSON);
        welcomeText.setFont(new Font("SERIF", 36));
        rootGroup.getChildren().add(welcomeText);

        // Incorporates supplementary welcome text on the home screen.
        final Vector<Text> supplementaryWelcomeText = new Vector<Text>();
        Collections.addAll(supplementaryWelcomeText,
                new Text(110, 250, "The Optimum Calculator for"),
                new Text(270, 320, "Physics!"));


        // Loops through each element of the Vector and sets the Font, Font Size, and Color respectively.
        supplementaryWelcomeText.forEach(x -> x.setFont(new Font("SERIF", 36)));
        supplementaryWelcomeText.forEach(x -> x.setFill(Color.PURPLE));


        // Adds each element of the Vector to the Group object.
        supplementaryWelcomeText.forEach(rootGroup.getChildren() :: add);


        // Publisher information at the bottom of the screen.
        final Text ownershipWaterMark = new Text(445, 665, "Published by L.A.M.A.R Inc.");
        ownershipWaterMark.setFill(Color.BLACK);
        ownershipWaterMark.setFont(new Font("Arial", 18));
        rootGroup.getChildren().add(ownershipWaterMark);

//
//        GridPane gridpane = new GridPane();
//        gridpane.setHgap(10);
//        gridpane.setVgap(10);
//        gridpane.setPadding(new Insets(10, 10, 10, 10));
//
//        // Home Screen Image for the Greek letter Tau.
//        final ImageView imv = new ImageView();
//        final Image tauImage = new Image(Pulsar.class.getResourceAsStream("src/com/vidhur2k/Pulsar/tau.png"));
//        imv.setImage(tauImage);
//        imv.setFitHeight(100);
//        imv.setFitWidth(100);
//
//        final HBox tauPosition = new HBox();
//        tauPosition.getChildren().add(imv);
//        gridpane.add(tauPosition, 1, 1);
//
//        // Home Screen Image of the Magnetic Flux equation.
//        final ImageView imv2 = new ImageView();
//        final Image magFluxImage = new Image(Pulsar.class.getResourceAsStream("src/com/vidhur2k/Pulsar/MagFlux.jpg"));
//        imv2.setImage(magFluxImage);
//        imv2.setFitHeight(100);
//        imv2.setFitWidth(100);
//
//        final HBox magFluxPosition = new HBox();
//        magFluxPosition.getChildren().add(imv2);
//        gridpane.add(magFluxPosition, 35, 40);
//
//        // Home Screen Image of the Inclined Surface.
//        final ImageView imv3 = new ImageView();
//        final Image inSurfImage = new Image(Pulsar.class.getResourceAsStream("src/com/vidhur2k/Pulsar/insurf.png"));
//        imv3.setImage(inSurfImage);
//        imv3.setFitHeight(100);
//        imv3.setFitWidth(100);
//
//        final HBox inSurfPosition = new HBox();
//        inSurfPosition.getChildren().add(imv3);
//        gridpane.add(inSurfPosition, 2, 40);
//
//        rootGroup.getChildren().add(gridpane);


        final Button continueButton = new Button();
        continueButton.setText("Click to Continue!");
        continueButton.setFont(new Font("Times New Roman", 18));
        continueButton.setLayoutX(255);
        continueButton.setLayoutY(400);

        rootGroup.getChildren().add(continueButton);
        primaryStage.setScene(scene);
        primaryStage.show();

        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = new Stage();
                stage.setTitle("com.vidhur2k.Pulsar.Pulsar- Introduction");
                Group rootGroup = new Group();
                Scene scene = new Scene(rootGroup, 700, 700, Color.AQUAMARINE);
                IntroMenu.initIntroMenu(stage, rootGroup, scene);
                primaryStage.close();
                IntroMenu.initIntroMenu(stage, rootGroup, scene);
            }
        });
    }
}

