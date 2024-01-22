package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Socket;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        try {
            Socket s = new Socket("localhost", 3000);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            XmlMapper xmlMapper = new XmlMapper();
            Classe classe = xmlMapper.readValue(in.readLine(), Classe.class);
            System.out.println(classe.toString());
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}