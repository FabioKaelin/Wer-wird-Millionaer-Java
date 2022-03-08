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




        Object[][] fragen = new Object [][] {
            {"In welcher Farbe ist der Punkt von Lenovo?","Gelb", "Grün", "Rot", "Blau", 3,4},
            {"In welcher Farbe sind Exit-Schilder","Gelb", "Grün", "Rot", "Blau",2,1},
            {"Von wievielen Länder ist die Schweiz umgeben?","Drei","Vier","Fünf","Sechs",3,2},
            {"Welches Land hat auf der Flagge weniger als 2 durchgezogene Linien?","England","Finland","Norwegen","Wales",4,2},
            {"Wo sollte das Fenster sein beim ergonomischen Arbeiten?","Gegenüber dem Bildschirm","Hinter dem Bildschirm","Diagonal zum Bildschirm","Auf der Seite vom Bildschirm",4,1},
            {"Wie tief ist der Marianengraben unter dem Meeresspiegel (-+ 25 Meter)?","10.984","11.484","11.984","12.484",1,4},
            {"Wie heisst der Arbeitsspeicher auch noch?","Flüchtiger Speicher","Fluchender Speicher","Fliegender Speicher","Flacher Speicher",1,3},
            {"Welche Flagge hat 5 Ecken?","Katar","Georgien","Nepal","Madagaskar",3,4},
            {"Was ist keine Programmiersprache?", "Java", "Html", "Python", "PHP", 2,4},
            {"Was für eine Endung hat ein Python-File?",".python",".pt",".pth",".py",4,1},
            {"Mit welchem Git-Command kann man ein Repository auf Github hochladen?", "Push", "Pull", "Init", "Add", 1,3},
            {"Wer ist KEIN Smartphone-Hersteller?","Sony","Razer","Google","Ecosia",4,2},
            {"Welche Flagge hat KEIN Tier drauf?","Sri Lanka","Mexiko","Ägypten","Kambodscha",4,3},
            {"Welche Flagge hat KEIN gelb drin?","Deutschland","Ecouador","China","Nordkorea",4,2},
            {"Was heisst html?","Hypertext Markup Language","Hypertransfair Markup Language","Hypertransfair Makeup Language","Hypertranslated Markup Language",1,3},
            {"Wie viel achttausender Berge gibt es?","7","14","21","28",2,4},
            {"Welcher Git-Befehl gibt es NICHT?","merge","branch","checkin","log",3,4},
            {"Was heisst ESD?","Electro Static Discharge","Ergonomie Strategic Day","Electronic Static Destruction","Electro Static Destruction",1,2},
            {"Welches Jahr wird auch als Jahr ohne Sommer bezeichnet?","1718","1818","1918","2018",2,3},
            {"Wie viel Bytes hat ein Kilobyte","8","512","1000","1024",3,2},
            {"Welches Zeichen wird geschrieben mit \"alt gr\" und \"e\"?","ⓔ","€","Ⓔ","🄴",2,1},
            {"Welches Land hat die meisten Zeitzonen?","Brasilien","Grönland","Frankreich","Russland",3,4},
            {"Wie heisst der höchste Berg im Kanton Schwyz?","Bös Fulen","Bös Müeden","Lieb Fulen","Lieb Müeden",1,2},
            {"Welcher Berg ist am weitesten vom Erdmittelpunkt entfernt?","Mount Everest","K2","Chimborazo","Kilimandscharo",3,4},
            {"Welches ist das bevölkerungsdichteste Land von Europa?","Monaco","Gibraltar","Vatikan","Deutschland",1,3},
            {"Welche Stadt hat am meisten Brücken","Venedig","Hamburg","Amsterdam","Brügge",2,3},
            {"Welche Printfunktion gibt es in PHP NICHT?","print_r","printf","print","printr",4,3},
            {"Durch welches Land fliest die Donau NICHT?","Ukraine","Kroatien","Tschechien","Deutschland",3,4},
            {"Auf welchem Himmelkörper gibt es KEINE aktiven Vuklane","Io","Saturn","Venus","Erde",2,3},
            {"Wie heisst der Planet HD 130322 b?","Eiger","Mönch","Jungfrau","Matterhorn",1,4}
        };


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
                if (fragennumber < fragen.length) {
                    fragenangezeigt.add(fragennumber);

                    functions.quiz(fragen[fragennumber], fragennumber, joker);
                    String antwortnumber = functions.antwortabfragen().toLowerCase();
                    if (antwortnumber.equals("j")) {
                        if (joker == 1) {
                            System.out.println("");
                            joker = functions.joker(/*antwortnumber,*/ fragennumber, gewinn, joker,fragen[fragennumber]);
                            antwortnumber = functions.antwortabfragen().toLowerCase();
                        } else {
                            System.out.println("Kein Joker mehr zur Verfügung\n");
                            antwortnumber = functions.antwortabfragen().toLowerCase();
                        }
                    }
                    gewinn = functions.antwortTest(antwortnumber, fragennumber, gewinn,fragen[fragennumber], PreisGeldArrayOhne);
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

            if (fragenschwierigkeit * 2 >= fragen.length) {
                System.out.println("Keine Fragen mehr!!!");
                System.out.println("Ende Ende Ende Ende");
                break;
            }
        }


        keyboard.close();
    }
}
