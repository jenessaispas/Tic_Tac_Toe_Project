//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//Deklaration der Importe
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Deklaration der Variablen.
    static char[][] playground = new char[3][3];
    static char playerSymbol;
    static int count = 0;
    static String txtFilled = "Dieses Feld ist bereits belegt, bitte wähle eines der freien Felder aus: ";
    static String txtWin = "Herzlichen Glückwunsch du hast gewonnen ";
    static String playerNameX;
    static String playerNameO;
    static String txtWrongInput = "Das ist eine ungültige Eingabe. Gib bitte nur eine der zur Auswahl stehenden Zahlen " +
            "auf dem Spielfeld an!";

    // Deklaration sowie Formulierung der eigenen Methoden
    //Methode zum Ausgeben des Spielfeldes
    public static void printPlayground(char[][] playground) {
        for (char[] chars : playground) {
            for (char chars1 : chars) {
                System.out.print(chars1 + "\t");
            }
            System.out.println();
        }
    }

    //Methode zum setzten der jeweiligen Spielerposition.
    public static void setPosition(char playerSymbol, char[][] playground) {
        //Beginn des Schleifendurchlaufes
        while (true) {
            if (playerSymbol == 'X') {
                System.out.println("Bitte " + playerNameX + " gib eine Zahl ein, auf dessen Position du deine Spielfigur setzen möchtest:");
            } else {
                System.out.println("Bitte " + playerNameO + " gib eine Zahl ein, auf dessen Position du deine Spielfigur setzen möchtest:");
            }
            //Ausführen des Codes in einem Try-Catch Block zur Fehlerbehandlung einer Exception (Ausnahmebehandlung).
            int position;
            try {
                //Deklaration und Initialisierung des Scannerobjekts
                Scanner playerInput = new Scanner(System.in);
                position = playerInput.nextInt();
                //Auffangen einer Exception (falsche Eingabe) in einem catch-Block.
            } catch (InputMismatchException wrongChar) {
                System.out.println(txtWrongInput);
                continue;
            }
            if (position < 1 || position > 9) {
                continue;
            }
            //Belegung eines Feldes mit einer Spielerfigur
            switch (position) {
                case 1:
                    // dabei wird geprüft ob das Feld nicht bereits zuvor von einem Spieler belegt worden ist.
                    if (playground[0][0] == 'X' || playground[0][0] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[0][0] = playerSymbol;
                    }
                    break;
                case 2:
                    if (playground[0][1] == 'X' || playground[0][1] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[0][1] = playerSymbol;
                    }
                    break;
                case 3:
                    if (playground[0][2] == 'X' || playground[0][2] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[0][2] = playerSymbol;
                    }
                    break;
                case 4:
                    if (playground[1][0] == 'X' || playground[1][0] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[1][0] = playerSymbol;
                    }
                    break;
                case 5:
                    if (playground[1][1] == 'X' || playground[1][1] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[1][1] = playerSymbol;
                    }
                    break;
                case 6:
                    if (playground[1][2] == 'X' || playground[1][2] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[1][2] = playerSymbol;
                    }
                    break;
                case 7:
                    if (playground[2][0] == 'X' || playground[2][0] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[2][0] = playerSymbol;
                    }
                    break;
                case 8:
                    if (playground[2][1] == 'X' || playground[2][1] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[2][1] = playerSymbol;
                    }
                    break;
                case 9:
                    if (playground[2][2] == 'X' || playground[2][2] == 'O') {
                        System.out.println(txtFilled);
                        continue;
                    } else {
                        playground[2][2] = playerSymbol;
                    }
                    break;
                default:
                    System.out.println(txtWrongInput);
                    continue;
            }
            printPlayground(playground);
            break;
        }
    }

    //Formulierung der Gewinnbedingung in einer eigenen Methode
    public static boolean youWin(char playerSymbol, char[][] playground) {
        // Überprüfung der Symbole ob sie in einer gewünschten Reihenfolge liegen, um das Spiel zu gewinnen:
        //Oberste Zeile. Zahlenreihe  1, 2, 3.
        if (playground[0][0] == playerSymbol && playground[0][1] == playerSymbol && playground[0][2] == playerSymbol) {
            return true;
            //Mittlere Zeile. Zahlenreihe 4, 5, 6.
        } else if (playground[1][0] == playerSymbol && playground[1][1] == playerSymbol && playground[1][2] == playerSymbol) {
            return true;
            //Unterste Zeile. Zahlenreihe 7, 8, 9.
        } else if (playground[2][0] == playerSymbol && playground[2][1] == playerSymbol && playground[2][2] == playerSymbol) {
            return true;
            //Linke Spalte. Zahlenreihe 1, 4, 7.
        } else if (playground[0][0] == playerSymbol && playground[1][0] == playerSymbol && playground[2][0] == playerSymbol) {
            return true;
            //Mittlere Spalte. Zahlenreihe 2, 5, 8.
        } else if (playground[0][1] == playerSymbol && playground[1][1] == playerSymbol && playground[2][1] == playerSymbol) {
            return true;
            //Rechte Spalte. Zahlenreihe 3, 6, 9.
        } else if (playground[0][2] == playerSymbol && playground[1][2] == playerSymbol && playground[2][2] == playerSymbol) {
            return true;
            //Diagonale links Oben nach rechts Unten. Zahlenreihe 1, 5, 9.
        } else if (playground[0][0] == playerSymbol && playground[1][1] == playerSymbol && playground[2][2] == playerSymbol) {
            return true;
            // Diagonale rechts Oben nach links Untern. Zahlenreihe 3, 5, 7.
        } else if (playground[0][2] == playerSymbol && playground[1][1] == playerSymbol && playground[2][0] == playerSymbol) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //Programmbeginn mit einer Aufforderung an die Spieler, ihre Namen anzugeben.
        System.out.println("Bitte Spieler 1 gib deinen Namen ein: ");
        playerNameX = new Scanner(System.in).nextLine();
        System.out.println("Jetzt ist Spieler 2 an der Reihe seinen Namen einzugeben: ");
        playerNameO = new Scanner(System.in).nextLine();
        char fieldCounter = '1';
        //Initialisierung und Zuweisung des Spielfeldes mit Chars von 1 - 9.
        for (int i = 0; i < playground.length; i++) {
            for (int j = 0; j < playground[i].length; j++) {
                playground[i][j] = fieldCounter++;
            }
        }
        //Erste Ausgabe des Spielfeldes.
        printPlayground(playground);
        //Spielablauf im Rahmen der maximalen Rundenanzahl.
        while (count < 9) {
            if (youWin(playerSymbol, playground) && playerSymbol ==  'X') {
                System.out.println(txtWin+playerNameX+" !!!");
                break;
            }else if (youWin(playerSymbol, playground) && playerSymbol == 'O') {
                System.out.println(txtWin+playerNameO+" !!!");
                break;
            }
            //Auswahl welcher Spieler an der Reihe ist seinen Zug zu machen.
            else if (count % 2 == 0) {
                playerSymbol = 'X';
                setPosition(playerSymbol, playground);
            } else {
                playerSymbol = 'O';
                setPosition(playerSymbol, playground);
            }
            count++;
        }
        if (youWin(playerSymbol,playground) == false && count == 9) {
            System.out.println("Unentschieden!");
        }
    }
}