/**
 * Klasse MVCController ist für die Erzeugung des User Interface und des Datenmodells verantwortlich.
 * Zusätzlich werden alle Benutzeraktionen im User Interface in Form von ActionEvents behandelt.
 * @author Timo
 * @version 1.0
 */
public class MVCController {

    private MVCView view;
    private MVCModel model;

    public MVCController() {
        //Erzeugung des User Interface durch ein Objekt der Klasse MVCView
        this.view = new MVCView(this);
        //Erzeugung des Datenmodells durch ein Objekt der Klasse MVCModel
        this.model = new MVCModel();
        legeRezeptAn();
        loescheRezept("Cocktail", "Caipirinha");
        löscheZutat ("limette");
        //model.einlesen();
        model.speichern();
    }

    public void legeRezeptAn (){

        Zutat limette = legeZutatan("Limette", 1.00);
        Zutat zucker = legeZutatan("Zucker", 2.50);
        Zutat[] zutaten = {limette, zucker};
        Cocktail caipirinha = new Cocktail("Caipirinha", zutaten, true, false, 2, false);
        Limonade zitronenlimo = new Limonade("Zitronenlimo", zutaten, false, false, "Limette", true);
        model.rezeptverwaltung.nehmeRezeptAuf(caipirinha);
        model.rezeptverwaltung.nehmeRezeptAuf(zitronenlimo);
        Cocktail cocktail = (Cocktail)model.rezeptverwaltung.getRezept("Caipirinha", "Cocktail");
        aktualisiereRezept(cocktail);
        //werteRezeptverwaltungAus();
        //berechneVerkaufspreis(caipirinha);
        //berechneVerkaufspreis(limette);

    }

    public void aktualisiereRezept (BasisRezept rezept) {

        Cocktail cocktail = (Cocktail)rezept;
        cocktail.setAlkohlfrei(true);
        model.rezeptverwaltung.nehmeRezeptAuf(cocktail);
        Cocktail caipirinha = (Cocktail)model.rezeptverwaltung.getRezept("Caipirinha", "Cocktail");

    }

    public Zutat legeZutatan (String name, double preis){

        Zutat zutat = new Zutat(name, preis);
        model.zutatenverwaltung.setZutat(zutat);
        return zutat;

    }

    public void werteRezeptverwaltungAus (){

        System.out.println(model.rezeptverwaltung.ermittleAnzahlRezepte());
        System.out.println(model.rezeptverwaltung.ermittleAnzahlRezepte("Cocktail"));
        System.out.println(model.rezeptverwaltung.ermittleAnzahlRezepte("Limonade"));

    }

    public void berechneVerkaufspreis (Verkaufspreis parameter){

        double preis = 0.00;
        preis += parameter.BASISPREIS;
        preis += parameter.getZubereitungsPreis();
        preis += parameter.getZutatenPreis();
        System.out.println(preis);

    }

    public void loescheRezept (String typ, String name){

        model.rezeptverwaltung.loescheRezept(typ, name);
        Zutat orange = legeZutatan("Orange", 1.00);
        Zutat zucker = legeZutatan("Zucker", 2.50);
        Zutat[] zutaten = {orange, zucker};
        Limonade OrganenLimo = new Limonade("OrganenLimo", zutaten, false, false, "Orange", true);
        model.rezeptverwaltung.nehmeRezeptAuf(OrganenLimo);

    }

    public void löscheZutat (String name){

        Zutat[] zutaten = model.zutatenverwaltung.getZutaten();
        model.zutatenverwaltung.loescheZutat(name);
        Zutat limette = legeZutatan("Limette", 1.00);

    }
}
