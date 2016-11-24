package com.vidhur2k.Pulsar.topics;

import com.vidhur2k.Pulsar.calculations.WaveEquationCalculations;
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
 * Created by vidhur2k on 9/21/16.
 */
public class WaveEquation {

    public static void initWaveEquation(Stage stage, Group rootGroup, Scene scene)
    {
        stage.setTitle("com.vidhur2k.Pulsar.Pulsar- The Wave Equation");

        final List<Text> backgroundInfo = new ArrayList<>();

        Collections.addAll(backgroundInfo,
                            new Text(9, 17, "The Wave Equation expresses the relationship between the velocity of the wave and"),
                            new Text(9, 34, "its frequency and wavelength."));

        backgroundInfo.forEach(x -> x.setFont(new Font("SERIF", 16)));
        backgroundInfo.forEach(x -> x.setFill(Color.DEEPPINK));
        backgroundInfo.forEach(rootGroup.getChildren() :: add);

        final List<Text> formulaInfo = new ArrayList<>();

        Collections.addAll(formulaInfo,
                new Text(9, 90, "FORMULA: "),
                new Text(300, 90, "V = fλ"));

        formulaInfo.forEach(x -> x.setFont(new Font("SERIF", 36)));
        formulaInfo.forEach(x -> x.setFill(Color.RED));
        formulaInfo.forEach(rootGroup.getChildren() :: add);

        final List<Label> unitLabels = new ArrayList<>();
        Collections.addAll(unitLabels,
                new Label("Hz"),
                new Label("m"),
                new Label("m / s"));

        unitLabels.forEach(x -> x.setFont(new Font("SERIF", 20)));
        unitLabels.forEach(x -> x.setLayoutX(475));
        int yBuffer2 = 150;
        for (Label l : unitLabels)
            l.setLayoutY(yBuffer2 += 100);

        unitLabels.forEach(rootGroup.getChildren() :: add);


        final List<Label> quantityLabels = new ArrayList<>();
        Collections.addAll(quantityLabels,
                new Label("FREQUENCY: "),
                new Label("WAVELENGTH: "),
                new Label("WAVE VELOCITY: "));

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

                TextField freq = quantityInputs.get(0);
                TextField wavelength = quantityInputs.get(1);
                TextField velocity = quantityInputs.get(2);

                double f, l, v;


                // TODO Figure out a way to handle the exceptions using try catch or compareTo().

                // Exception handling.
                if(quantityInputs.stream().filter(x -> x.getText().length() == 0).collect(Collectors.toList()).size() == 0)
                {
                    Alert inputError = new Alert(Alert.AlertType.ERROR);
                    inputError.setTitle("Error Dialog");
                    inputError.setHeaderText("Input Error");
                    inputError.setContentText("Please leave one value blank to calculate!");
                    inputError.showAndWait();
                    initWaveEquation(stage, rootGroup, scene);
                }

                // Exception Handling 2
                if(quantityInputs.stream().filter(x -> x.getText().length() != 0).collect(Collectors.toList()).size() == 0)
                {
                    Alert inputError = new Alert(Alert.AlertType.ERROR);
                    inputError.setTitle("Error Dialog");
                    inputError.setHeaderText("Input Error");
                    inputError.setContentText("Please enter values!");
                    inputError.showAndWait();
                    initWaveEquation(stage, rootGroup, scene);
                }

                // CASE 1: Calculate the freq given the velocity and the wavelength.
                if(freq.getText().length() == 0)
                    if(wavelength.getText().length() > 0 && velocity.getText().length() > 0)
                    {
                        l = Double.parseDouble(wavelength.getText());
                        v = Double.parseDouble(velocity.getText());

                        freq.setText(WaveEquationCalculations.calcFreq(v, l) + "");
                        freq.setEditable(false);
                    }

                // CASE 2: Calculate the wavelength given the velocity and the freq.
                if(wavelength.getText().length() == 0)
                    if(freq.getText().length() > 0 && velocity.getText().length() > 0)
                    {
                        f = Double.parseDouble(freq.getText());
                        v = Double.parseDouble(velocity.getText());

                        wavelength.setText(WaveEquationCalculations.calcWavelength(v, f) + "");
                        wavelength.setEditable(false);
                    }

                // CASE 3: Calculate the velocity given the freq and the wavelength.
                if(velocity.getText().length() == 0)
                    if(freq.getText().length() > 0 && wavelength.getText().length() > 0)
                    {
                        f = Double.parseDouble(freq.getText());
                        l = Double.parseDouble(wavelength.getText());

                        velocity.setText(WaveEquationCalculations.calcVelocity(f, l) + "");
                        velocity.setEditable(false);
                    }
            }

        });

        stage.setScene(scene);
        stage.show();
    }
}
