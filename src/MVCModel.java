/**
 * Klasse zur Erzeugung des Datenmodells
 * @author Timo
 * @version 1.0
 */
public class MVCModel {

    Rezeptverwaltung rezeptverwaltung;
    Kundenverwaltung kundenverwaltung;
    Zutatenverwaltung zutatenverwaltung;
    Bestellung[] bestellungen;

    public MVCModel(){

        init();

    }

    public void init(){

        rezeptverwaltung = new Rezeptverwaltung();
        kundenverwaltung = new Kundenverwaltung();
        zutatenverwaltung = new Zutatenverwaltung();
        bestellungen = new Bestellung[1000];

        System.out.println("Initialisieren des Datenmodells abgeschlossen");

    }


}