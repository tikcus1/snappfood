package main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
public class Main extends Application{

    public static Stage stage;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.stage = primaryStage;
        //URL url = getClass().getResource("../FXML/Tmp.fxml");
        URL url = getClass().getResource("../Admin/FXML/add_show.fxml");
        //URL url = getClass().getResource("../Admin/FXML/show_list.fxml");
        //URL url = getClass().getResource("../Admin/FXML/one_rest.fxml");
        AnchorPane anchorPane = FXMLLoader.load(url);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
