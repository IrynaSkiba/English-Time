package view;
import controller.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SettingsWindow extends ParentWindow{
    private GridPane gridPane;
    private Scene scene;
    Button buttonMenu;
    Button buttonSave;
    TextField textFieldGoal;
    TextField textFieldRepetitions;

    public Scene getScene() {
        return scene;
    }

    private void fillScene() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        buttonMenu = new Button("Menu");
        gridPane.add(buttonMenu,0,0,1,1);

        gridPane.add( new Label("Settings"),2,0,3,1);

        gridPane.add( new Label("Enter amount words for learning a day"),
                0,1,3,1);

        textFieldGoal = new TextField();
        gridPane.add(textFieldGoal,4,1,1,1);

        gridPane.add( new Label("Enter amount repetitions a word"),0,3,3,1);

        textFieldRepetitions = new TextField();
        gridPane.add(textFieldRepetitions,4,3,1,1);

        buttonSave = new Button("Save");
        gridPane.add(buttonSave,4,4,2,1);
    }

    @Override
    public void buildButtons() {
        buttonMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //if (!textField.getText().isEmpty()) {
                //todo флаг для определения на каком языке отображать слова
                controller.changeScene("MainWindow");
                // }
            }
        });
    }

    public SettingsWindow(Controller controller){
        super(controller);
        fillScene();
        scene = new Scene(gridPane,500,300);
        buildButtons();
    }
}
