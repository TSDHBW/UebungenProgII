public class Limonade extends BasisRezeptGetraenk implements Verkaufspreis {

    private String fruchtgeschmack;
    private Boolean herstellungInHouse;

    public Limonade (String name, Zutat[]zutaten, boolean heißGetraenk, boolean zuckerfrei, String fruchtgeschmack, boolean herstellungInHouse){

        super(name, zutaten, heißGetraenk, zuckerfrei, "Limonade");
        this.fruchtgeschmack = fruchtgeschmack;
        this.herstellungInHouse = herstellungInHouse;

    }

    public boolean eiswuerfelMitKundeAbstimmen() {

        return true;

    }

    public String getFruchtgeschmack() {
        return fruchtgeschmack;
    }

    public void setFruchtgeschmack(String fruchtgeschmack) {
        this.fruchtgeschmack = fruchtgeschmack;
    }

    public Boolean getHerstellungInHouse() {
        return herstellungInHouse;
    }

    public void setHerstellungInHouse(Boolean herstellungInHouse) {
        this.herstellungInHouse = herstellungInHouse;
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
