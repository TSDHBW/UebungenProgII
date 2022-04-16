public abstract class BasisRezept {

    private String name;
    private Zutat[] zutaten;
    private String typ;

    public BasisRezept(String name, Zutat[]zutaten, String typ){

        this.name = name;
        this.zutaten = zutaten;
        this.typ = typ;

    }

    public void zubereiten (int anzahlPortionen){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zutat[] getZutaten() {
        return zutaten;
    }

    public void setZutaten(Zutat[] zutaten) {
        this.zutaten = zutaten;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
