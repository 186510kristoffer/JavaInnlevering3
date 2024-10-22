package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;

public class Bilde extends Tekst {

    private String url;
    private int likes;

    public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
        super(id, bruker, dato, tekst);
        this.url = url;
        this.likes = likes;
    }

    public String getUrl1() {
        return url;
    }

    public void setUrl1(String url) {
        this.url = url;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getUrl() {
        return url;

    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Bilde [id=" + getId() + 
                   ", bruker=" + getBruker() + 
                   ", dato=" + getDato() + 
                   ", likes=" + likes + 
                   ", tekst=" + getTekst() + 
                   ", url=" + url + "]";

    }
}
