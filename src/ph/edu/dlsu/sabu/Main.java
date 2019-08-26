package ph.edu.dlsu.sabu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.lang.reflect.*;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*********************************************/

         /* #TODO: Fill this with your code */

        AnalyzingStudent newStudent = new AnalyzingStudent();
        newStudent.setName("Matthew Sabularse");
        newStudent.setId(110000000);

        // Create a text for your name
        Text name = new Text(newStudent.getName());
        name.setFont(Font.font("Outage",20));
        name.setTextAlignment(TextAlignment.CENTER);

        // Create a text for your ID
        Text id = new Text(""+newStudent.getId());
        id.setFont(Font.font("Outage",17));
        id.setTextAlignment(TextAlignment.CENTER);

        // Create a picture
        ImageView picture = new ImageView(new Image("ph/edu/dlsu/sabu/unknown.png"));
        picture.setFitHeight(250);
        picture.setFitWidth(250);

        // Create a label
        Text label = new Text("I can do the following:");
        label.setTextAlignment(TextAlignment.CENTER);


        /*********************************************/

        Text msg = new Text(enumerateMethods());
        msg.setFont(Font.font ("Verdana", 11));
        msg.setFill(Color.WHITE);
        msg.setTextAlignment(TextAlignment.CENTER);


        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10,0,0,0));
        root.getChildren().addAll(name,id,picture,label,msg);

        /*********************************************/

        /* #TODO: Fill this with your code */
        TextField fileName = new TextField();
        fileName.setPadding(new Insets(10,0,0,0));
        fileName.setPromptText("change");

        HBox image = new HBox();
        image.setAlignment(Pos.CENTER);
        image.getChildren().addAll(fileName);

        Button changePic = new Button("Change Picture");
        changePic.setOnAction(event -> picture.setImage(new Image("ph/edu/dlsu/sabu/" +
                fileName.getText())));

        VBox last = new VBox(10);
        last.setAlignment(Pos.CENTER);
        last.getChildren().addAll(image,changePic,root);

        /*********************************************/


        Scene scene = new Scene(last, 640,980);
        scene.getStylesheets().add(getClass().getResource("bg.css").toExternalForm());

        primaryStage.setTitle("Practical");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This method prints all methods, declared and derived, associated with the chosen class
     * @return
     */
    public String enumerateMethods(){
        Class c = AnalyzingStudent.class; // replace this with your choice, e.g. CreatingStudent.class
        //Method[] methods = c.getMethods();
        Method[] methods = c.getDeclaredMethods();
        String result = "";
        for(int i = 0; i < methods.length; i++) {
            result += methods[i].toString() + '\n';
        }
        return result;
    }
}
