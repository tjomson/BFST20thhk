package bfst20.addressparser;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    Model model  = new Model();

    public void loadAddress(TextField input, TextArea output) {
        input.setOnAction(e -> {
            var raw = input.getText();
            var parsed = Address.parse(raw);
            input.clear();
            output.appendText(parsed + "\n\n");
            GUI.lastSearch.setText(parsed + "\n\n");
            model.addressHistory.add(parsed);
        });
    }

}
