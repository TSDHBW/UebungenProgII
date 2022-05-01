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
        Zutat orange = legeZutatan("Orange", 2.50);
        Zutat[] zutatenCaipi = {limette, zucker};
        Zutat[] zutatenZitronenLimo = {limette, zucker};
        Zutat[] zutatenOrangenLimo = {orange, zucker};
        Cocktail caipirinha = new Cocktail("Caipirinha", zutatenCaipi, true, false, 2, false);
        Limonade zitronenlimo = new Limonade("Zitronenlimo", zutatenZitronenLimo, false, false, "Limette", true);
        Limonade orangenlimo = new Limonade("OrangenLimo", zutatenOrangenLimo, false, false, "Orange", false);
        model.rezeptverwaltung.nehmeRezeptAuf(caipirinha);
        model.rezeptverwaltung.nehmeRezeptAuf(zitronenlimo);
        model.rezeptverwaltung.nehmeRezeptAuf(orangenlimo);
        Cocktail cocktail = (Cocktail)model.rezeptverwaltung.getRezept("Caipirinha", "Cocktail");

        for (BasisRezept rezept: model.rezeptverwaltung){
            System.out.println(rezept.getName());
        }

    }


    public Zutat legeZutatan (String name, double preis){

        Zutat zutat = new Zutat(name, preis);
        model.zutatenverwaltung.setZutat(zutat);
        return zutat;

    }

}
