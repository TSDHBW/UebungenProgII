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
    }

    public void legeRezeptAn (){

        Zutat limette = legeZutatan("Limette", 1.00);
        Zutat zucker = legeZutatan("Zucker", 2.50);
        Zutat[] zutaten = {limette, zucker};
        Cocktail caipirinha = new Cocktail("Caipirinha", zutaten, true, true, 2, false);
        model.rezeptverwaltung.nehmeRezeptAuf(caipirinha);
        Cocktail cocktail = (Cocktail)model.rezeptverwaltung.getRezept("Caipirinha", "Cocktail");
        System.out.println(cocktail.getName());
        aktualisiereRezept(cocktail);

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


}
