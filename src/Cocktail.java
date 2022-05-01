public class Cocktail extends BasisRezeptGetraenk implements Verkaufspreis {

    private int alkohlgehalt;
    private boolean alkohlfrei;

    public Cocktail(String name, Zutat[]zutaten, boolean heißGetraenk, boolean zuckerfrei, int alkohlgehalt, boolean alkohlfrei){

        super(name, zutaten, heißGetraenk, zuckerfrei, "Cocktail");
        this.alkohlgehalt = alkohlgehalt;
        this.alkohlfrei = alkohlfrei;

    }

    public boolean isAlkohlfrei() {
        return alkohlfrei;
    }

    public String glasMitKundeAbstimmen() {

        return "";

    }

    public int getAlkohlgehalt() {
        return alkohlgehalt;
    }

    public void setAlkohlgehalt(int alkohlgehalt) {
        this.alkohlgehalt = alkohlgehalt;
    }

    public boolean getAlkohlfrei() {
        return alkohlfrei;
    }

    public void setAlkohlfrei(boolean alkohlfrei) {
        this.alkohlfrei = alkohlfrei;
    }

    @Override
    public double getZutatenPreis() {

        double preis = 0.00;
        for (int i = 0; i < getZutaten().length; i++){

            preis = preis + getZutaten()[i].getPreis();

        }
        return preis;
    }

    @Override
    public double getZubereitungsPreis() {
        return 3.00;
    }

    @Override
    public double getVerkaufspreis() {

        double verkaufspreis = 0.00;
        for (int i = 0; i < getZutaten().length; i++){

            verkaufspreis = verkaufspreis + getZutaten()[i].getPreis();

        }
        verkaufspreis += 3.00;
        return verkaufspreis;
    }

}
