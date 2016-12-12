package MiniProjetV1.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String id = "Florian";

        String adresseServeur = "127.0.0.1";
       int portServeur =6789;
        //Adresse prof :172.19.5.18:14586

        Socket clientSocket;

        DataOutputStream sortieServeur;


        try {
            //CONNEXION AU SERVEUR
            BufferedReader entreeClavier = new BufferedReader(new InputStreamReader(System.in));

            Scanner scanner = new Scanner(System.in);

            System.out.println("Demande de connexion");
            clientSocket = new Socket(adresseServeur, portServeur);
            System.out.println("Connexion detectée");

            /*//CHOIX UTILISATEUR
            System.out.println("Indiquez identifiant (<=10 caracteres:");*/

            id = scanner.next();
            //id = entreeClavier.readLine();

            //ENVOI ID
            sortieServeur = new DataOutputStream(clientSocket.getOutputStream());
            //sortieServeur.writeBytes(id + '\n');


            //THREAD GESTION ENVOI
            ThreadEnvoi thEnvoi = new ThreadEnvoi(entreeClavier, sortieServeur, id);
            thEnvoi.start();

            //THREAD GESTION RECEPTION
            ThreadReception thReception = new ThreadReception(clientSocket, id);
            thReception.start();

 //           clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
