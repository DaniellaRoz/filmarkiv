package no.hvl.data102.filmarkiv.impl;

public class Film {
    private int filmnr;
    private String produsent;
    private String tittel;
    private int aar;
    private Sjanger sjanger;
    private String filmselskap;

    // -1 betyr at det ikke har en gitt verdi
    public Film() {
        filmnr = -1;
        produsent = "";
        tittel = "";
        aar = -1;
        sjanger = Sjanger.INGEN;
        filmselskap = "";
    }

    public Film(int filmnr, String produsent, String tittel, int aar, String sjanger, String filmselskap) {
        this.filmnr = filmnr;
        this.produsent = produsent;
        this.tittel = tittel;
        this.aar = aar;
        this.sjanger = Sjanger.finnSjanger(sjanger);
        this.filmselskap = filmselskap;
    }

    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getProdusent() {
        return produsent;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getAar() {
        return aar;
    }

    public void setAar(int aar) {
        this.aar = aar;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(String sjanger) {
        this.sjanger = Sjanger.finnSjanger(sjanger);
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }
}
