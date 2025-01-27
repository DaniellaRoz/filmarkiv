package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {
    private Film[] arkiv;
    private int antall;

    public Filmarkiv(int stoerrelse) {
        arkiv = new Film[stoerrelse];
        antall = 0;
    }

    public Film[] getArkiv() {
        return arkiv;
    }

    public void setArkiv(Film[] arkiv) {
        this.arkiv = arkiv;
    }

    public int getAntall() {
        return antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }

        return nytab;
    }

    @Override
    public Film finnFilm(int nr) {
        for (Film film : arkiv) {
            if (film != null) {
                if (film.getFilmnr() == nr) {
                    return film;
                }
            }
        }

        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == arkiv.length) {
            arkiv = Arrays.copyOf(arkiv, arkiv.length * 2);
        }

        arkiv[antall] = nyFilm;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if (arkiv[i].getFilmnr() == filmnr) {
                for (int j = i + 1; j < arkiv.length; j++) {
                    arkiv[j - 1] = arkiv[j];
                }

                antall--;
                arkiv[antall] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] returnTab = new Film[arkiv.length];
        int returnTabAntall = 0;

        for (Film film : arkiv) {
            if (film != null) {
                if (film.getTittel().contains(delstreng)) {
                    returnTab[returnTabAntall] = film;
                    returnTabAntall++;
                }
            }
        }

        return trimTab(returnTab, returnTabAntall);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] returnTab = new Film[arkiv.length];
        int returnTabAntall = 0;

        for (Film film : arkiv) {
            if (film != null) {
                if (film.getProdusent().contains(delstreng)) {
                    returnTab[returnTabAntall] = film;
                    returnTabAntall++;
                }
            }
        }

        return trimTab(returnTab, returnTabAntall);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int sjangerAntall = 0;

        for (Film film : arkiv) {
            if (film != null) {
                if (film.getSjanger().equals(sjanger)) {
                    sjangerAntall++;
                }
            }
        }

        return sjangerAntall;
    }

    @Override
    public int antall() {
        return antall;
    }
}
