package Lab8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane pane = new GridPane();
        VBox vbox = new VBox(10);  //Pane to hold the lights
        vbox.setPadding(new Insets(5,5,5,5));
        pane.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-border-width: 2px; -fx-border-color: blue");

        HBox hBox = new HBox(20);  //Horizontal box to hold buttons

        Circle green = new Circle(15); //To hold green light
        green.setFill(Color.TRANSPARENT);
        green.setStroke(Color.BLACK);

        Circle yellow = new Circle(15); //To hold the yellow light
        yellow.setFill(Color.TRANSPARENT);
        yellow.setStroke(Color.BLACK);

        Circle red = new Circle(15); //To hold the red light
        red.setFill(Color.TRANSPARENT);
        red.setStroke(Color.BLACK);

        vbox.getChildren().addAll(red, yellow, green);  //Adding lights to the vbox
        pane.getChildren().add(vbox);

        //Creating Radio buttons for the control
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");
        hBox.getChildren().addAll(rbRed, rbYellow, rbGreen);  //Adding buttons to Hbox
        hBox.setAlignment(Pos.CENTER);

        //Handling the buttons
        rbRed.setOnAction(actionEvent -> {
            if(rbRed.isSelected()){
                red.setFill(Color.RED);
                yellow.setFill(Color.TRANSPARENT);
                green.setFill(Color.TRANSPARENT); }
        });
        rbYellow.setOnAction(actionEvent -> {
            if (rbYellow.isSelected()){
                yellow.setFill(Color.YELLOW);
                red.setFill(Color.TRANSPARENT);
                green.setFill(Color.TRANSPARENT); }
        });
        rbGreen.setOnAction(actionEvent -> {
            if(rbGreen.isSelected()){
                green.setFill(Color.GREEN);
                yellow.setFill(Color.TRANSPARENT);
                red.setFill(Color.TRANSPARENT); }
        });

        //Grouping radio buttons
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        //Border pane to hold the pane and hbox
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5,5,5,5));
        borderPane.setCenter(pane);   //Set vbox to center
        borderPane.setBottom(hBox);   //Set buttons to bottom

        Scene scene = new Scene(borderPane, 250,200);
        primaryStage.setTitle("Exercise16_03");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
