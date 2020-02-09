package tegneprogram;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<Coordinate> loadFile() throws IOException {
        List<Coordinate> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(new File("lines336k.txt")));

        String line;
        while((line = br.readLine()) != null){
            String[] coords = line.split(" ");
            double[] coordsDoubles = new double[4];

            for(int i = 0; i < coords.length - 1; i++){
                coordsDoubles[i] =
                        Double.parseDouble(coords[i + 1]);
            }

            Coordinate c = new Coordinate(coordsDoubles[0],coordsDoubles[1],coordsDoubles[2],coordsDoubles[3]);
            list.add(c);
        }

        return list;
    }

    public void zoomIn(Pane pane, Button zoomIn){
        zoomIn.setOnAction(actionEvent -> {
                    pane.setScaleX(pane.getScaleX() * 1.25);
                    pane.setScaleY(pane.getScaleY() * 1.25);
                }
        );
    }
    public void zoomOut(Pane pane, Button zoomIn){
        zoomIn.setOnAction(actionEvent -> {
                    pane.setScaleX(pane.getScaleX() * 0.8);
                    pane.setScaleY(pane.getScaleY() * 0.8);
                }
        );
    }
    public void goNorth(Pane pane, Button button){
        button.setOnAction(actionEvent ->
                pane.setTranslateY(pane.getTranslateY() + 30)
        );
    }
    public void goSouth(Pane pane, Button button){
        button.setOnAction(actionEvent ->
                pane.setTranslateY(pane.getTranslateY() - 30)
        );
    }
    public void goEast(Pane pane, Button button){
        button.setOnAction(actionEvent ->
                pane.setTranslateX(pane.getTranslateX() - 30)
        );
    }
    public void goWest(Pane pane, Button button){
        button.setOnAction(actionEvent ->
                pane.setTranslateX(pane.getTranslateX() + 30)
        );
    }

}
