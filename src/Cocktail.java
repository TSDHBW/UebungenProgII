public class Cocktail extends BasisRezeptGetraenk {

    private int alkohlgehalt;
    private boolean alkohlfrei;

    public Cocktail(String name, Zutat[]zutaten, boolean heißGetraenk, boolean zuckerfrei, int alkohlgehalt, boolean alkohlfrei){

        super(name, zutaten, heißGetraenk, zuckerfrei, "Cocktail");
        this.alkohlgehalt = alkohlgehalt;
        this.alkohlfrei = alkohlfrei;

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

}
