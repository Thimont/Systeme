package MiniProjetV1.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Alexis on 11/12/2016.
 */
public class ThreadReception extends Thread{

    Socket clientSocket;
    String chaineModifiee;
    String id;


    public ThreadReception(Socket clientSocket, String id){
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            BufferedReader entreeServeur = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            chaineModifiee = entreeServeur.readLine();

            System.out.println("Message recu" + chaineModifiee);
        } catch (Exception e) {
        }

    }
}
