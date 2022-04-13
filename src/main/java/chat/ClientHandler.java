package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final DataInputStream dis;
    private final DataOutputStream dos;
    private final String name;
    private final Socket s;

    public ClientHandler(Socket s, String name,
                         DataInputStream dis, DataOutputStream dos) {
        this.dis = dis;
        this.dos = dos;
        this.name = name;
        this.s = s;
    }

    @Override
    public void run() {
        String received;
        while(true) {
            try {
                received = dis.readUTF();
                System.out.println(received);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                this.dis.close();
                this.dos.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
