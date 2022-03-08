import java.util.ArrayList;
import java.util.Scanner;
// import java.util.concurrent.TimeUnit;

public class Functions {

    public void frageanzeige(ArrayList<String> frage, int fragennumber){
        String frag = frage.get(0);
        System.out.print(frag);
    }

    public void antwortenanzeigen(ArrayList<String> frage, int fragennumber){
        ArrayList<String> antwortanzeigenarray = frage;
        //antwortanzeigenarray.remove(0);
        int antwortnumber = 1;
        System.out.println("");

        while (antwortnumber <= 4) {
            int anzeigen = antwortnumber;

            System.out.print(antwortnumber + ". ");
            System.out.print(antwortanzeigenarray.get(anzeigen));
            System.out.println("");
            antwortanzeigenarray.add("\"" + anzeigen + "\"");
            antwortnumber++;
        }
    }

    public void quiz(ArrayList<String> frage, int fragennummer, int joker){
        //system('clear');
        //titelAnzeigen();
        //ArrayList<String> frage = fragen.get(fragennummer);


        frageanzeige(frage, fragennummer);

        System.out.println("");
        System.out.println("");

        if (joker != 0) {
            System.out.print("j. für den 50/50-Joker");
        }

        antwortenanzeigen(frage, fragennummer);
    }

    public String antwortabfragen(){
        Scanner keyboard1 = new Scanner(System.in);
        //int input = keyboard.nextInt();
        System.out.println("");
        System.out.print("Antwort: ");
        String antwortnumber = keyboard1.nextLine();
        // keyboard1.close();
        return antwortnumber;
    }

    public int joker(/*String antwortnumber,*/int fragennumber,int gewinn,int joker, ArrayList<String> frage){
        //system('clear');

        ArrayList<String> zweiMoeglichkeiten = new ArrayList<String>();
        zweiMoeglichkeiten.add(frage.get(5));
        zweiMoeglichkeiten.add(frage.get(6));


        //titelAnzeigen();

        frageanzeige(frage, fragennumber);
        System.out.println("");
        System.out.println("Einer der grünen Antworten ist RICHTIG");
        System.out.println("");


        ArrayList<String> antwortanzeigenarray = frage;
        //antwortanzeigenarray.remove(0);
        int antwortnumber = 1;

        while (antwortnumber <= 4) {
            int anzeigen = antwortnumber;

            if (zweiMoeglichkeiten.contains(antwortnumber)) {
                System.out.print(antwortnumber + ". (Grün)");
                System.out.print(antwortanzeigenarray.get(anzeigen));
            } else {
                System.out.print(antwortnumber + ". ");
                System.out.print(antwortanzeigenarray.get(anzeigen));
            }
            System.out.println("");
            antwortanzeigenarray.add("\"" + anzeigen + "\"");
            antwortnumber++;
        }
        joker--;
        return joker;
    }

    public  int antwortTest(String antwortnumber, int fragennumber, int gewinn, ArrayList<String> frage,ArrayList<String> PreisGeldArrayOhne){

        String richtigeAntwort = frage.get(5);
        if (richtigeAntwort.equals(antwortnumber)) {
            System.out.println("Das ist richtig");
            gewinn--;
            return gewinn;
        } else {
            System.out.println("Das ist falsch");
            int verlohen = falschProzess(gewinn, PreisGeldArrayOhne);
            return gewinn;
        }
    }

    public  int falschProzess(int gewinn,ArrayList<String> PreisGeldArrayOhne){

        if (gewinn <= 5) {
            gewinn = 5;
            System.out.println("Sie haben " + PreisGeldArrayOhne.get(5) + " gewonnen.");
        } else if (gewinn <= 10) {
            gewinn = 10;
            System.out.println("Sie haben " + PreisGeldArrayOhne.get(10) + " gewonnen.");
        } else {
            gewinn = 0;
            System.out.println("Sie haben nichts gewonnen.");
        }
        int verlohen = 0;
        System.out.println("Keine Fragen mehr!!!");
        System.out.println("Ende Ende Ende Ende");
        return verlohen;
    }

    public  void millionTest(int gewinn){
        if (gewinn == 0) {
            for (int i = 0; i < 15; i++) {
                System.out.print("Gewonnen!!!");
            }
            System.exit(0);

        }
    }

    public  void geldanzeige(ArrayList<String> PreisGeldArray,int gewinn){
        for(int i = 0; i < PreisGeldArray.size() / 2 ; i++){
            String value = PreisGeldArray.get(i);
            System.out.println("");
            System.out.print("                                             ");
            if (i == gewinn) {
                System.out.print(value + " <---");
            } else {
                System.out.print(value);
            }
        }
        System.out.println("");
        System.out.println("");
    }

}
