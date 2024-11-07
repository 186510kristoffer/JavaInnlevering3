package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Tekst; // Importer Tekst-klassen

public class Blogg {
    
    private Innlegg[] samling; 
    private int nesteLedig;   

    public Blogg() {
        this.samling = new Innlegg[20]; 
        this.nesteLedig = 0; 
    }

    public Blogg(int lengde) {
        this.samling = new Innlegg[lengde]; 
        this.nesteLedig = 0;
    }
 
    public int getAntall() {
        return nesteLedig;  
    }

    public Innlegg[] getSamling() {
        return samling;  
    }

    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < nesteLedig; i++) {
            if (samling[i].erLik(innlegg)) { 
                return i; 
            }
        }
        return -1;  
    }

   
    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;  
    }


    public boolean ledigPlass() {
        return nesteLedig < samling.length; 
    }

    
    public boolean leggTil(Innlegg innlegg) {
        if (finnes(innlegg)) { 
            return false;  
        }
        
        if (ledigPlass()) {  
            samling[nesteLedig] = innlegg;  
            nesteLedig++;  
            return true;  
        } else {
            return false;  
        }
    }

	
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nesteLedig).append("\n");  
        for (int i = 0; i < nesteLedig; i++) {
            sb.append(samling[i].toString());  
        }
        return sb.toString();  
    }


	
    public void utvid() {
        Innlegg[] nySamling = new Innlegg[samling.length * 2];  
        for (int i = 0; i < nesteLedig; i++) {
            nySamling[i] = samling[i];  
        }
        samling = nySamling;  
    }

	
 
    public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)) {
            return false;  
        }
        
        if (!ledigPlass()) {
            utvid();  
        }
        
        samling[nesteLedig] = innlegg;  
        nesteLedig++; 
        return true;
    }

	
 
    public boolean slett(Innlegg innlegg) {
        int indeks = finnInnlegg(innlegg);  
        if (indeks != -1) {  
            for (int i = indeks; i < nesteLedig - 1; i++) {
                samling[i] = samling[i + 1];  
            }
            samling[nesteLedig - 1] = null;  
            nesteLedig--;  
            return true;  
        }
        return false;  
    }

	
 
    public int[] search(String keyword) {
        int[] indekser = new int[nesteLedig];  
        int teller = 0;

        for (int i = 0; i < nesteLedig; i++) {
            if (samling[i] instanceof Tekst) {  
                Tekst tekstInnlegg = (Tekst) samling[i];
                if (tekstInnlegg.getTekst().contains(keyword)) {
                    indekser[teller++] = i;  
                }
            }
        }

        
        int[] resultat = new int[teller];
        for (int i = 0; i < teller; i++) {
            resultat[i] = indekser[i];
        }

        return resultat;  
    }

}