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
        System.out.println(cocktail.getName());
        aktualisiereRezept(cocktail);
        werteRezeptverwaltungAus();
        berechneVerkaufspreis(caipirinha);
        berechneVerkaufspreis(limette);

    }

    public void aktualisiereRezept (BasisRezept rezept) {

        Cocktail cocktail = (Cocktail)rezept;
        cocktail.setAlkohlfrei(true);
        model.rezeptverwaltung.nehmeRezeptAuf(cocktail);
        Cocktail caipirinha = (Cocktail)model.rezeptverwaltung.getRezept("Caipirinha", "Cocktail");
        System.out.println(caipirinha.getAlkohlfrei());

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

        BasisRezept[] rezepte = model.rezeptverwaltung.getRezepte();
        System.out.println(rezepte[0].getName());
        System.out.println(rezepte[1].getName());
        model.rezeptverwaltung.loescheRezept(typ, name);
        Zutat orange = legeZutatan("Orange", 1.00);
        Zutat zucker = legeZutatan("Zucker", 2.50);
        Zutat[] zutaten = {orange, zucker};
        Limonade OrganenLimo = new Limonade("OrganenLimo", zutaten, false, false, "Orange", true);
        model.rezeptverwaltung.nehmeRezeptAuf(OrganenLimo);
        rezepte = model.rezeptverwaltung.getRezepte();
        System.out.println(rezepte[0].getName());
        System.out.println(rezepte[1].getName());
        System.out.println(model.rezeptverwaltung.getIndex());

    }

    public void löscheZutat (String name){

        Zutat[] zutaten = model.zutatenverwaltung.getZutaten();
        System.out.println(zutaten[0].getName());
        System.out.println(zutaten[1].getName());
        System.out.println(zutaten[2].getName());
        model.zutatenverwaltung.loescheZutat(name);
        Zutat limette = legeZutatan("Limette", 1.00);
        System.out.println(zutaten[0].getName());
        System.out.println(zutaten[1].getName());
        System.out.println(zutaten[2].getName());

    }




}
