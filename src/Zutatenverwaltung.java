/**
 * Klasse zur Generierung eines Objekts für die Zutatenverwaltung. Jede Zutatenverwaltung besitzt ein Array, in dem
 * alle erzeugten Zutaten gespeichert werden.
 * @author Timo
 * @version 1
 */public class Zutatenverwaltung {

    private Zutat[] zutaten;
    private int index;

    public Zutatenverwaltung (){

        zutaten = new Zutat[100];
        index = 0;

    }

    public Zutat[] getZutaten() {
        return zutaten;
    }

    public void setZutaten(Zutat[] zutaten) {
        this.zutaten = zutaten;
    }

    public Zutat getZutat(String name){

        for (int i = 0; i < index; i++){

            if (zutaten[i].getName().equals(name)){

                return zutaten[i];

            }

        }

        return null;

    }

    /**
     * Methode zur Aufnahme einer neuen Zutat in die Zutatenverwaltung. Die Methode prüft zuerst, ob eine Zutat mit
     * gleichem Namen bereits in der Zutatenverwaltung existiert. Falls ja, wird die Zutat aktualisiert. Falls nein,
     * wird geprüft, ob bereits 100 Zutaten in der Zutatenverwaltung existiieren. Falls nein, wird die Zutat
     * aufgenommen
     * @param zutat
     * @return boolean
     */
     public boolean setZutat(Zutat zutat){

        boolean anfrageAusgefuert = false;
        for (int i = 0; i < index; i++){
            if (zutaten[i].getName().equals(zutat.getName())){
                zutaten[i] = zutat;
                anfrageAusgefuert = true;
            }
        }
        if (anfrageAusgefuert){
            System.out.println("Zutat " + zutat.getName() + " aktualisiert");
        } else {

            if (index < 99) {

                zutaten[index] = zutat;
                index++;
                System.out.println("Zutat " + zutat.getName() + " neu aufgenommen");
                anfrageAusgefuert = true;

            } else {

                System.out.println("Die Zutatenverwaltung ist voll");

            }
        }
     return anfrageAusgefuert;
    }

}
