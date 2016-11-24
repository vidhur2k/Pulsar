package com.vidhur2k.Pulsar.topics;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by vidhur2k on 10/3/16.
 */
public class ODMEq1 {

    public static void initODMEq1(Stage stage, Group rootGroup, Scene scene)
    {
        stage.setTitle("One Dimensional Motion- Old Reliable");

        Text equation = new Text("Δx = viΔt + (1/2)a(Δt^2)");
        equation.setFont(new Font("SERIF", 30));

        final List<Label> variables = new ArrayList<>();

        Collections.addAll(variables,
                            new Label("Δx"),
                            new Label("vi"),
                            new Label("Δt"),
                            new Label("a"));

        variables.forEach(x -> x.setFont(new Font("SERIF", 30)));


        stage.setScene(scene);
        stage.show();
    }
}
