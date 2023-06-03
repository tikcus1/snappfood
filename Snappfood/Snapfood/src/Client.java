import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("client started");
        Socket socket = new Socket("localhost", 8335) ;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true) ;
        out.println(System.in);
        out.println(System.in);
        System.out.println(in.readLine());
    }
}
