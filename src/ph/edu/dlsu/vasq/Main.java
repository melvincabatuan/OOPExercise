/*
* Vasquez, Ralph Joshua V.
* 11824999
* LBYCPEI-EQ3
* 08/16/2019
*
*/

package ph.edu.dlsu.vasq;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.lang.reflect.Method;

import static javafx.geometry.Pos.CENTER;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*********************************************/
         /* #TODO: Fill this with your code */
        /*********************************************/

        CreatingStudent me = new CreatingStudent();
        me.setName("Ralph Joshua V. Vasquez"); // use your name
        me.setId(110000000);   // use your I.D.


        /*********************************************/
        /* #TODO: Fill this with your code */
        /*********************************************/


        // Create a text for your name
        Text name = new Text(me.getName());
        name.setFont(Font.font("Cambria",12));
        name.setFill(Color.WHITE);


        // Create a text for your ID
        Text id = new Text(""+me.getId());
        id.setFont(Font.font("Cambria", 8));
        id.setFill(Color.WHITE);

        // Create a picture
        ImageView picture = new ImageView(new Image("ph/edu/dlsu/vasq/unknown.png"));
        //picture.setFitHeight(30);
        picture.setFitHeight(200);
        picture.setFitWidth(150);

        // Create a label
        Text label = new Text("I can do the following:");
        label.setFont(Font.font("Cambria", 15));
        label.setFill(Color.WHITE);

        Text msg = new Text(enumerateMethods());
        msg.setFont(Font.font ("Verdana", 12));
        msg.setFill(Color.WHITE);
        msg.setTextAlignment(TextAlignment.CENTER);





        TextField text = new TextField ();
        text.setPadding(new Insets(10,0,0,0));
        text.setPromptText("Change");
        text.setAlignment(CENTER);

        Button button = new Button("Change Picture");
        button.setOnAction(event -> picture.setImage(new Image("ph/edu/dlsu/vasq/" + text.getText())));

        VBox root =  new VBox(name, id, picture, label, text,button, msg);
        root.setBackground(Background.EMPTY);
        root.setAlignment(CENTER);
        root.setSpacing(5);
        root.setStyle("-fx-padding: .5;" +
                "-fx-border-width: 4;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: white;");


        Scene scene = new Scene(root, 640,980);
        scene.setFill(Color.GREEN);

        primaryStage.setTitle("Practical");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * This method prints all methods, declared and derived, associated with the chosen class
     * @return
     */

    public String enumerateMethods(){
        Class c = CreatingStudent.class; // replace this with your choice, e.g. CreatingStudent.class
        Method[] methods = c.getMethods();
        String result = "";
        for(int i = 0; i < methods.length; i++) {
            result += methods[i].toString() + '\n';
        }
        return result;
    }
}
