package code.controller;
import code.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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

public class UserLoginController {

    @FXML
    TextField username_field ;

    @FXML
    PasswordField password_field ;

    @FXML
    Text password_error_field ;

    @FXML
    Text user_error_field;



    Socket socket ;
    PrintWriter out;
    BufferedReader in ;




    public UserLoginController() throws IOException{
        this.socket = Main.socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }


    public void login_button(ActionEvent actionEvent) throws Exception {
        password_error_field.setText("");
        user_error_field.setText("");
        if(isEmpty()){
            out.println("login/"+username_field.getText()+"/"+password_field.getText()+"/");

            if (in.readLine().equals("true")) {
                loggedIn(actionEvent);
            }
            else {
                System.out.println("user not found");
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Error");
                errorAlert.setContentText("User not found");
                errorAlert.showAndWait();
            }
        }
    }

    public void loggedIn(ActionEvent event)throws Exception{//does not have any controller yet

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resource/FXML/main menu.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public boolean isEmpty(){
        boolean b = true;
        if(username_field.getText().equals("")) {
            user_error_field.setText("enter the username !");
            b = false;
        }
        if(password_field.getText().equals("")) {
            password_error_field.setText("enter the password !");
            b = false;
        }
        return b;
    }

    public void register(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resource/FXML/register.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

}