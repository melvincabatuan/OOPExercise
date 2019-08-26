package ph.edu.dlsu.toro;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.Method;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {


        RememberingStudent me = new RememberingStudent();
        me.setName("Matthew Edward S. Toro"); // use your name
        me.setId(110000000);   // use your I.D


        // Student name
        Text name = new Text(me.getName());
        name.setFont(Font.font ("Verdana", FontWeight.BOLD, 20));
        name.setFill(Color.WHITE);

        // ID number
        Text id = new Text(""+me.getId());
        id.setFont(Font.font ("Verdana", 14));
        id.setFill(Color.WHITE);

        // Picture
        ImageView picture = new ImageView(new Image("ph/edu/dlsu/toro/unknown.png", 500, 525, false, false));
        picture.setScaleX(.3);
        picture.setScaleY(.3);

        // Text Field
        TextField txtFld = new TextField("Input file name");
        txtFld.setMaxWidth(200.0);

        // Button
        Button myButton = new Button("Change Picture");
        myButton.setOnAction(e -> {
            try {
                String fileName = ("ph/edu/dlsu/toro/" + txtFld.getText());
                picture.setImage(new Image(fileName, 500, 525, false, false));
            }
            catch (Exception ex) {
                txtFld.setText("ERROR: FILE NAME NOT FOUND");
            }
        });

        // Label
        Text label = new Text("I can do the following:");
        label.setFont(Font.font ("Verdana", 14));
        label.setFill(Color.WHITE);

        // Methods
        Text msg = new Text(enumerateMethods());
        msg.setFont(Font.font ("Verdana", 10));
        msg.setFill(Color.WHITE);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        VBox.setMargin(name, new Insets(10, 0, 0, 0));
        VBox.setMargin(picture, new Insets(-150, 0, 0, 0));
        VBox.setMargin(txtFld, new Insets(-150, 0, 10, 0));
        VBox.setMargin(myButton, new Insets(0, 0, 20, 0));
        VBox.setMargin(label, new Insets(0, 0, 20, 0));
        root.getChildren().addAll(name, id, picture, txtFld, myButton, label, msg);
        root.setStyle("-fx-background-color: green");

        Scene scene = new Scene(root, 640,980);

        primaryStage.setTitle("Practical");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This method prints all methods, declared and derived, associated with the chosen class
     * @return
     */
    public String enumerateMethods(){
        Class c = EvaluatingStudent.class; // replace this with your choice, e.g. CreatingStudent.class
        Method[] methods = c.getMethods();
        String result = "";
        for(int i = 0; i < methods.length; i++) {
            result += methods[i].toString() + '\n';
        }
        return result;
    }
}
