package bfst20.addressparser;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * GUI
 */
public class GUI extends Application {
    Controller c = new Controller();
    public static Label lastSearch = new Label();

    @Override
    public void start(Stage primaryStage) {
        Model model = new Model();

        var hBox = new HBox();
        var pane = new BorderPane();
        var input = new TextField();
        var output = new TextArea();

        var vBox = new VBox();

        output.setEditable(false);
        c.loadAddress(input,output);
        input.setFont(new Font(30));
        output.setFont(new Font(30));
        pane.setCenter(output);
        primaryStage.setTitle("Tjoms' seje program xDDD gaming");

        vBox.getChildren().addAll(new Label("Søgehistorik:"),pane);

        VBox vBox1 = new VBox();
        lastSearch.setFont(new Font(30));

        vBox1.getChildren().addAll(input,new Label("Seneste resultat:"),lastSearch);

        hBox.getChildren().addAll(vBox1,vBox);


        primaryStage.setScene(new Scene(hBox));
        primaryStage.show();
    }

}
