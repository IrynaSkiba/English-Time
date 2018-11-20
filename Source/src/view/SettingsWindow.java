package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SettingsWindow extends ParentWindow {
    private GridPane gridPane;
    private Scene scene;
    private Button buttonMenu;
    private Button buttonSave;
    private TextField textFieldGoal;
    private TextField textFieldRepetitions;

    SettingsWindow(Controller controller) {
        super(controller);
        fillScene();
        scene = new Scene(gridPane, 450, 250);
        buildButtons();
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void buildButtons() {
        buttonMenu.setOnAction(event -> {
            controller.changeScene("MainWindow");
        });
    }

    private void fillScene() {
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        buttonMenu = new Button("Menu");
        gridPane.add(buttonMenu, 0, 0, 1, 1);

        gridPane.add(new Label("Settings"), 4, 1, 2, 1);

        gridPane.add(new Label("Enter amount words for learning a day"),
                1, 2, 4, 1);

        textFieldGoal = new TextField();
        gridPane.add(textFieldGoal, 5, 2, 2, 1);

        gridPane.add(new Label("Enter amount repetitions a word"), 1, 4, 4, 1);

        textFieldRepetitions = new TextField();
        gridPane.add(textFieldRepetitions, 5, 4, 2, 1);

        buttonSave = new Button("Save");
        gridPane.add(buttonSave, 5, 5, 2, 1);
    }
}