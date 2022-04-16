public class Limonade extends BasisRezeptGetraenk {

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

}
