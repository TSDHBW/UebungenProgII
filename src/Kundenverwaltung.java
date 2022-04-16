public class Kundenverwaltung {

    private Kunde[] kunden;
    private int index;

    /**
     * Konstruktor fuer ein Objekt der Klasse Kundenverwaltung. Der Index wird zum Zeitpunkt der Erzeugung auf 1 gesetzt.
     */
    public Kundenverwaltung (){

        index = 1;

    }

    public void nehmeKundeAuf (Kunde kunde) {

    }

    public Kunde sucheKunde (String name) {

        return null;

    }

    public Kunde[] getKunden() {
        return kunden;
    }

    public void setKunden(Kunde[] kunden) {
        this.kunden = kunden;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
