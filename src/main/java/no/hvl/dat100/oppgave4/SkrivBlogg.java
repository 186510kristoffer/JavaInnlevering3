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
            // Oppretter en filsti fra mappen og filnavnet
            String filsti = mappe + "/" + filnavn;

            // Åpner filen for skriving (overskriver eksisterende innhold)
            PrintWriter writer = new PrintWriter(new FileWriter(filsti));

            // Skriver innholdet fra samlingen til filen
            writer.print(samling.toString());

            // Lukker skrivingen og returnerer true
            writer.close();
            return true;

        } catch (IOException e) {
            // Håndterer eventuelle unntak og returnerer false ved feil
            System.out.println("En feil oppstod under skriving til fil: " + e.getMessage());
            return false;
        }
    }
}

