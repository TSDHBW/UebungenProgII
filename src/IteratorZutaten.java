import java.util.ArrayList;
import java.util.Iterator;

public class IteratorZutaten implements Iterator<Zutat> {

    ArrayList<Zutat> mZutatenListe;

    public IteratorZutaten (ArrayList<Zutat> aZutatenliste){

        mZutatenListe = aZutatenliste;

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Zutat next() {
        return null;
    }
}
