import model.DataBaseManager;
import view.*;
import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage stage) {
        controller = new Controller(10,100);
        Window window = new Window(controller);
        controller.setWindow(window);

        DataBaseManager dataBaseManager = new DataBaseManager();
        dataBaseManager.createNewTable();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}