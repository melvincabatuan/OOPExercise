package ph.edu.dlsu.tiu;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.awt.event.ActionEvent;
import java.lang.reflect.*;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*********************************************/

         /* #TODO: Fill this with your code */

        CreatingStudent me = new CreatingStudent();
        me.setName("Emerson Karl Tiu");
        me.setId(110000000);

        Text name = new Text(me.getName());
        Text id = new Text(""+me.getId());
        ImageView picture = new ImageView(new Image("ph/edu/dlsu/tiu/emer.PNG"));
        Button btn = new Button("change image");
        TextField field = new TextField();

        name.setFont(Font.font ("Verdana", 18));
        name.setFill(Color.BLACK);

        id.setFont(Font.font ("Verdana", 12));
        id.setFill(Color.BLACK);

        Text label = new Text("I can do the following:");
        label.setFont(Font.font ("Verdana", 12));
        label.setFill(Color.BLACK);

        picture.setScaleX(.5);
        picture.setScaleY(.5);

        btn.setOnAction(event -> {
            String picName = field.getText();
            picture.setImage(new Image("ph/edu/dlsu/tiu/"+picName+".PNG"));
            System.out.println(picName);
        });


        /*********************************************/

        Text msg = new Text(enumerateMethods());
        msg.setFont(Font.font ("Verdana", 12));
        msg.setFill(Color.BLACK);

        VBox root = new VBox(name,id,picture,field,btn,label,msg);






        /*********************************************/
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);


        /*********************************************/


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
