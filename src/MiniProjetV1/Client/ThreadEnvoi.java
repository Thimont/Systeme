package MiniProjetV1.Client;

import java.io.BufferedReader;
import java.io.DataOutputStream;

/**
 * Created by Alexis on 11/12/2016.
 */
public class ThreadEnvoi extends Thread {

    String type_message = "-1";
    String type_service = "-1";
    BufferedReader entreeClavier;
    String idDestinataire = "defaultDest";
    String message = "HELLO";
    String chaine;
    DataOutputStream sortieServeur;
    String id;

    public ThreadEnvoi(BufferedReader entreeClavier, DataOutputStream sortieServeur, String id) {

        this.entreeClavier = entreeClavier;
        this.sortieServeur = sortieServeur;
        this.id = id;
    }

    public void run() {

        while(true)
        try {
            System.out.println("Type de message ?");
            System.out.println("1:Services");
            System.out.println("2:Données");
            type_message = entreeClavier.readLine();

            if (type_message.equals("1")) {
                System.out.println("Type de service ?");
                System.out.println("1:Demande d'abonnement");
                System.out.println("2:Demande de desabonnement");
                type_service = entreeClavier.readLine();

                if(type_service.equals("1")){
                    message = ":"+"S"+":"+"1"+":"+id+":";
                }

                if(type_service.equals("2")){
                    message = ":"+"S"+":"+"2"+":"+id+":";
                }
            }

            if (type_message.equals("2")) {
                System.out.println("A qui ?");
                idDestinataire = entreeClavier.readLine();
                System.out.println("Ecrivez votre message (<=128 caracteres):");
                message = entreeClavier.readLine();
                message = ":D:"+idDestinataire+":"+id+":"+message+":";
            }

            sortieServeur.writeBytes(message + '\n');

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}