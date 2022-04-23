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

    public int getIndex() {
        return index;
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

    public void loescheZutat (String name) {

        for (int i = 0; i < index; i++){

            if (zutaten[i].getName().equals(name)){

                zutaten[i] = null;
                System.out.println("Zutat " + name + " wurde gelöscht");

            }
        }
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

            /* Prüfung, ob aktuelle Indexposition des Array mit einem Objekt belegt ist und der Namen der Zutat
             * im Array dem Namen der übergebenen Zutat entspricht
             * && bedeutet, dass nach einer fehlerhaften ersten Bedingung, die zweite nicht geprüft wird
             * Falls zutaten[i].getName() bei einer Position ohne Objekt angewendet wird, entsteht eine Exception
             */

            if (zutaten[i] != null && zutaten[i].getName().equals(zutat.getName())){
                zutaten[i] = zutat;
                anfrageAusgefuert = true;
            }
        }
        if (anfrageAusgefuert){
            System.out.println("Zutat " + zutat.getName() + " aktualisiert");
        } else {

            // Durchlaufen des gesamten Arrays, da der Index beim ersten Rezept 0 ist und dadurch die Schleife
            // nie starten würde. Alternativ kann eine separate Behandlung des ersten Falls verwendet werden
            for (int i = 0; i <= zutaten.length; i++){

                // Prüfung, ob aktuelle Indexposition des Array nicht keinem Objekt belegt ist
                if (zutaten[i] == null) {

                    zutaten[i] = zutat;

                    // Index wird nur erhöht, falls kein Lücke im Array gefüllt wird
                    if (i >= index){
                        index++;
                    }

                    System.out.println("Zutat " + zutat.getName() + " neu aufgenommen");
                    anfrageAusgefuert = true;
                    break;

                }

            }

            if (!anfrageAusgefuert){

                System.out.println("Die Zutatenverwaltung ist voll");

            }

        }
     return anfrageAusgefuert;
    }

}
