//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//Deklaration der Importe

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    //Declaration all static variables for the complete Programm.
    static char[][] playground = new char[3][3];
    static char playerSymbol;
    static int count = 0;
    static String txtFilled = "This field is already occupied, select one of the free fields, ";
    static String txtWin = "Congratulations you won: ";
    static String playerNameX;
    static String playerNameO;
    static String txtWrongInput = "This is an invalid input. Please enter only one of the numbers available to choose from the field!";

    // Declaration and formulate each own written Methods:
    //Method to print the playground on terminal screen.
    public static void printPlayground(char[][] playground) {
        for (char[] chars : playground) {
            for (char chars1 : chars) {
                System.out.print(chars1 + "\t");
            }
            System.out.println();
        }
    }

    //Method to replace each char at chosen position whit different playersymbols.
    public static void setPosition(char playerSymbol, char[][] playground) {
        //Begin of the loop to compare the char inside the fields.
        while (true) {
            if (playerSymbol == 'X') {
                System.out.println(playerNameX + ", enter a number where you would like to place your 'X' and confirm with enter:");
            } else {
                System.out.println(playerNameO + ", enter a number where you would like to place your 'O' and confirm with enter:");
            }
            //Runs the Code to get a Userinput in a special Try-Catch Block to catch an exception if the scanner get an wrong input.
            int position;
            try {
                //Declaration and initializing the scanner object for the userinput
                Scanner playerInput = new Scanner(System.in);
                position = playerInput.nextInt();
                //Catching an exception and handling in a catch-block.
            } catch (InputMismatchException wrongChar) {
                System.out.println(txtWrongInput);
                continue;
            }
            if (position < 1 || position > 9) {
                System.out.println(txtWrongInput);
                continue;
            }
            //Checking if the position is already placed whit a playersymbol
            if (playground[position * (playground.length) / 10][(position - 1) % 3] == 'X' || playground[position * (playground.length) / 10][(position - 1) % 3] == 'O') {
                System.out.println(txtFilled);
                continue;
                //Occupying a field with a playersymbol
            } else {
                playground[position * (playground.length) / 10][(position - 1) % 3] = playerSymbol;
            }
            printPlayground(playground);
            break;
        }
    }

    //Formulate the winning condition in your own method
    public static boolean youWin(char playerSymbol, char[][] playground) {
        // Checking the symbols to see if they are in the desired order to win the game:
        //Top line. Number series  1, 2, 3.
        if (playground[0][0] == playerSymbol && playground[0][1] == playerSymbol && playground[0][2] == playerSymbol) {
            return true;
            //Middle line. Number series 4, 5, 6.
        } else if (playground[1][0] == playerSymbol && playground[1][1] == playerSymbol && playground[1][2] == playerSymbol) {
            return true;
            //Bottom line. Number series 7, 8, 9.
        } else if (playground[2][0] == playerSymbol && playground[2][1] == playerSymbol && playground[2][2] == playerSymbol) {
            return true;
            //Left column. Number series 1, 4, 7.
        } else if (playground[0][0] == playerSymbol && playground[1][0] == playerSymbol && playground[2][0] == playerSymbol) {
            return true;
            //Middle column. Number series 2, 5, 8.
        } else if (playground[0][1] == playerSymbol && playground[1][1] == playerSymbol && playground[2][1] == playerSymbol) {
            return true;
            //Right column. Number series 3, 6, 9.
        } else if (playground[0][2] == playerSymbol && playground[1][2] == playerSymbol && playground[2][2] == playerSymbol) {
            return true;
            //Diagonal left top to right bottom. Number series 1, 5, 9.
        } else if (playground[0][0] == playerSymbol && playground[1][1] == playerSymbol && playground[2][2] == playerSymbol) {
            return true;
            //Diagonal right top to left bottom. Number series 3, 5, 7.
        } else if (playground[0][2] == playerSymbol && playground[1][1] == playerSymbol && playground[2][0] == playerSymbol) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //The program begins with a request for players to state their names.
        System.out.println("Please Player 1 choose your name and confirm with enter:");
        playerNameX = new Scanner(System.in).nextLine();
        System.out.println("Now it's player 2's turn to choose his name and to confirm with enter:");
        playerNameO = new Scanner(System.in).nextLine();
        char fieldCounter = '1';
        //Initialization and assignment of the playing field with characters from 1 - 9.
        for (int i = 0; i < playground.length; i++) {
            for (int j = 0; j < playground[i].length; j++) {
                playground[i][j] = fieldCounter++;
            }
        }
        //First edition of the playing field.
        printPlayground(playground);
        //Gameplay within the maximum number of rounds.
        while (count < 9) {
            if (youWin(playerSymbol, playground) && playerSymbol == 'X') {
                System.out.println(txtWin + playerNameX + " !!!");
                break;
            } else if (youWin(playerSymbol, playground) && playerSymbol == 'O') {
                System.out.println(txtWin + playerNameO + " !!!");
                break;
            }
            //Selecting which player's turn it is to make their move.
            else if (count % 2 == 0) {
                playerSymbol = 'X';
                setPosition(playerSymbol, playground);
            } else {
                playerSymbol = 'O';
                setPosition(playerSymbol, playground);
            }
            count++;
        }
        if (!youWin(playerSymbol, playground) && count == 9) {
            System.out.println("Draw!");
        }
    }
}