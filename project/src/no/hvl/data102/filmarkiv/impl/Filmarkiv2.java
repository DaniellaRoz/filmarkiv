package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    private Node foersteNode;
    private int antall;

    public Filmarkiv2() {
        foersteNode = null;
        antall = 0;
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
        Node iterasjon = foersteNode;

        while (iterasjon != null) {
            if (iterasjon.data.getFilmnr() == nr) {
                return iterasjon.data;
            }

            iterasjon = iterasjon.neste;
        }

        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        Node iterasjon = foersteNode;

        if (foersteNode != null) {
            while (iterasjon.neste != null) {
                iterasjon = iterasjon.neste;
            }

            iterasjon.neste = new Node(nyFilm, null);
            antall++;
        } else {
            foersteNode = new Node(nyFilm, null);
            antall++;
        }
    }

    @Override
    public boolean slettFilm(int filmnr) {
        // tidlig return hvis listen er tom
        if (foersteNode == null) {
            return false;
        }

        // hvis noden som skal slettes er den første
        if (foersteNode.data.getFilmnr() == filmnr) {
            foersteNode = foersteNode.neste;
            antall--;
            return true;
        }

        Node iterasjon = foersteNode;
        Node forrige = null; // nullpointerexception er ikke et problem fordi hvis første node slettes skjer en tidlig return

        while (iterasjon != null) {
            if (iterasjon.data.getFilmnr() == filmnr) {
                // Hvis noden som skal slettes er den siste eller vanlig
                forrige.neste = iterasjon.neste;
                antall--;
                return true;
            }
            
            forrige = iterasjon;
            iterasjon = iterasjon.neste;
        }

        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Node iterasjon = foersteNode;
        Film[] returnTab = new Film[100];
        int returnAntallTab = 0;

        while (iterasjon != null) {
            if (iterasjon.data.getTittel().contains(delstreng)) {
                returnTab[returnAntallTab] = iterasjon.data;
                returnAntallTab++;
            }

            iterasjon = iterasjon.neste;
        }

        return trimTab(returnTab, returnAntallTab);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Node iterasjon = foersteNode;
        Film[] returnTab = new Film[100];
        int returnAntallTab = 0;

        while (iterasjon != null) {
            if (iterasjon.data.getProdusent().contains(delstreng)) {
                returnTab[returnAntallTab] = iterasjon.data;
                returnAntallTab++;
            }

            iterasjon = iterasjon.neste;
        }

        return trimTab(returnTab, returnAntallTab);
    }

    @Override
    public int antall(Sjanger sjanger) {
        Node iterasjon = foersteNode;
        int sjangerAntall = 0;

        while (iterasjon != null) {
            if (iterasjon.data.getSjanger().equals(sjanger)) {
                sjangerAntall++;
            }

            iterasjon = iterasjon.neste;
        }

        return sjangerAntall;
    }

    @Override
    public int antall() {
        return antall;
    }

    private class Node {
        private Film data;
        private Node neste;

        private Node(Film datadel) {
            this(datadel, null);
        }

        private Node(Film datadel, Node nesteNode) {
            data = datadel;
            neste = nesteNode;
        }
    }
}
