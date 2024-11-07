package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

import java.io.FileWriter;
import java.io.IOException;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        try {
            
            String filsti = mappe + "/" + filnavn;

            
            PrintWriter writer = new PrintWriter(new FileWriter(filsti));

            
            writer.print(samling.toString());

            
            writer.close();
            return true;

        } catch (IOException e) {
            System.out.println("En feil oppstod under skriving til fil: " + e.getMessage());
            return false;
        }
    }
}

