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

public class TranslateWindow extends ParentWindow{
    private GridPane gridPane;
    private Scene scene;
    Button buttonMenu;
    Button buttonTranslate;
    Button buttonAdd;
    Label labelForTranslate;
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

        Label label = new Label("Enter a word for translate.");
        gridPane.add(label,1,3,4,1);

        textField = new TextField();
        gridPane.add(textField,1,5,2,1);

        labelForTranslate = new Label("There will be translate.");
        gridPane.add(labelForTranslate,4,5,2,1);

        buttonTranslate = new Button("Translate");
        gridPane.add(buttonTranslate,7,5,2,1);

        buttonAdd = new Button("+ Add");
        gridPane.add(buttonAdd,4,7,2,1);
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

    public TranslateWindow(Controller controller){
        super(controller);
        fillScene();
        scene = new Scene(gridPane,500,300);
        buildButtons();
    }
}
