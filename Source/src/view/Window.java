package view;

import controller.Controller;
import javafx.stage.Stage;

public class Window {
    private Controller controller;
    private Stage stage;
    private MainWindow mainScene;
    private TrainingWindow trainingScene;
    private TranslateWindow translateScene;
    private SettingsWindow settingsScene;

    public Window(Controller controller) {
        this.controller = controller;
        initView();
    }

    public void setScene(String scene) {
        switch (scene) {
            case "MainWindow":
                stage.setScene(mainScene.getScene());
                break;
            case "TrainingWindow":
                stage.setScene(trainingScene.getScene());
                break;
            case "TranslateWindow":
                stage.setScene(translateScene.getScene());
                break;
            case "SettingsWindow":
                stage.setScene(settingsScene.getScene());
                break;
        }
    }

    private void initView() {
        stage = new Stage();
        settingsScene = new SettingsWindow(controller);
        mainScene = new MainWindow(controller);
        trainingScene = new TrainingWindow(controller);
        translateScene = new TranslateWindow(controller);
        stage.setScene(mainScene.getScene());
        stage.setTitle("English-Time");
        stage.setMinHeight(300);
        stage.setMinWidth(500);
        stage.setResizable(false);
        stage.show();
    }
}