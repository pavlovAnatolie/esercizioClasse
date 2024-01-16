package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
           Studente s1 = new Studente("Pippo","Pascal",new Date(2000));
           Studente s2 = new Studente("Anatolie", "Pavlov", new Date(2002));
           Studente s3 = new Studente("Riccardo", "Grandi", new Date(2003));
           Studente s4 = new Studente("Alessio", "Didilescu", new Date(2000));
           Studente s5 = new Studente("Gigi", "Topolone", new Date(2005));


           Classe classe = new Classe(5, "DIA", "08-2W");
           classe.addStudente(s1);
           classe.addStudente(s2);
           classe.addStudente(s3);
           classe.addStudente(s4);
           classe.addStudente(s5);

        try{
           ServerSocket server = new ServerSocket(3000);
            
            System.out.println("il server è in ascolto");
            Socket s = server.accept();
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            XmlMapper xmlMapper = new XmlMapper();
            String cls = xmlMapper.writeValueAsString(classe);
            System.out.println(cls);

            server.accept();  

            out.writeBytes(cls+"\n");


            s.close();
            server.close();

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       

    }
}