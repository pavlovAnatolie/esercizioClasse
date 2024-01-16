package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
           ServerSocket server = new ServerSocket(3000);

           Studente s1 = new Studente("Pippo", "Pascal", 15);
           Studente s2 = new Studente("Anatolie", "Pavlov", 20);
           Studente s3 = new Studente("Riccardo", "Grandi", 19);
           Studente s4 = new Studente("Alessio", "Didilescu", 18);
           Studente s5 = new Studente("Gigi", "Topolone", 4);


           Classe classe = new Classe("5DIA", "Francesco Capezio");
           classe.addStudente(s1);
           classe.addStudente(s2);
           classe.addStudente(s3);
           classe.addStudente(s4);
           classe.addStudente(s5);


           System.out.println("il server è in ascolto");
           Socket s = server.accept();

           DataOutputStream out = new DataOutputStream(s.getOutputStream());

            out.writeBytes(classe.inviaOggetto()+"\n");

            s.close();
            server.close();

        server.accept();  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       

    }
}