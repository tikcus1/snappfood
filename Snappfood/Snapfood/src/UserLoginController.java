import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class UserLoginController {

    @FXML
    TextField username_field ;

    @FXML
    PasswordField password_field ;

    @FXML
    Text password_error_field ;


    Socket socket ;
    PrintWriter out;
    BufferedReader in ;




    public UserLoginController(){
        try{
            socket = new Socket("localhost", 8335);
            out = new PrintWriter(socket.getOutputStream(), true) ;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
        }catch (IOException exception){
            System.out.println("server not found");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Server not found");
            errorAlert.showAndWait();
        }
    }


    public void login_button(ActionEvent actionEvent) throws Exception {
        if(!isEmpty(username_field) & !isEmpty(password_field)) {
            out.println(username_field.getText());
            out.println(password_field.getText());

            if (in.readLine().equals("true")) {
                socket.close();
                loggedIn(actionEvent);
            }
            else
                System.out.println("user not found");
        }
    }

    public void loggedIn(ActionEvent event)throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("logged in.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public boolean isEmpty(TextField field){
        if(field.getText().equals("")){
            System.out.println("fill the "+ field.getId());
            return true;
        }
        return false;
    }
}