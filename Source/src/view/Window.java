package view;
import controller.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window {
    Controller controller;
    private Stage stage;
    private Scene scene; //???????
    private MainWindow mainScene;
    private TrainingWindow trainingScene;
    private TranslateWindow translateScene;
    private SettingsWindow settingsScene;


    public void setScene(String scene){
        switch (scene){

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

    public void setController(Controller controller){
        this.controller = controller;
    }

    public Window(Controller controller){
        stage = new Stage();
        settingsScene = new SettingsWindow(controller);
        mainScene = new MainWindow(controller);
        trainingScene = new TrainingWindow(controller);
        translateScene = new TranslateWindow(controller);

        stage.setScene(mainScene.getScene());
        //buildButtons();
        stage.setTitle("English-Time");
        stage.setMinHeight(300);
        stage.setMinWidth(500);
        stage.setResizable(false);
        stage.show();
    }
}
