package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Tekstgrensesnitt {
    public Film lesFilm() {
        Film film = new Film();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Filmnummer: ");
        film.setFilmnr(Integer.parseInt(scanner.nextLine()));
        System.out.print("Produsent: ");
        film.setProdusent(scanner.nextLine().toLowerCase());
        System.out.print("Tittel: ");
        film.setTittel(scanner.nextLine().toLowerCase());
        System.out.print("År: ");
        film.setAar(Integer.parseInt(scanner.nextLine()));
        System.out.print("Sjanger: ");
        film.setSjanger(scanner.nextLine());
        System.out.print("Filmselskap: ");
        film.setFilmselskap(scanner.nextLine().toLowerCase());

        return film;
    }

    private void skrivUtFilm(Film film) {
        System.out.println("Filmnummer: " + film.getFilmnr());
        System.out.println("Produsent: " + film.getProdusent());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("År: " + film.getAar());
        System.out.println("Sjanger: " + film.getSjanger().toString().toLowerCase());
        System.out.println("Filmselskap: " + film.getFilmselskap() + "\n");
    }

    public void skrivUtDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        for (Film film : arkiv.soekTittel(delstreng)) {
            skrivUtFilm(film);
        }
    }

    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        for (Film film : arkiv.soekProdusent(delstreng)) {
            skrivUtFilm(film);
        }
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer i arkivet: " + arkiv.antall());
        System.out.println("Per sjanger");

        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println(sjanger.toString().toLowerCase() + ": " + arkiv.antall(sjanger));
        }

        System.out.print("\n");
    }

    public void leggTilFilm(FilmarkivADT arkiv) {
        arkiv.leggTilFilm(lesFilm());
    }

    public boolean slettFilm(FilmarkivADT arkiv, int filmnr) {
        return arkiv.slettFilm(filmnr);
    }
}
