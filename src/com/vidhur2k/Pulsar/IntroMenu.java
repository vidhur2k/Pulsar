package com.vidhur2k.Pulsar;

import com.vidhur2k.Pulsar.topics.NewtonsSecondLaw;
import com.vidhur2k.Pulsar.topics.OneDimensionalMotion;
import com.vidhur2k.Pulsar.topics.WaveEquation;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.*;

/**
 * Created by vidhur2k on 9/17/16.
 */
public class IntroMenu extends WelcomeMenu{


    public static void initIntroMenu(Stage primaryStage, Group secondRootGroup, Scene secondScene)
    {

        // Introduces the structure of the calculator to the User.
        final List<Text> introToChoices = new ArrayList<>();
        Collections.addAll(introToChoices,
                new Text(10, 40, "So, you wanna solve some problems?"),
                new Text(40, 110, "Follow these steps: "));

        introToChoices.forEach(x -> x.setFont(new Font("SERIF", 36)));
        introToChoices.forEach(x -> x.setFill(Color.PURPLE));

        // Extension of introToChoices- information to the User.
        final List<Text> selectionSteps = new ArrayList<>();
        Collections.addAll(selectionSteps,
                new Text(40, 170, "1. Select the topic"),
                new Text(40, 230, "2. Read the introduction"),
                new Text(40, 290, "3. Solve challenging problems"),
                new Text(40, 350, "4. Enjoy the Science!"));

        selectionSteps.forEach(x -> x.setFont(new Font("SERIF", 36)));
        selectionSteps.forEach(x -> x.setFill(Color.PURPLE));


        // Button to enable the User to move on to the topic of his or her own choice.
        final Button selectTopic = new Button();
        selectTopic.setText("SELECT TOPIC");
        selectTopic.setFont(new Font("Times New Roman", 12));

        final ChoiceBox<String> topicChoices = new ChoiceBox<String>();
        topicChoices.setLayoutY(500);
        topicChoices.setLayoutX(112);

        topicChoices.setValue("NO VALUE SELECTED");
        topicChoices.getItems().add("NO VALUE SELECTED");
        topicChoices.getItems().add("One Dimensional Motion");
        topicChoices.getItems().add("The Wave Equation");
        topicChoices.getItems().add("Newton's 2nd Law");

        final Button continueButton = new Button();
        continueButton.setText("Click to Continue!");
        continueButton.setFont(new Font("Times New Roman", 15));
        continueButton.setLayoutX(350);
        continueButton.setLayoutY(500);

        introToChoices.forEach(secondRootGroup.getChildren() :: add);
        selectionSteps.forEach(secondRootGroup.getChildren() :: add);
        secondRootGroup.getChildren().add(continueButton);
        secondRootGroup.getChildren().add(topicChoices);

        primaryStage.setScene(secondScene);
        primaryStage.show();

        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Newton's 2nd Law.
                if(topicChoices.getValue().equals("Newton's 2nd Law"))
                {
                    Stage stage = new Stage();
                    Group rootGroup = new Group();
                    Scene scene = new Scene(rootGroup, 700, 700, Color.AQUAMARINE);
                    NewtonsSecondLaw.initNewtonsSecondLaw(stage, rootGroup, scene);
                    primaryStage.close();
                }

                // The Wave Equation.
                if(topicChoices.getValue().equals("The Wave Equation"))
                {
                    Stage stage = new Stage();
                    Group rootGroup = new Group();
                    Scene scene = new Scene(rootGroup, 700, 700, Color.AQUAMARINE);
                    WaveEquation.initWaveEquation(stage, rootGroup, scene);
                    primaryStage.close();
                }

                // 1D Motion.
                if(topicChoices.getValue().equals("One Dimensional Motion"))
                {
                    Stage stage = new Stage();
                    Group rootGroup = new Group();
                    Scene scene = new Scene(rootGroup, 700, 700, Color.AQUAMARINE);
                    OneDimensionalMotion.initOneDimensionalMotion(stage, rootGroup, scene);
                    primaryStage.close();
                }

            }
        });
    }


}
