import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;

public class TmpController {
    @FXML
    private TextField username;

    @FXML
    private Label label;

    public void header(javafx.event.ActionEvent actionEvent) throws Exception {
        new Logged().start(main.Main.stage);
    }

    @FXML
    void test1(ActionEvent actionEvent) throws Exception {
        new Logged().start(main.Main.stage);
    }

    @FXML
    private void change_val(KeyEvent event) {
        System.out.println("kh");
        label.setText("hello " + username.getText());
    }

}