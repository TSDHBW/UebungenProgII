/**
 * Klasse MVCController ist für die Erzeugung des User Interface und des Datenmodells verantwortlich.
 * Zusätzlich werden alle Benutzeraktionen im User Interface in Form von ActionEvents behandelt.
 * @author Timo
 * @version 1.0
 */
public class MVCController {

    private MVCModel model;

    public MVCController() {

        //Erzeugung des Datenmodells durch ein Objekt der Klasse MVCModel
        this.model = new MVCModel();
        legeDatenmodellAn();
    }

    public void legeDatenmodellAn (){

        Zutat limette = legeZutatan("Limette", 1.00);
        Zutat zucker = legeZutatan("Zucker", 2.50);
        Zutat orange = legeZutatan("Orange", 2.50);
        model.zutatenverwaltung.addZutat(limette);
        model.zutatenverwaltung.addZutat(zucker);
        model.zutatenverwaltung.addZutat(orange);
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
        System.out.println("---");
        for (BasisRezept rezept: model.rezeptverwaltung){
            System.out.println(rezept.getName());
        }
        System.out.println("---");
        for (Zutat zutat: model.zutatenverwaltung){
            System.out.println(zutat.getName());
            String name = zutat.getName();
            zutat.setName(name+"_Altbestand");
            System.out.println(zutat.getName());

        }

    }


    public Zutat legeZutatan (String name, double preis){

        Zutat zutat = new Zutat(name, preis);
        model.zutatenverwaltung.setZutat(zutat);
        return zutat;

    }

}
