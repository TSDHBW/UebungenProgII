public abstract class BasisRezeptGetraenk extends BasisRezept {

    private boolean heißGetraenk;
    private boolean zuckerfrei;

    public BasisRezeptGetraenk(String name, Zutat[]zutaten, boolean heißGetraenk, boolean zuckerfrei, String typ){

        super(name, zutaten, typ);
        this.heißGetraenk = heißGetraenk;
        this.zuckerfrei = zuckerfrei;

    }

    public boolean isHeißGetraenk() {
        return heißGetraenk;
    }

    public void setHeißGetraenk(boolean heißGetraenk) {
        this.heißGetraenk = heißGetraenk;
    }

    public boolean isZuckerfrei() {
        return zuckerfrei;
    }

    public void setZuckerfrei(boolean zuckerfrei) {
        this.zuckerfrei = zuckerfrei;
    }

}
