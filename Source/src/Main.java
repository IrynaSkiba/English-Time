import view.*;
import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage stage) throws Exception {
        controller = new Controller();
        Window window = new Window(controller);
        controller.setWindow(window);
        //window.setController(controller);
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}