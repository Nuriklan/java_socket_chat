package chat;

import junit.framework.TestCase;

import static java.lang.Thread.sleep;

public class ServerTest extends TestCase {
    public void testRun() throws InterruptedException {
        Server server = new Server(1234);
        Thread t = new Thread(server);

        t.start();
    }
}
