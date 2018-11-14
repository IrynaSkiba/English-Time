package view;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainWindow extends ParentWindow {
    private GridPane gridPane;
    private Scene scene;
    private Button buttonEngToRus;
    private Button buttonRusToEng;
    private Button buttonTranslate;
    private Button buttonSettings;
    private Label labelGoal;
    private Label labelPercent;

    MainWindow(Controller controller) {
        super(controller);
        fillScene();
        scene = new Scene(gridPane, 500, 300);
        buildButtons();
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void buildButtons() {
        buttonEngToRus.setOnAction(event -> {
            //TODO флаг для определения на каком языке отображать слова
            controller.changeScene("TrainingWindow");
        });
        buttonRusToEng.setOnAction(event -> controller.changeScene("TrainingWindow"));
        buttonTranslate.setOnAction(event -> controller.changeScene("TranslateWindow"));
        buttonSettings.setOnAction(event -> controller.changeScene("SettingsWindow"));
    }

    private void fillScene() {
        gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        buttonEngToRus = new Button("English->Russian");
        gridPane.add(buttonEngToRus, 0, 0, 2, 1);

        buttonRusToEng = new Button("Russian->English");
        gridPane.add(buttonRusToEng, 0, 1, 2, 1);

        buttonTranslate = new Button("Translate");
        gridPane.add(buttonTranslate, 0, 2, 2, 1);

        buttonSettings = new Button("Settings");
        gridPane.add(buttonSettings, 0, 4, 2, 1);

        //TODO проверка из котроллера на выполнение ежедневной цели
        labelGoal = new Label("You haven't achieved your goal today.");
        gridPane.add(labelGoal, 3, 1, 4, 1);

        //TODO расчет процента нетренированных слов за день
        labelPercent = new Label("You still have 100% to learn.");
        gridPane.add(labelPercent, 3, 3, 4, 1);
    }
}