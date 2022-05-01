import java.util.Iterator;

public class IteratorRezepte implements Iterator<BasisRezept> {

    public BasisRezept[] mRezepte;
    public int mIndex;

    public IteratorRezepte(BasisRezept[] aRezepte){

        mRezepte = aRezepte;
        mIndex = 0;

    }

    @Override
    public boolean hasNext() {

        if (mRezepte[mIndex]!=null){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public BasisRezept next() {
        BasisRezept rezept = mRezepte[mIndex];
        mIndex++;
        return rezept;
    }
}
