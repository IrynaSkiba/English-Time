package view;
import controller.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainWindow extends ParentWindow {
    //private Controller controller;
    private GridPane gridPane;
    private Scene scene;
    private Button buttonEngToRus;
    private Button buttonRusToEng;
    Button buttonTranslate;
    Button buttonSettings;
    Label labelGoal;
    Label labelPercent;

    @Override
    public Scene getScene() {
        return scene;
    }

    private void fillScene() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        buttonEngToRus = new Button("English->Russian");
        gridPane.add(buttonEngToRus,0,0,2,1);

        buttonRusToEng = new Button("Russian->English");
        gridPane.add(buttonRusToEng,0,1,2,1);

        buttonTranslate = new Button("Translate");
        gridPane.add(buttonTranslate,0,2,2,1);

        buttonSettings = new Button("Settings");
        gridPane.add(buttonSettings,0,4,2,1);

        //Todo проверка из котроллера на выполнение ежедневной цели
        labelGoal = new Label("You haven't achieved your goal today.");
        gridPane.add(labelGoal,3,1,4,1);

        //Todo расчет процента нетренированных слов за день
        labelPercent = new Label("You still have 100% to learn.");
        gridPane.add(labelPercent,3,3,4,1);
    }

    @Override
    public void buildButtons(){
        buttonEngToRus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //if (!textField.getText().isEmpty()) {
                //todo флаг для определения на каком языке отображать слова
                    controller.changeScene("TrainingWindow");
               // }
            }
        });
        buttonRusToEng.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //if (!textField.getText().isEmpty()) {
                controller.changeScene("TrainingWindow");
                // }
            }
        });
        buttonTranslate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //if (!textField.getText().isEmpty()) {
                controller.changeScene("TranslateWindow");
                // }
            }
        });
        buttonSettings.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //if (!textField.getText().isEmpty()) {
                controller.changeScene("SettingsWindow");
                // }
            }
        });
    }

    public MainWindow(Controller controller){
        super(controller);
        fillScene();
        scene = new Scene(gridPane,500,300);
        buildButtons();
    }
}
