import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        while (true) {

            System.out.println("server is running");

            ServerSocket serverSocket = new ServerSocket(8335);

            Socket socket = serverSocket.accept();

            System.out.println("client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String userName = in.readLine();
                String password = in.readLine();
                System.out.println(userName);
                System.out.println(password);
                out.println(userName.equals("Matin") && password.equals("1234"));
            }
        }
    }
}
