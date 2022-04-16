public class PastaGericht extends BasisRezeptEssen {

    private String nudelsorte;
    private boolean vorspeise;

    public PastaGericht (String name, Zutat[]zutaten, boolean vegetarisch, boolean vegan, String nudelsorte,
                         boolean vorspeise){

        super(name, zutaten, vegetarisch, vegan, "PastaGericht");
        this.nudelsorte = nudelsorte;
        this.vorspeise = vorspeise;

    }

    public boolean parmesanMitKundeAbstimmen(){

        return true;

    }

    public String getNudelsorte() {
        return nudelsorte;
    }

    public void setNudelsorte(String nudelsorte) {
        this.nudelsorte = nudelsorte;
    }

    public boolean isVorspeise() {
        return vorspeise;
    }

    public void setVorspeise(boolean vorspeise) {
        this.vorspeise = vorspeise;
    }

}
