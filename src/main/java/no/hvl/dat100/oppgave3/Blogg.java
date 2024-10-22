package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.Tekst; // Importer Tekst-klassen

public class Blogg {
    
    private Innlegg[] samling; // array av innlegg
    private int nesteLedig;    // teller for hvor mange innlegg som er lagt til

    // Standard konstruktør
    public Blogg() {
        this.samling = new Innlegg[20]; // Standard kapasitet på 20 innlegg
        this.nesteLedig = 0; // Ingen innlegg er lagt til enda
    }

    // Konstruktør med parameter
    public Blogg(int lengde) {
        this.samling = new Innlegg[lengde]; // Kapasiteten settes til den spesifikke lengden
        this.nesteLedig = 0; // Ingen innlegg er lagt til enda
    }



 // Returnerer antall innlegg i samlingen
    public int getAntall() {
        return nesteLedig;  // Dette er antallet innlegg som er lagret
    }

    // Returnerer hele samlingen (arrayet) av innlegg
    public Innlegg[] getSamling() {
        return samling;  // Returnerer arrayet som inneholder innleggene
    }

	
 // Finner et innlegg i samlingen og returnerer indeksen hvis det finnes, ellers -1
    public int finnInnlegg(Innlegg innlegg) {
        for (int i = 0; i < nesteLedig; i++) {
            if (samling[i].erLik(innlegg)) { // Bruker erLik for å sjekke om innleggene er like
                return i;  // Returnerer indeksen der innlegget ble funnet
            }
        }
        return -1;  // Returnerer -1 hvis innlegget ikke finnes
    }

    // Sjekker om et innlegg finnes i samlingen
    public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;  // Hvis finnInnlegg returnerer noe annet enn -1, finnes innlegget
    }


 // Sjekker om det finnes ledig plass i samlingen
    public boolean ledigPlass() {
        return nesteLedig < samling.length;  // True hvis det er plass igjen i arrayet
    }

    // Legger til et nytt innlegg hvis det finnes ledig plass og innlegget ikke allerede finnes
    public boolean leggTil(Innlegg innlegg) {
        if (finnes(innlegg)) {  // Sjekker om innlegget allerede finnes
            return false;  // Returnerer false hvis innlegget allerede er i samlingen
        }
        
        if (ledigPlass()) {  // Sjekker om det er plass
            samling[nesteLedig] = innlegg;  // Legger til innlegget på neste ledige plass
            nesteLedig++;  // Øker antall innlegg
            return true;  // Returnerer true når innlegget er lagt til
        } else {
            return false;  // Returnerer false hvis det ikke er plass
        }
    }

	
 // Returnerer en tekstlig representasjon av bloggen
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nesteLedig).append("\n");  // Første linje inneholder antall innlegg
        for (int i = 0; i < nesteLedig; i++) {
            sb.append(samling[i].toString());  // Legger til innleggene i samlingen
        }
        return sb.toString();  // Returnerer hele strengen
    }


	// valgfrie oppgaver nedenfor
	
 // Utvider arrayet 'samling' hvis det ikke er plass
    public void utvid() {
        Innlegg[] nySamling = new Innlegg[samling.length * 2];  // Dobbler størrelsen
        for (int i = 0; i < nesteLedig; i++) {
            nySamling[i] = samling[i];  // Kopierer innleggene fra det gamle arrayet til det nye
        }
        samling = nySamling;  // Oppdaterer referansen til det nye arrayet
    }

	
 // Legger til et nytt innlegg, og utvider arrayet hvis det ikke er plass
    public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)) {
            return false;  // Hvis innlegget allerede finnes, returnerer false
        }
        
        if (!ledigPlass()) {
            utvid();  // Utvider arrayet hvis det ikke er plass
        }
        
        samling[nesteLedig] = innlegg;  // Legger til innlegget
        nesteLedig++;  // Øker antall innlegg
        return true;
    }

	
 // Sletter et innlegg hvis det finnes i samlingen
    public boolean slett(Innlegg innlegg) {
        int indeks = finnInnlegg(innlegg);  // Finn indeksen til innlegget
        if (indeks != -1) {  // Hvis innlegget finnes
            for (int i = indeks; i < nesteLedig - 1; i++) {
                samling[i] = samling[i + 1];  // Flytter innleggene ett hakk oppover
            }
            samling[nesteLedig - 1] = null;  // Fjerner det siste elementet som nå er duplisert
            nesteLedig--;  // Reduserer antall innlegg
            return true;  // Returnerer true når innlegget er slettet
        }
        return false;  // Returnerer false hvis innlegget ikke ble funnet
    }

	
 // Søker etter innlegg som inneholder et nøkkelord
    public int[] search(String keyword) {
        int[] indekser = new int[nesteLedig];  // Midlertidig array for å holde indekser
        int teller = 0;

        for (int i = 0; i < nesteLedig; i++) {
            if (samling[i] instanceof Tekst) {  // Bare tekstinnlegg kan inneholde nøkkelord
                Tekst tekstInnlegg = (Tekst) samling[i];
                if (tekstInnlegg.getTekst().contains(keyword)) {
                    indekser[teller++] = i;  // Legger til indeksen hvis nøkkelordet finnes
                }
            }
        }

        // Kopierer de relevante indeksene til et nytt array med riktig størrelse
        int[] resultat = new int[teller];
        for (int i = 0; i < teller; i++) {
            resultat[i] = indekser[i];
        }

        return resultat;  // Returnerer arrayet med indeksene
    }

}