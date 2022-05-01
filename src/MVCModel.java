import java.io.*;

public class MVCModel {

    Rezeptverwaltung rezeptverwaltung;
    Zutatenverwaltung zutatenverwaltung;

    public MVCModel(){
        init();
    }

    public void init(){

        rezeptverwaltung = new Rezeptverwaltung();
        zutatenverwaltung = new Zutatenverwaltung();
        System.out.println("Initialisieren des Datenmodells abgeschlossen");
    }

}