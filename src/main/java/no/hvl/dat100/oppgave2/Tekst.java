package no.hvl.dat100.oppgave2;

import no.hvl.dat100.oppgave1.Innlegg;

public class Tekst extends Innlegg {

    private String tekst;  // Objektvariabel for å lagre teksten

    // Standard konstruktør
    public Tekst() {
        super();  // Kaller superklassens konstruktør (Innlegg)
    }

    // Konstruktør med tekstparameter
    public Tekst(int id, String bruker, String dato, String tekst) {
        super(id, bruker, dato);  // Kaller superklassens konstruktør
        this.tekst = tekst;  // Initialiserer teksten
    }

    // Konstruktør med likes
    public Tekst(int id, String bruker, String dato, int likes, String tekst) {
        super(id, bruker, dato, likes);  // Kaller superklassens konstruktør
        this.tekst = tekst;  // Initialiserer teksten
    }

    // Henter teksten fra innlegget
    public String getTekst() {
        return tekst;  // Returnerer teksten
    }

    // Setter teksten for innlegget
    public void setTekst(String tekst) {
        this.tekst = tekst;  // Oppdaterer teksten
    }

    @Override
    public String toString() {
        // Returnerer en strengrepresentasjon av tekstinnlegget
        return super.toString() + tekst + "\n";
    }

    // Metoden nedenfor er kun for valgfri oppgave 6
    public String toHTML() {
        // Valgfritt: Returnerer innlegget i HTML-format
        return "<p>" + tekst + "</p>";
    }
}
