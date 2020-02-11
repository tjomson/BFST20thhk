package tegneprogram;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();

        Pane pane = new Pane();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(pane);
        VBox vBox = new VBox();
        GridPane navigationButtons = new GridPane();

        Button goNorth = new Button("Go north");
        Button goSouth = new Button("Go south");
        Button goEast = new Button("Go east");
        Button goWest = new Button("Go west");
        navigationButtons.add(goNorth, 1,0);
        navigationButtons.add(goSouth, 1,2);
        navigationButtons.add(goEast, 2,1);
        navigationButtons.add(goWest, 0,1);

        controller.goNorth(pane,goNorth);
        controller.goSouth(pane,goSouth);
        controller.goEast(pane,goEast);
        controller.goWest(pane,goWest);

        Button zoomIn = new Button("Zoom in");
        Button zoomOut = new Button("Zoom out");

        controller.zoomIn(pane,zoomIn);
        controller.zoomOut(pane,zoomOut);

        vBox.getChildren().addAll(scrollPane,zoomIn,zoomOut, navigationButtons);

        for(Coordinate c : controller.loadFile()){
            Line line = new Line(c.getX1(),c.getY1(),c.getX2(),c.getY2());
            line.setStrokeWidth(0.2);
            pane.getChildren().add(line);
        }



        Scene scene = new Scene(vBox,1000,800);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }




}
