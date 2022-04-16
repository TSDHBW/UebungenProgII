public class FleischGericht extends BasisRezeptEssen implements Verkaufspreis {

    private String fleischsorte;
    private int zielKerntemperatur;
    private int zubereitungstemperatur;

    public FleischGericht(String name, Zutat[]zutaten, boolean vegetarisch, boolean vegan, String fleischsorte, int zielKerntemperatur, int zubereitungstemperatur){

        super(name, zutaten, vegetarisch, vegan, "FleischGericht");
        this.fleischsorte = fleischsorte;
        this.zielKerntemperatur = zielKerntemperatur;
        this.zubereitungstemperatur = zubereitungstemperatur;

    }

    public String gargradMitKundeAbstimmen() {

        return "";

    }

    public String getFleischsorte() {
        return fleischsorte;
    }

    public void setFleischsorte(String fleischsorte) {
        this.fleischsorte = fleischsorte;
    }

    public int getZielKerntemperatur() {
        return zielKerntemperatur;
    }

    public void setZielKerntemperatur(int zielKerntemperatur) {
        this.zielKerntemperatur = zielKerntemperatur;
    }

    public int getZubereitungstemperatur() {
        return zubereitungstemperatur;
    }

    public void setZubereitungstemperatur(int zubereitungstemperatur) {
        this.zubereitungstemperatur = zubereitungstemperatur;
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
        return 8.00;
    }
}
