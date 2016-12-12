package MiniProjetV1.Server;

import java.io.IOException;

/**
 * Created by flthiebl on 12/12/2016.
 */
public class MainServer {

    public static void main(String[] args) {
        theServer server = new theServer();

        while (true) {
            server.run();
        }
    }

}
