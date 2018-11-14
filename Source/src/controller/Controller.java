package controller;
import view.*;

public class Controller {
    private Window window;

    public void changeScene(String parentWindow){
        window.setScene(parentWindow);
    }

    public void setWindow(Window window) {
        this.window = window;
    }
}