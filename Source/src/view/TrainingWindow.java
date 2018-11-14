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

public class TrainingWindow extends ParentWindow{
    private GridPane gridPane;
    private Scene scene;
    Button buttonMenu;
    Button buttonNotRemember;
    Button buttonCheck;
    Label labelWord;
    Label labelAnswer;
    TextField textField;

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

        buttonMenu = new Button("Menu");
        gridPane.add(buttonMenu,0,0,1,1);

        labelAnswer = new Label("There will be answer.");
        gridPane.add(labelAnswer,2,2,4,1);

        labelWord = new Label("There will a word.");
        gridPane.add(labelWord,2,3,2,1);

        textField = new TextField();
        gridPane.add(textField,4,3,4,1);

        buttonNotRemember = new Button("Don't remember");
        gridPane.add(buttonNotRemember,2,4,2,1);

        buttonCheck = new Button("Check");
        gridPane.add(buttonCheck,4,4,4,1);
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
    public TrainingWindow(Controller controller){
        super(controller);
        fillScene();
        scene = new Scene(gridPane,500,300);
        buildButtons();
    }
}
