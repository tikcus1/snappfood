package server;

import java.io.*;
import java.net.Socket;

public class ServeSearch extends Thread{
    public Socket socket;
    PrintWriter out;
    BufferedReader in;
    PrintWriter fileWriter;

    BufferedReader fileReader;
    String[] command;

    int clientNumber;

    public ServeSearch(Socket socket, int clientNumber) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.clientNumber = clientNumber;
        start();
    }
    public void run() {
        while (!socket.isClosed()) {
            try {
                command = in.readLine().split("/");
                switch (command[0]) {
                    case "login":
                        out.println(searchUser(command[1], command[2]));
                        break;
                    case "register":
                        System.out.println("register");
                        if(searchUserName(command[1])){
                            out.println("false");
                        }
                        else {
                            fileWriter = new PrintWriter(new BufferedWriter(new FileWriter(Server.usersAccounts, true)), true);
                            fileWriter.println(command[1] + "/" + command[2]);
                            fileWriter.close();
                            out.println("true");
                        }
                        break;
                }
            } catch (IOException exception) {
                System.out.println("client " + clientNumber + " has closed");
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        fileWriter.close();
        System.out.println("serve is closed");
    }

    private boolean searchUserName(String userName) throws IOException {
        fileReader = new BufferedReader(new FileReader(Server.usersAccounts));
        String str;
        while (fileReader.ready()){
            str = fileReader.readLine().split("/")[0];
            if (str.equals(userName))
                return true;
        }
        fileReader.close();
        return false;
    }
    private boolean searchUser(String userName, String pass) throws IOException {
        fileReader = new BufferedReader(new FileReader(Server.usersAccounts));
        String[] str;
        while (fileReader.ready()){
            str = fileReader.readLine().split("/");
            if(str[0].equals(userName) && str[1].equals(pass))
                return true;
        }
        fileReader.close();
        return false;
    }
}
