package com.vidhur2k.Pulsar.topics;

import com.vidhur2k.Pulsar.calculations.N2LQuantityCalculations;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vidhur2k on 9/17/16.
 */
public class NewtonsSecondLaw {

    public static void initNewtonsSecondLaw(Stage stage, Group rootGroup, Scene scene)
    {
        stage.setTitle("com.vidhur2k.Pulsar.Pulsar- Newton's 2nd Law");

        /**
         * ArrayList contains the background information for Newton's 2nd Law.
         */
        final List<Text> backgroundInfo = new ArrayList<>();

        Collections.addAll(backgroundInfo,
                            new Text(9, 17, "Newton's 2nd Law states that: The acceleration acting on a body is proportional to"),
                            new Text(9, 34, "the force and inversely proportional to the mass of the object."));

        backgroundInfo.forEach(x -> x.setFont(new Font("SERIF", 16)));
        backgroundInfo.forEach(x -> x.setFill(Color.DEEPPINK));
        backgroundInfo.forEach(rootGroup.getChildren() :: add);


        /**
         * ArrayList contains the formula for Newton's 2nd Law.
         */
        final List<Text> formulaInfo = new ArrayList<>();

        Collections.addAll(formulaInfo,
                new Text(9, 90, "FORMULA:"),
                new Text(300, 90, "F = ma"));



        formulaInfo.forEach(x -> x.setFont(new Font("SERIF", 36)));
        formulaInfo.forEach(x -> x.setFill(Color.RED));
        formulaInfo.forEach(rootGroup.getChildren() :: add);


        /**
         * ArrayList contains Labels for the units of the quantity.
         */
        final List<Label> unitLabels = new ArrayList<>();
        Collections.addAll(unitLabels,
                            new Label("kg"),
                            new Label("m / s^2"),
                            new Label("N"));

        unitLabels.forEach(x -> x.setFont(new Font("SERIF", 20)));
        unitLabels.forEach(x -> x.setLayoutX(475));
        int yBuffer2 = 150;
        for (Label l : unitLabels)
            l.setLayoutY(yBuffer2 += 100);

        unitLabels.forEach(rootGroup.getChildren() :: add);


        /**
         * ArrayList contains Labels for the Quantities.
         */
        final List<Label> quantityLabels = new ArrayList<>();
        Collections.addAll(quantityLabels,
                            new Label("MASS: "),
                            new Label("ACCELERATION: "),
                            new Label("FORCE: "));

        quantityLabels.forEach(x -> x.setFont(new Font("SERIF", 18)));
        quantityLabels.forEach(x -> x.setLayoutX(10));
        quantityLabels.forEach(rootGroup.getChildren() :: add);

        int quantityLabelYBuffer = 150;
        for (Label l : quantityLabels)
            l.setLayoutY(quantityLabelYBuffer += 100);


        /**
         * Created for the TextFields.
         */
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setAlignment(Pos.CENTER);

        /**
         * Takes in the input for TWO out of the three quantities.
         */
        final List<TextField> quantityInputs = new ArrayList<>();

        for(int i = 0; i < 3; i++)
            quantityInputs.add(new TextField());

        int quantityInputYBuffer = 17;
        for (TextField t : quantityInputs)
            pane.add(t, 20, quantityInputYBuffer += 7);

        rootGroup.getChildren().add(pane);


        final Button calculateButton = new Button("CALCULATE");
        calculateButton.setLayoutX(300);
        calculateButton.setLayoutY(550);

        rootGroup.getChildren().add(calculateButton);

        calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                    TextField mass = quantityInputs.get(0);
                    TextField acceleration = quantityInputs.get(1);
                    TextField force = quantityInputs.get(2);

                double m, a, f;



                // TODO Figure out a way to handle the exceptions using try catch or compareTo().

                // Exception handling.
                if(quantityInputs.stream().filter(x -> x.getText().length() == 0).collect(Collectors.toList()).size() == 0)
                {
                    Alert inputError = new Alert(Alert.AlertType.ERROR);
                    inputError.setTitle("Error Dialog");
                    inputError.setHeaderText("Input Error");
                    inputError.setContentText("Please leave one value blank to calculate!");
                    inputError.showAndWait();
                    initNewtonsSecondLaw(stage, rootGroup, scene);
                }

                // Exception Handling 2
                if(quantityInputs.stream().filter(x -> x.getText().length() != 0).collect(Collectors.toList()).size() == 0)
                {
                    Alert inputError = new Alert(Alert.AlertType.ERROR);
                    inputError.setTitle("Error Dialog");
                    inputError.setHeaderText("Input Error");
                    inputError.setContentText("Please enter values!");
                    inputError.showAndWait();
                    initNewtonsSecondLaw(stage, rootGroup, scene);
                }

                // CASE 1: Calculate the Mass given the Force and the Acceleration.
                if(mass.getText().length() == 0)
                    if(acceleration.getText().length() > 0 && force.getText().length() > 0)
                    {
                        a = Double.parseDouble(acceleration.getText());
                        f = Double.parseDouble(force.getText());

                        mass.setText(N2LQuantityCalculations.calcMass(f, a) + "");
                        mass.setEditable(false);
                    }

                // CASE 2: Calculate the Acceleration given the Force and the Mass.
                if(acceleration.getText().length() == 0)
                    if(mass.getText().length() > 0 && force.getText().length() > 0)
                    {
                        m = Double.parseDouble(mass.getText());
                        f = Double.parseDouble(force.getText());

                        acceleration.setText(N2LQuantityCalculations.calcAcceleration(f, m) + "");
                        acceleration.setEditable(false);
                    }

                // CASE 3: Calculate the Force given the Mass and the Acceleration.
                if(force.getText().length() == 0)
                    if(mass.getText().length() > 0 && acceleration.getText().length() > 0)
                    {
                        m = Double.parseDouble(mass.getText());
                        a = Double.parseDouble(acceleration.getText());

                        force.setText(N2LQuantityCalculations.calcForce(m, a) + "");
                        force.setEditable(false);
                    }
            }

        });

        stage.setScene(scene);
        stage.show();


    }

}
