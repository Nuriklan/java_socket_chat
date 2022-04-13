package chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {

    private final int port;
    private InetAddress ip;

    public Client(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            this.ip = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            Socket s = new Socket(ip, this.port);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Thread t = new Thread(new Client(1234));
        t.start();
    }
}
