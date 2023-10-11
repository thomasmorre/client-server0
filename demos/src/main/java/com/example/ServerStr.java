package com.example;
import java.io.*;
import java.net.*;
import java.util.*;

    public class ServerStr {
        ServerSocket server = null;
        Socket client = null;
        String stringaRicevuta = null;
        String stringaModificata = null;
        BufferedReader inDalClient;
        DataOutputStream outVersoClient;

        public Socket attendi(){
            try{
                System.out.println("1 nserver partito in esecuzione ...");

                server = new ServerSocket(6789);

                client = server.accept();

                server.close();

                inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                outVersoClient = new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica(){
        
        try{

            System.out.println("3 benvenuto client, scrivi una frase e la trasformo  in maiuscolo. attendo...");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("6 ricevuta la stringa dal cliente : "+ stringaRicevuta);

            stringaModificata=stringaRicevuta.toUpperCase();
            System.out.println("7 invio la stringa modificata al client ...");
            outVersoClient.writeBytes(stringaModificata+'\n');

            System.out.println("9 server: fine elaborazione ... buona notte!");
            client.close();
        }   catch(Exception e){}

    }
}
