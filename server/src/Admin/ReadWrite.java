package Admin;

import server.Server;

import java.io.*;
import java.net.Socket;

public class ReadWrite {

    Socket socket;

    public ReadWrite(Socket socket){
        this.socket = socket;
    }

    public void write(){
        try(ObjectInputStream objectIn = new ObjectInputStream(socket.getInputStream());
            FileOutputStream fileOut = new FileOutputStream(Server.restaurants);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){
            Object receivedObject = objectIn.readObject();
            objectOut.writeObject(receivedObject);
            System.out.println("Received: " + receivedObject.toString());

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Restaurant read(){
        try (FileInputStream fileIn = new FileInputStream("Data/restaurants.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            System.out.println("khkhkh");
            Restaurant restaurant = (Restaurant) objectIn.readObject();
            System.out.println("Restaurant "+ restaurant);
            return restaurant;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("exception occurred");
        }
        return null;
    }
}
