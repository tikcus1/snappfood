package server ;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static int RestaurantCounts;
    static File usersAccounts;
    public static File restaurants;

    public static void main(String[] args) throws IOException {

        System.out.println("server is running");

        ServerSocket serverSocket = new ServerSocket(8335);

        usersAccounts = new File("src/Data/usersAccounts.txt");
        restaurants = new File("src/Data/restaurants.ser");

        int cntClient = 0;

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("client " + ++cntClient + " connected");
            try{
                new ServeSearch(socket, cntClient);
            }catch (IOException e){
                System.out.println("kh");
                e.printStackTrace();
                socket.close();
            }
        }
    }
}
