
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
    public boolean nehmeRezeptAuf (BasisRezept rezept) {
        boolean anfrageAusgefuert = false;
        for (int i = 0; i < index; i++){
            if (rezepte[i] != null && rezepte[i].getName().equals(rezept.getName())){
                rezepte[i] = rezept;
                anfrageAusgefuert = true;
            }
        }
        if (anfrageAusgefuert){
            System.out.println("Rezept " + rezept.getName() + " aktualisiert");
        } else {
            for (int i = 0; i <= rezepte.length; i++){
                if (rezepte[i] == null) {
                    rezepte[i] = rezept;
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
