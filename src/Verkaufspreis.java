public interface Verkaufspreis {

    public static final double BASISPREIS = 1.00;

    public abstract double getZutatenPreis ();
    public abstract double getZubereitungsPreis ();

}
