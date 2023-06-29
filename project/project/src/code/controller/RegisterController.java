package code.controller;

import code.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RegisterController {

    Socket socket ;
    PrintWriter out ;
    BufferedReader in ;

    @FXML
    TextField username_field;
    @FXML
    TextField confirm_password_field;
    @FXML
    TextField password_field;

    @FXML
    Text warning_text;

    public RegisterController() throws IOException{
        this.socket = Main.socket;
        out = new PrintWriter(socket.getOutputStream(), true) ;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream())) ;
    }

    public void register_button(ActionEvent event) throws IOException {
        if(checkValid(username_field.getText()) && checkValid(password_field.getText())) {
            if (checkConfirm()) {
                out.println("register/" + username_field.getText() + "/" + password_field.getText());
                if (in.readLine().equals("true")) {
                    login_button(event);
                } else {
                    warning_text.setText("username is in used");
                }
            } else {
                warning_text.setText("confirm the password");
            }
        }
        else {
            warning_text.setText("use a-z & 0-9");
        }
    }

    private boolean checkConfirm() {
        return password_field.getText().equals(confirm_password_field.getText());
    }

    public void login_button(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resource/FXML/userLogin.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    private boolean checkValid(String str){
        char letter;
        for (int i = 0; i < str.length(); i++) {
            letter = str.charAt(i);
            if (!Character.toString(letter).matches("^[a-zA-Z0-9]*$"))
                return false;
        }
        return true;
    }
}
