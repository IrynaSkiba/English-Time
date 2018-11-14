package view;

import controller.Controller;
import javafx.scene.Scene;

public abstract class ParentWindow {
    public Controller controller;
    public abstract Scene getScene();
    public abstract void buildButtons();
    ParentWindow(Controller controller){
        this.controller = controller;
    }
}