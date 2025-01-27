package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import java.util.Scanner;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start() {
        filmarkiv.leggTilFilm(new Film(1, "christopher nolan", "interstellar", 2014, "scifi", "paramount"));
        filmarkiv.leggTilFilm(new Film(2, "alex garland", "civil war", 2024, "krig", "a24"));
        filmarkiv.leggTilFilm(new Film(3, "sidney lumet", "12 angry men", 1957, "drama", "orion-nova productions"));
        filmarkiv.leggTilFilm(new Film(4, "martin scorsese", "the wolf of wall street", 2013, "komedie", "red granite pictures"));
        filmarkiv.leggTilFilm(new Film(5, "elem klimov", "come and See", 1985, "krig", "belarusfilm" ));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Velkommen til filmarkivet. Skriv in kommandoen du ønsker å utføre\n");

        boolean kjoerer = true;

        while (kjoerer) {
            System.out.print("'finn film', 'legg til film', 'skriv ut statistikk', 'slett film', 'avslutt'\n> ");
            switch (scanner.nextLine().toLowerCase()) {
                case "finn film", "finn" -> {
                    System.out.print("vil du søke etter tittel eller produsent?\n> ");
                    switch (scanner.nextLine().toLowerCase()) {
                        case "tittel" -> {
                            System.out.print("Tittel eller del av tittel: ");
                            tekstgr.skrivUtDelstrengITittel(filmarkiv, scanner.nextLine().toLowerCase());
                        }
                        case "produsent" -> {
                            System.out.print("Navn eller del av navn: ");
                            tekstgr.skrivUtFilmProdusent(filmarkiv, scanner.nextLine().toLowerCase());
                        }
                        default -> System.out.println("ukjent kommando, returnerer til hovedmeny\n");
                    }
                }
                case "legg til film", "legg til" -> tekstgr.leggTilFilm(filmarkiv);
                case "skriv ut statistikk", "statistikk" -> tekstgr.skrivUtStatistikk(filmarkiv);
                case "slett film", "slett" -> {
                    System.out.print("Filmnummer: ");
                    if (tekstgr.slettFilm(filmarkiv, scanner.nextInt())) {
                        System.out.println("Slettet film.\n");
                    } else {
                        System.out.println("Fant ikke film.\n");
                    }
                }
                case "avslutt", "quit" -> {
                    kjoerer = false;
                }
                default -> System.out.println("Ukjent kommando. Vær så snill og prøv igjen.\n");
            }
        }
    }
}
