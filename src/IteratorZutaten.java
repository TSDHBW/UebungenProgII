import java.util.ArrayList;
import java.util.Iterator;

public class IteratorZutaten implements Iterator<Zutat> {

    Zutat mNextZutat;

    public IteratorZutaten (Zutat aHead){

        mNextZutat = aHead;

    }

    @Override
    public boolean hasNext() {
        return mNextZutat !=null;
    }

    @Override
    public Zutat next() {
        Zutat zutat = mNextZutat;
        mNextZutat = mNextZutat.getNextZutat();
        return zutat;
    }
}
