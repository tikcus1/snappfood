package Admin.Controller;


import Admin.Restaurant;
import Admin.OpenShowList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.util.Pair;
import main.Main;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class AddShow {
    int i, j;

    Socket socket;
    PrintWriter out;

    public AddShow(){
        String serverHost = "localhost"; // آدرس IP سرور
        int serverPort = 8335;
        try {
            // ایجاد اتصال به سرور
            socket = new Socket(serverHost, serverPort);

            out = new PrintWriter(socket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void add_restaurant() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("name?");
        String n = scanner.next();

        System.out.println("address?");
        String a = scanner.next();

        System.out.println("work time?");
        String w = scanner.next();

        System.out.println("picture?");
        String p = scanner.next();

        System.out.println("where can eat?(in/out)");
        String wh1 = scanner.next();
        if (wh1.compareTo("in") == 0) {
            System.out.println("how many table?");
        } else {
            System.out.println("how many courier?");
        }
        int wh2 = scanner.nextInt();
        Pair<String, Integer> wh = new Pair<>(wh1, wh2);
///////////////////////////////////////////////////////////////////////////////////////////
         // پورت سرور
        out.println("adminAdd");

        // ایجاد شیء برای ارسال به سرور
        Restaurant restaurant = new Restaurant(n, a, w, p, wh, new ArrayList<>());

        // تبدیل و ارسال شیء
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(restaurant);
        outputStream.flush();

        // بستن اتصال
//            socket.close();

        System.out.println("شیء با موفقیت ارسال شد.");


        //new ShowList().grid.getChildren().add(new OneRest(n).one);
        /*try (FileOutputStream fileOut = new FileOutputStream("restaurants.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            restaurant = new Restaurant(n, a, w, p, wh, new ArrayList<>());
            objectOut.writeObject(restaurant);
            System.out.println(restaurant);
        } catch (IOException e) {
            System.out.println("khhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            //  e.printStackTrace();
        }

        try (FileInputStream fileIn = new FileInputStream("restaurants.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

            restaurant = (Restaurant) objectIn.readObject();
            //System.out.println("Restaurant object has been loaded from " + filePath);
            //return restaurant;
            System.out.println("didi" + restaurant.toString());

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("riiiiiiiiiiiiiiiiidiiiiiiiiiiiiii");
            // e.printStackTrace();
            //return null;
        }*/

    }
////////////////////////////////////////////////////////////////////////////////////

    public void show_restaurant() throws Exception {
        //new OpenShowList().start(main.Main.stage);
        out.println("adminShow");
//        add(n, p);
    }
    void add(String n, String p) throws Exception{
        URL url1 = getClass().getResource("../FXML/show_list.fxml");
        AnchorPane anchorPane1 = FXMLLoader.load(url1);
        GridPane grid = (GridPane) anchorPane1.getChildren().get(0);

        URL url2 = getClass().getResource("../FXML/one_rest.fxml");
        AnchorPane anchorPane2 = FXMLLoader.load(url2);
        // images/food.jpg p = food.jpg
        Image image = new Image("images/" + p);
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        anchorPane2.setBackground(background);
        Label label = (Label) anchorPane2.getChildren().get(0);
        label.setText(n);

        grid.add(anchorPane2, i, j);
        if(j == 2) {
            i++;
            j = 0;
        }
        else {
            j++;
        }
//        Scene scene = new Scene(anchorPane1);
//        Main.stage.setScene(scene);
    }
}