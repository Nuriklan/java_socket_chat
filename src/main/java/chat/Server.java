package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

public class Server implements Runnable {

    private final int port;
    private static int i;

    public Server(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(port);

            Socket s;

            while(true) {
                s = ss.accept();
                System.out.println("New client request received " + s);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                ClientHandler mtch = new ClientHandler(s, "client " + i, dis, dos);
                Thread t = new Thread(mtch);
                t.start();
                i++;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Server(1234));
        t.start();
    }
}