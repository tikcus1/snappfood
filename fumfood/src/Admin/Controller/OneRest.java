package Admin.Controller;

import Admin.Restaurant;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.util.Scanner;

public class OneRest {
    public void visibility(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        AnchorPane anchorPane = (AnchorPane) button.getParent();
        anchorPane.setVisible(false);

        GridPane gridPane = (GridPane) anchorPane.getParent();
        //find which row and col
        // line = row * 3 + col
        // in khat dar file
        // (get specific row in file send to server)
    }

    public void remove(ActionEvent actionEvent) {
        // mifresti be server ke pak kone az file
        //mitooni safhe ham dobare load koni  vali felan na
    }

    Scanner scanner = new Scanner(System.in);
    public void editFoods(ActionEvent actionEvent) {
        /*
        private String name;
    private String price;
    private double weight;

    enum type{
        traditional, pizza, salad, seafood, sandwiches, pasta, iranian;
    }
    private String pic;
         */
        System.out.println("add: 1");
        System.out.println("remove: 2");
        System.out.println("edit: 3");
        int which = scanner.nextInt();
        switch (which) {
            case 1 :
                String n = scanner.next();

                break;
            case 2:

        }
    }

    public void editProperty(ActionEvent actionEvent) {
        /*
        private String name;
    private String address;
    private String work_time;
    private String pic;
    private Pair<String, Integer> type;
    boolean vis = true;
         */
        System.out.println("change name: 1");
        System.out.println("change address: 2");
        System.out.println("change work_time: 3");
        System.out.println("change pic: 4");
        System.out.println("change type: 5");
        System.out.println("change vis: 6");
        int which = scanner.nextInt();
        switch (which) {
            case 1 :
                String n = scanner.next();

                break;
            case 2:

        }
    }
}
