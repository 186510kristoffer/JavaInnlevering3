package no.hvl.dat100.oppgave2;

public class Bilde extends Tekst {

    private String url; 

   
    public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
        super(id, bruker, dato, likes, tekst);  
        this.url = url; 
    }

    
    public Bilde(int id, String bruker, String dato, String tekst, String url) {
        super(id, bruker, dato, tekst);  
        this.url = url;  
    }

    
    public String getUrl() {
        return url;
    }

    
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BILDE\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n" + getTekst() + "\n" + url + "\n";
    }
    @Override
    public String toHTML() {
        return "<div class='innlegg'>\n" +
               "<h2>" + getBruker() + "</h2>\n" +
               "<p><em>" + getDato() + "</em></p>\n" +
               "<p>" + getTekst() + "</p>\n" +
               "<img src='" + getUrl() + "' alt='Bilde' />\n" +
               "</div>\n";
    }

}
