package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TrainingWindow extends ParentWindow {
    private GridPane gridPane;
    private Scene scene;
    private Button buttonMenu;
    private Button buttonNotRemember;
    private Button buttonCheck;
    private Label labelWord;
    private Label labelAnswer;
    private TextField textField;

    TrainingWindow(Controller controller) {
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
        buttonCheck.setOnAction(event -> {

        });
        buttonNotRemember.setOnAction(event -> {

        });
    }

    private void fillScene() {
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.alignmentProperty();

        buttonMenu = new Button("Menu");
        gridPane.add(buttonMenu, 0, 0, 1, 1);

        labelAnswer = new Label("There will be answer.");
        gridPane.add(labelAnswer, 3, 1, 4, 1);

        labelWord = new Label("There will a word.");
        gridPane.add(labelWord, 1, 3, 4, 1);

        textField = new TextField();
        gridPane.add(textField, 5, 3, 4, 1);

        buttonNotRemember = new Button("Don't remember");
        gridPane.add(buttonNotRemember, 1, 4, 4, 1);

        buttonCheck = new Button("Check");
        gridPane.add(buttonCheck, 7, 4, 2, 1);
    }
}