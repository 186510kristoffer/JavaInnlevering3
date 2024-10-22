package no.hvl.dat100.oppgave2;

public class Bilde extends Tekst {

    private String url;  // URL for bildet

    // Konstruktør med alle nødvendige parametere (inkludert likes)
    public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
        super(id, bruker, dato, likes, tekst);  // Kaller konstruktøren til superklassen (Tekst)
        this.url = url;  // Setter URL-en for bildet
    }

    // Konstruktør uten likes (valgfritt)
    public Bilde(int id, String bruker, String dato, String tekst, String url) {
        super(id, bruker, dato, tekst);  // Kaller konstruktøren til superklassen (Tekst)
        this.url = url;  // Setter URL-en for bildet
    }

    // Getter for URL
    public String getUrl() {
        return url;
    }

    // Setter for URL
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BILDE\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n" + getTekst() + "\n" + url + "\n";
    }
}
