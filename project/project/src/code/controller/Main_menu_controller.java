package code.controller;

import code.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main_menu_controller {

    Socket socket;
    PrintWriter out;
    BufferedReader in ;
    @FXML
    Text user_name;

    public Main_menu_controller() throws IOException {
        this.socket = Main.socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        out.println("main menu");
//        String a1 = in.readLine();
//        user_name.setText("Zahra");
//        System.out.println(in.readLine());
    }

    public void exit(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../resource/FXML/userLogin.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }
}
