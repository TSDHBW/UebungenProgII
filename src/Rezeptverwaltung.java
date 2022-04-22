/**
 * Klasse zur Generierung eines Objekts für die Rezeptverwaltung. Jede Rezeptverwaltung besitzt ein Array vom Typ
 * BasisRezept, in dem
 * alle erzeugten Rezepte gespeichert werden.
 * @author Timo
 * @version 1
 */
public class Rezeptverwaltung {

    private BasisRezept[] rezepte;
    private int index;

    public int getIndex() {
        return index;
    }

    public Rezeptverwaltung (){

        rezepte = new BasisRezept[4000];
        index = 0;

    }

    public int ermittleAnzahlRezepte (String typ){

        int anzahl = 0;
        for (int i = 0; i < index; i++){

            if (rezepte[i].getTyp().equals(typ)){

                anzahl++;

            }

        }

        return anzahl;

    }

    public int ermittleAnzahlRezepte (){

        return index;

    }

    public void loescheRezept (String typ, String name) {

        for (int i = 0; i < index; i++){

            if (rezepte[i].getName().equals(name) && rezepte[i].getTyp().equals(typ)){

                rezepte[i] = null;
                System.out.println("Rezept " + name + " wurde gelöscht");

            }
        }
    }

    public void zeigeRezeptAn (String typ, String name){

    }

    public BasisRezept getRezept (String name, String typ){

        for (int i = 0; i < index; i++){

            if (rezepte[i].getName().equals(name) && rezepte[i].getTyp().equals(typ)){

                return rezepte[i];

            }

        }

        return null;

    }

    public void sucheRezeptNachZutat(Zutat zutat){

    }

    public BasisRezept[] getRezepte() {
        return rezepte;
    }

    public void setRezepte (BasisRezept[] rezepte) {
        this.rezepte = rezepte;
    }

    /**
     * Methode zur Aufnahme eines neuen Rezepts in die Rezepteverwaltung. Die Methode prüft zuerst, ob ein Rezept mit
     * gleichem Namen und gleichem Typ bereits in der Rezepteverwaltung existiert. Falls ja, wird das Rezept Zutat
     * aktualisiert. Falls nein, wird geprüft, ob bereits 4000 Rezepte in der Rezeptverwaltung existieren. Falls nein,
     * wird das Rezept aufgenommen
     * @param rezept
     * @return boolean
     */
    public boolean nehmeRezeptAuf (BasisRezept rezept) {

        boolean anfrageAusgefuert = false;
        for (int i = 0; i < index; i++){

            /* Prüfung, ob aktuelle Indexposition des Array mit einem Objekt belegt ist und der Namen des Rezepts
            * im Array dem Namen des übergebenen Rezepts entspricht
            * && bedeutet, dass nach einer fehlerhaften ersten Bedingung, die zweite nicht geprüft wird
            * Falls rezepte[i].getName() bei einer Position ohne Objekt angewendet wird, entsteht eine Exception
            */
            if (rezepte[i] != null && rezepte[i].getName().equals(rezept.getName())){
                rezepte[i] = rezept;
                anfrageAusgefuert = true;
            }
        }
        if (anfrageAusgefuert){
            System.out.println("Rezept " + rezept.getName() + " aktualisiert");
        } else {

            // Durchlaufen des gesamten Arrays, da der Index beim ersten Rezept 0 ist und dadurch die Schleife
            // nie starten würde. Alternativ kann eine separate Behandlung des ersten Falls verwendet werden
            for (int i = 0; i <= rezepte.length; i++){

                // Prüfung, ob aktuelle Indexposition des Array mit keinem Objekt belegt ist
                if (rezepte[i] == null) {

                    rezepte[i] = rezept;

                    // Index wird nur erhöht, falls keine Lücke im Array gefüllt wird
                    if (i > index){
                        index++;
                    }

                    System.out.println("Rezept " + rezept.getName() + " neu aufgenommen");
                    anfrageAusgefuert = true;
                    break;

                }

            }

            if (!anfrageAusgefuert){

                System.out.println("Die Rezeptverwaltung ist voll");

            }

        }
        return anfrageAusgefuert;
    }

}
