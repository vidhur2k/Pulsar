package com.vidhur2k.Pulsar.topics;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by vidhur2k on 9/22/16.
 */
public class OneDimensionalMotion {

    public static void initOneDimensionalMotion(Stage primaryStage, Group rootGroup, Scene scene)
    {
        primaryStage.setTitle("com.vidhur2k.Pulsar.Pulsar- One Dimensional Motion");

        final List<Text> backgroundInfo = new ArrayList<>();

        Collections.addAll(backgroundInfo,
                            new Text(9, 17, "Kinematics is one of the most basic topics in Newtonian Mechanics.It expresses the"),
                            new Text(9, 34, "relationship between Displacement, Velocty, Acceleration, and Time."));

        final Text equationIntro = new Text(9, 100, "Which equation would you like to use?");
        equationIntro.setFont(new Font("SERIF", 24));
        equationIntro.setFill(Color.RED);
        rootGroup.getChildren().add(equationIntro);

        final List<Text> equations = new ArrayList<>();
        Collections.addAll(equations,
                            new Text("Δx = viΔt + (1/2)a(Δt^2)"),
                            new Text("vf = vi + aΔt"),
                            new Text("(vf^2) = (vi ^2) + 2aΔx"));

        int equationYBuffer = 150;

        equations.forEach(x -> x.setLayoutX(9));

        for (Text t : equations)
            t.setLayoutY(equationYBuffer += 100);

        equations.forEach(x -> x.setFont(new Font("SERIF", 30)));
        equations.forEach(x -> x.setFill(Color.DEEPPINK));
        equations.forEach(rootGroup.getChildren() :: add);

        final List<Button> equationSelector = new ArrayList<>();
        Collections.addAll(equationSelector,
                            new Button("THIS ONE!"),
                            new Button("THIS ONE!"),
                            new Button("THIS ONE!"));

        equationSelector.forEach(x -> x.setFont(new Font("Times New Roman", 18)));
        equationSelector.forEach(x -> x.setLayoutX(475));


        int equationSelectorYBuffer = 125;

        for (Button b : equationSelector)
            b.setLayoutY(equationSelectorYBuffer += 100);

        equationSelector.forEach(rootGroup.getChildren() :: add);


        backgroundInfo.forEach(x -> x.setFont(new Font("SERIF", 16)));
        backgroundInfo.forEach(x -> x.setFill(Color.DEEPPINK));
        backgroundInfo.forEach(rootGroup.getChildren() :: add);

        primaryStage.setScene(scene);
        primaryStage.show();

        equationSelector.get(0).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Stage stage = new Stage();
                Group rootGroup = new Group();
                Scene scene = new Scene(rootGroup, 700, 700, Color.AQUAMARINE);

                ODMEq1.initODMEq1(stage, rootGroup, scene);
                primaryStage.close();
            }
        });
    }
}
