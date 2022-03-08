import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String [] args) {
        Scanner keyboard = new Scanner(System.in);
        //int input = keyboard.nextInt();


        ArrayList<String> PreisGeldArray = new ArrayList<String>();
        PreisGeldArray.add("1000000");
        PreisGeldArray.add(" 500000");
        PreisGeldArray.add(" 125000");
        PreisGeldArray.add("  64000");
        PreisGeldArray.add("  32000");
        PreisGeldArray.add("  16000");
        PreisGeldArray.add("   8000");
        PreisGeldArray.add("   4000");
        PreisGeldArray.add("   2000");
        PreisGeldArray.add("   1000");
        PreisGeldArray.add("    500");
        PreisGeldArray.add("    300");
        PreisGeldArray.add("    200");
        PreisGeldArray.add("    100");
        PreisGeldArray.add("     50");
        PreisGeldArray.add("      0");

        ArrayList<String> PreisGeldArrayOhne = new ArrayList<String>();
        PreisGeldArray.add("1000000");
        PreisGeldArray.add(" 500000");
        PreisGeldArray.add(" 125000");
        PreisGeldArray.add("  64000");
        PreisGeldArray.add("  32000");
        PreisGeldArray.add("  16000");
        PreisGeldArray.add("   8000");
        PreisGeldArray.add("   4000");
        PreisGeldArray.add("   2000");
        PreisGeldArray.add("   1000");
        PreisGeldArray.add("    500");
        PreisGeldArray.add("    300");
        PreisGeldArray.add("    200");
        PreisGeldArray.add("    100");
        PreisGeldArray.add("     50");
        PreisGeldArray.add("      0");


        ArrayList<ArrayList> fragen = new ArrayList<ArrayList>();

        ArrayList<String> fragen1 = new ArrayList<String>();
        fragen1.add("In welcher Farbe ist der Punkt von Lenovo?");
        fragen1.add("Gelb");
        fragen1.add("Grün");
        fragen1.add("Rot");
        fragen1.add("Blau");
        fragen1.add("3");
        fragen1.add("4");
        fragen.add(fragen1);

        ArrayList<String> fragen2 = new ArrayList<String>();
        fragen2.add("In welcher Farbe sind Exit-Schilder?");
        fragen2.add("Gelb");
        fragen2.add("Grün");
        fragen2.add("Rot");
        fragen2.add("Blau");
        fragen2.add("2");
        fragen2.add("1");
        fragen.add(fragen2);

        ArrayList<String> fragen3 = new ArrayList<String>();
        fragen3.add("Von wievielen Länder ist die Schweiz umgeben?");
        fragen3.add("Drei");
        fragen3.add("Vier");
        fragen3.add("Fünf");
        fragen3.add("Sechs");
        fragen3.add("3");
        fragen3.add("2");
        fragen.add(fragen3);

        ArrayList<String> fragen4 = new ArrayList<String>();
        fragen4.add("Welches Land hat auf der Flagge weniger als 2 durchgezogene Linien?");
        fragen4.add("England");
        fragen4.add("Finland");
        fragen4.add("Norwegen");
        fragen4.add("Wales");
        fragen4.add("4");
        fragen4.add("2");
        fragen.add(fragen4);

        ArrayList<String> fragen5 = new ArrayList<String>();
        fragen5.add("Wo sollte das Fenster sein beim ergonomischen Arbeiten?");
        fragen5.add("Gegenüber dem Bildschirm");
        fragen5.add("Hinter dem Bildschirm");
        fragen5.add("Diagonal zum Bildschirm");
        fragen5.add("Auf der Seite vom Bildschirm");
        fragen5.add("4");
        fragen5.add("1");
        fragen.add(fragen5);


        ArrayList<Integer> fragenangezeigt = new ArrayList<Integer>();

        int gewinn = 15;
        //int fragenAngezeigtAnzahl = 0;
        int fragenschwierigkeit = 0;
        int joker = 1;
        Random random = new Random();

        Functions functions = new Functions();


        while (gewinn >= 0) {

            int fragennumber = (fragenschwierigkeit * 2) + random.nextInt(2);
            //System.out.println(fragennumber);


            if (fragenangezeigt.contains(fragennumber)) {
                System.out.print("");
            } else {
                if (fragennumber < fragen.size()) {
                    fragenangezeigt.add(fragennumber);

                    functions.quiz(fragen.get(fragennumber), fragennumber, joker);
                    String antwortnumber = functions.antwortabfragen().toLowerCase();
                    if (antwortnumber.equals("j")) {
                        if (joker == 1) {
                            System.out.println("");
                            joker = functions.joker(/*antwortnumber,*/ fragennumber, gewinn, joker,fragen.get(fragennumber));
                            antwortnumber = functions.antwortabfragen().toLowerCase();
                        } else {
                            System.out.println("Kein Joker mehr zur Verfügung\n");
                            antwortnumber = functions.antwortabfragen().toLowerCase();
                        }
                    }
                    gewinn = functions.antwortTest(antwortnumber, fragennumber, gewinn,fragen.get(fragennumber), PreisGeldArrayOhne);
                    functions.millionTest(gewinn);
                    if (gewinn == 0) {
                        System.exit(0);
                    }

                    functions.geldanzeige(PreisGeldArray, gewinn);

                    //int aldkj = keyboard.nextInt();


                    //fragenAngezeigtAnzahl++;
                    fragenschwierigkeit++;
                }
            }

            if (fragenschwierigkeit * 2 >= fragen.size()) {
                System.out.println("Keine Fragen mehr!!!");
                System.out.println("Ende Ende Ende Ende");
                break;
            }
        }


        keyboard.close();
    }
}
