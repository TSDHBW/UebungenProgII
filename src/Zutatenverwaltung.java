import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Iterator;

public class Zutatenverwaltung implements Iterable<Zutat> {

    private Zutat[] zutaten;
    private int index;
    private Zutat mTail;
    private Zutat mHead;
    private int laengeZutatenliste;

    public Zutatenverwaltung (){
        zutaten = new Zutat[100];
        index = 0;
        mTail = null;
        mHead = null;
        laengeZutatenliste = 0;
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
     public boolean setZutat(Zutat zutat){
        boolean anfrageAusgefuert = false;
        for (int i = 0; i < index; i++){
            if (zutaten[i] != null && zutaten[i].getName().equals(zutat.getName())){
                zutaten[i] = zutat;
                anfrageAusgefuert = true;
            }
        }
        if (anfrageAusgefuert){
            System.out.println("Zutat " + zutat.getName() + " aktualisiert");
        } else {
            for (int i = 0; i <= zutaten.length; i++){
                if (zutaten[i] == null) {
                    zutaten[i] = zutat;
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

    public void addZutat(Zutat zutat)
    {

        if (laengeZutatenliste==0)
        {
            mHead = zutat;
            mTail = zutat;
        }else
        {
            //System.out.println("Tail vorher: " + mTail.getName());
            mTail.setNextZutat(zutat);
            mTail=zutat;
            //System.out.println("Tail nachher: " + mTail.getName());
        }

        laengeZutatenliste++;
    }

    @Override
    public Iterator<Zutat> iterator() {
        return new IteratorZutaten(mHead);
    }


}
