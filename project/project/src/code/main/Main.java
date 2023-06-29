package code.main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class Main extends Application {
    public static Socket socket;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        try{
            socket = new Socket("localhost", 8335);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../../resource/FXML/userLogin.fxml")));
            primaryStage.setTitle("login");
            primaryStage.setScene(new Scene(root, 418, 530));
            primaryStage.setResizable(false);
            primaryStage.show();
        }catch (IOException exception ){
            System.out.println("server not found");
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Error");
            errorAlert.setContentText("Server not found");
            errorAlert.showAndWait();
            exception.printStackTrace();
            System.exit(1);
        }
    }
}

