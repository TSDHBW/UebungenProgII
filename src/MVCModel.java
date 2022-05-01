import java.io.*;

public class MVCModel {

    Rezeptverwaltung rezeptverwaltung;
    Zutatenverwaltung zutatenverwaltung;

    public MVCModel(){
        init();
    }

    public void init(){

        rezeptverwaltung = new Rezeptverwaltung();
        zutatenverwaltung = new Zutatenverwaltung();
        System.out.println("Initialisieren des Datenmodells abgeschlossen");
    }

    public void speichern(){

        try {
            FileWriter fileWriterRezepte = new FileWriter("Rezepte.txt");
            FileWriter fileWriterZutaten = new FileWriter("Zutaten.txt");
            BufferedWriter bufferedWriterRezepte = new BufferedWriter(fileWriterRezepte);
            BufferedWriter bufferedWriterZutaten = new BufferedWriter(fileWriterZutaten);

            String zutat="";
            for (int i = 0; i < zutatenverwaltung.getIndex(); i++){
                if (zutatenverwaltung.getZutaten()[i] != null){
                    zutat = zutatenverwaltung.getZutaten()[i].getName() + ";" + zutatenverwaltung.getZutaten()[i].getPreis();
                    bufferedWriterZutaten.write(zutat);
                    bufferedWriterZutaten.newLine();
                }
            }
            bufferedWriterZutaten.close();
            String rezept="";
            String zutaten="";
            for (int i = 0; i < rezeptverwaltung.getIndex() + 1; i++){
                if (rezeptverwaltung.getRezepte()[i] != null){
                    switch(rezeptverwaltung.getRezepte()[i].getTyp()){
                        case "Cocktail":
                            Cocktail cocktail = (Cocktail)rezeptverwaltung.getRezepte()[i];
                            rezept = cocktail.getName() + ";" + cocktail.isHeißGetraenk() + ";"
                                    + cocktail.isZuckerfrei() + ";" + cocktail.getAlkohlgehalt() + ";" + cocktail.isAlkohlfrei() + ";"
                                    + cocktail.getTyp();
                            System.out.println("Cocktail gespeichert: " + rezept);
                            break;
                        case "Limonade":
                            Limonade Limonade = (Limonade)rezeptverwaltung.getRezepte()[i];
                            rezept = Limonade.getName() + ";" + Limonade.isHeißGetraenk() + ";" + Limonade.isZuckerfrei() + ";"
                                    + Limonade.getFruchtgeschmack() + ";" + Limonade.getHerstellungInHouse() + ";"
                                    + Limonade.getTyp();
                            System.out.println("Limonade gespeichert " + rezept);
                            break;
                        case "FleischGericht":
                            FleischGericht fleischGericht = (FleischGericht)rezeptverwaltung.getRezepte()[i];
                            rezept = fleischGericht.getName() + ";" + fleischGericht.isVegan() + ";" + fleischGericht.isVegetarisch() + ";"
                                    + fleischGericht.getFleischsorte() + ";" + fleischGericht.getZielKerntemperatur() + ";"
                                    + fleischGericht.getZubereitungstemperatur() + ";" + fleischGericht.getTyp();
                            System.out.println("Fleischgericht gespeichert " + rezept);
                            break;
                        case "PastaGericht":
                            PastaGericht pastaGericht = (PastaGericht)rezeptverwaltung.getRezepte()[i];
                            rezept = pastaGericht.getName() + ";" + pastaGericht.isVegan() + ";" + pastaGericht.isVegetarisch() + ";"
                                    + pastaGericht.getNudelsorte() + ";" + pastaGericht.isVorspeise() + ";"
                                    + pastaGericht.getTyp();
                            System.out.println(rezeptverwaltung.getRezepte()[i].getName());
                            System.out.println("Pastagereicht gespeichert " + rezept);
                            break;
                        default:
                            break;
                    }
                    bufferedWriterRezepte.write(rezept);
                    bufferedWriterRezepte.newLine();
                    for (int j = 0; j < rezeptverwaltung.getRezepte()[i].getZutaten().length; j++){
                        if (rezeptverwaltung.getRezepte()[i].getZutaten()[j] != null) {
                            zutaten = zutaten + rezeptverwaltung.getRezepte()[i].getZutaten()[j].getName() + ";";
                        }
                    }
                    bufferedWriterRezepte.write(zutaten);
                    bufferedWriterRezepte.newLine();
                    zutaten = "";
                }
            }
            bufferedWriterRezepte.close();
        } catch (FileNotFoundException e){
            System.out.println("Datei nicht gefunden");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}