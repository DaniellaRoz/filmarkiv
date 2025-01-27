package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Filmarkiv2Test {

    private FilmarkivADT filmarkiv;

    @BeforeEach
    void setUp() {
        filmarkiv = new Filmarkiv2();
    }

    @Test
    void testLeggTilFilm() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "action", "Selskap1");
        filmarkiv.leggTilFilm(film1);
        assertEquals(1, filmarkiv.antall());
        assertEquals(film1, filmarkiv.finnFilm(1));
    }

    @Test
    void testFinnFilm() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "action", "Selskap1");
        filmarkiv.leggTilFilm(film1);
        assertEquals(film1, filmarkiv.finnFilm(1));
        assertNull(filmarkiv.finnFilm(2));
    }

    @Test
    void testSlettFilm() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "action", "Selskap1");
        filmarkiv.leggTilFilm(film1);
        assertTrue(filmarkiv.slettFilm(1));
        assertEquals(0, filmarkiv.antall());
        assertFalse(filmarkiv.slettFilm(2));
    }

    @Test
    void testSoekTittel() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "action", "Selskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2021, "komedie", "Selskap2");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        Film[] result = filmarkiv.soekTittel("Tittel1");
        assertEquals(1, result.length);
        assertEquals(film1, result[0]);
    }

    @Test
    void testSoekProdusent() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "action", "Selskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2021, "komedie", "Selskap2");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        Film[] result = filmarkiv.soekProdusent("Produsent1");
        assertEquals(1, result.length);
        assertEquals(film1, result[0]);
    }

    @Test
    void testAntallSjanger() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "action", "Selskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2021, "action", "Selskap2");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        assertEquals(2, filmarkiv.antall(Sjanger.ACTION));
        assertEquals(0, filmarkiv.antall(Sjanger.DRAMA));
    }

    @Test
    void testAntall() {
        Film film1 = new Film(1, "Produsent1", "Tittel1", 2020, "action", "Selskap1");
        Film film2 = new Film(2, "Produsent2", "Tittel2", 2021, "komedie", "Selskap2");
        filmarkiv.leggTilFilm(film1);
        filmarkiv.leggTilFilm(film2);

        assertEquals(2, filmarkiv.antall());
    }
}