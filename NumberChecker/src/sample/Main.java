/*
* Name:Dewan Fathima
* Class: CSIT 501 Java
* Project Name: NumberChecker
* Description: In this project the user will input a number and pick between two colors and based on the user input an
image will pop up and the background color will change.
*/
package sample;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage primaryStage) {
        //GridPane is creating the structure of the box and align the content in the box in the center
        // The StackPane is created to hold the images in a place
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        StackPane pane = new StackPane();

        //This is creating the text box with the TextField instance and the label with the Label instance for the user to input the number of choice
        Label num = new Label("Enter a Number: ");
        TextField numInput = new TextField();

        /*These are the radioButtons using the RadioButton instance to select the color choices and using togglegroup
        instance to select the options. The radio buttons are labeled as blue and green*/
        ToggleGroup colorGroup = new ToggleGroup();
        RadioButton blueBT = new RadioButton("Blue");
        blueBT.setToggleGroup(colorGroup);
        RadioButton greenBT = new RadioButton("Green");
        greenBT.setToggleGroup(colorGroup);

        //This is creating the submit button called submitBT using the button instance
        Button submitBT = new Button("Submit");


        /*This event handle method will enable the submit button to do a push action to output an image and choice of background color*/
        submitBT.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent actionEvent) {

                // This converts the string numInput into an int and it is being stored into the variable number
                //.getChildren().clear() helps clear out anything from the last action that was called
                int number = Integer.parseInt(numInput.getText());
                pane.getChildren().clear();

                /* This if statement with the math will figure out if the output is even or odd, then will output the image that corresponds to that number */
                if(number % 2 == 0){
                    Image image1 = new Image("image1.jpg");
                    ImageView imgView1 = new ImageView(image1);
                    pane.getChildren().add(imgView1);
                }
                else{
                    Image image2 = new Image("image2.jpg");
                    ImageView imgView2 = new ImageView(image2);
                    pane.getChildren().add(imgView2);
                }
                
                /*This if statement will allow the user to select the color to be output to either blue or green
                 from there the background will change to that color*/
                if(blueBT.isSelected()){
                    root.setStyle("-fx-background-color: skyblue");    
                }
                else if(greenBT.isSelected()){
                    root.setStyle("-fx-background-color: lightgreen");
                }
                pane.requestLayout();
            }
        });

        //Arranging the content on output box in the GridPane
        root.addRow(0,num,numInput);
        root.addRow(1,blueBT,greenBT);
        root.addRow(2,submitBT);
        root.add(pane, 0,3,2,1);

        // Setting up the scene to output
        Scene scene = new Scene(root, 500,500);

        //This showcase the contents onto the fx box
        primaryStage.setTitle("Check the Number Image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
