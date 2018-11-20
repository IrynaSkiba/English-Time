package view;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.PairWords;

public class TranslateWindow extends ParentWindow{
    private GridPane gridPane;
    private Scene scene;
    private Button buttonMenu;
    private Button buttonTranslate;
    private Button buttonAdd;
    private Label labelForTranslate;
    private TextField textField;

    TranslateWindow(Controller controller){
        super(controller);
        fillScene();
        scene = new Scene(gridPane,450,250);
        buildButtons();
    }

    @Override
    public Scene getScene() {
        return scene;
    }

    @Override
    public void buildButtons() {
        buttonMenu.setOnAction(event -> {
            controller.changeScene("MainWindow");
        });
        buttonAdd.setOnAction(event->{
            PairWords pairWords = new PairWords(controller.getAmountWords());
            controller.addWordToList(pairWords);
        });
        buttonTranslate.setOnAction(event->{
            String translatedWord = controller.translate(textField.getText());
            labelForTranslate.setText(translatedWord);
        });
    }

    private void fillScene() {
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(15, 15, 15, 15));

        buttonMenu = new Button("Menu");
        gridPane.add(buttonMenu,0,0,1,1);

        Label label = new Label("Enter a word for translate.");
        gridPane.add(label,3,1,4,1);

        textField = new TextField();
        gridPane.add(textField,2,3,4,1);

        labelForTranslate = new Label("There will be translate.");
        gridPane.add(labelForTranslate,2,4,4,1);

        buttonTranslate = new Button("Translate");
        gridPane.add(buttonTranslate,6,3,2,1);

        buttonAdd = new Button("+ Add");
        gridPane.add(buttonAdd,6,4,2,1);
    }
}