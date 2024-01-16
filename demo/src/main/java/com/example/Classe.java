package com.example;

import java.util.ArrayList;

public class Classe {
    private String sezione;
    private String coordinatore;
    private ArrayList<Studente> studenti;

    public Classe(String s, String c){
        sezione = s;
        coordinatore= c;
        studenti = new ArrayList<>();
    }

    public void addStudente(Studente s){
        studenti.add(s);
    }

    public String inviaOggetto(){
        String o = "";
        o = o +"classe: "+ sezione +" Coordinatore: "+coordinatore;
        for (Studente studente : studenti) {
            o = o + studente.toString();
            o= o;
        }
        

        return o;
    }
}
