import java.util.Scanner;
import java.util.Random;

public class Main {
    public static char[][] board = new char[3][3];
    public static int Humanscore = 0;
    public static int Compscore = 0;
    public static int Drawscore = 0;
    public static void PlayerMove() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Row and Columm number separated by a space");
            int row = input.nextInt();
            int colm = input.nextInt();
            try {
                if (CheckEmpty(row, colm)) {
                    board[row][colm] = 'x';
                    return;
                }
                System.out.println("Error Space already fulled");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error, Invalid row or column entry");
            }
        }
    }

    public static void PrintBoard() {
        System.out.println("___");
        for (int i = 0; i<=2; i++) {
            for (int j = 0; j<=2; j++) {
                System.out.print(board[i][j]);
               }
            System.out.println();
            }
        System.out.println("___");
        }

    public static boolean CheckEmpty(int row, int coln) {
        try {
            if (board[row][coln] == 'x' | board[row][coln] == 'o') {
                return false;
            }
            return true;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public static void ResetBoard() {
        board = new char[3][3];
        for (int i = 0; i<=2; i++) {
            for (int j = 0; j<=2; j++) {
                board[i][j] = ' ';
                }
            }
        }

    public static void ResetGame() {
        ResetBoard();
        Humanscore = 0;
        Compscore = 0;
        Drawscore = 0;
    }

    public static void Score(int player) {

        if (player == 10) {Humanscore++;}
        if (player == 20) {Compscore++;}
        System.out.println("Current score is: ");
        System.out.println("Human: " + Humanscore);
        System.out.println("Computer: " + Compscore);
        System.out.println("Draw Count:" + Drawscore);
    }

    public static boolean CheckWinHuman() {
        if (board[0][0] == 'x' & board[0][1] == 'x' & board[0][2] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[1][0] == 'x' & board[1][1] == 'x' & board[1][2] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[2][0] == 'x' & board[2][1] == 'x' & board[2][2] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[0][0] == 'x' & board[1][0] == 'x' & board[2][0] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[0][0] == 'x' & board[1][0] == 'x' & board[2][0] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[0][1] == 'x' & board[1][1] == 'x' & board[2][1] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[0][2] == 'x' & board[1][2] == 'x' & board[2][2] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[0][0] == 'x' & board[1][1] == 'x' & board[2][2] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        if (board[0][2] == 'x' & board[1][1] == 'x' & board[2][0] == 'x') {
            System.out.println("Human player win");
            Score(10);
            return true;
        }
        else {return false;}
    }

    public static boolean CheckWinComp() {
        if (board[0][0] == 'o' & board[0][1] == 'o' & board[0][2] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[1][0] == 'o' & board[1][1] == 'o' & board[1][2] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[2][0] == 'o' & board[2][1] == 'o' & board[2][2] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[0][0] == 'o' & board[1][0] == 'o' & board[2][0] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[0][0] == 'o' & board[1][0] == 'o' & board[2][0] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[0][1] == 'o' & board[1][1] == 'o' & board[2][1] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[0][2] == 'o' & board[1][2] == 'o' & board[2][2] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[0][0] == 'o' & board[1][1] == 'o' & board[2][2] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        if (board[0][2] == 'o' & board[1][1] == 'o' & board[2][0] == 'o') {
            System.out.println("Computer win");
            Score(20);
            return true;
        }
        else {return false;}
    }

    public static boolean CheckDraw () {
        int count = 0;
        if (!CheckWinHuman() & !CheckWinComp()) {
            for (int i = 0; i<=2; i++) {
                for (int j = 0; j<=2; j++) {
                    if (board[i][j] == 'o' | board[i][j] == 'x') {count++;}
                    }
                }
            if (count == 9) {System.out.println("Draw Game"); Drawscore++; return true;}
        }
        return false;
    }

    public static void CompFristMove() {
        Random random = new Random();
        int StartingMove = random.nextInt(2);
        int StartingCorner = random.nextInt(4);
        if (StartingMove == 0) {board[1][1] = 'o'; return;}
        if (StartingMove == 1 & StartingCorner == 0) {board[0][0] = 'o'; return;}
        if (StartingMove == 1 & StartingCorner == 1) {board[0][2] = 'o'; return;}
        if (StartingMove == 1 & StartingCorner == 2) {board[2][0] = 'o'; return;}
        if (StartingMove == 1 & StartingCorner == 3) {board[2][2] = 'o'; return;}
        else {System.out.println("ERROR CompFirstMove"); return;}
    }

    public static void CompSecondMove(){
        Random random = new Random();
        if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return;}
        if (CompNextOverCheckWin()) {return;}
        if (CompOppositeSideCheckWin()) {return;}
        if (CompNextOverCheckLoss()) {return;}
        if (CompOppositeSideCheckLoss()) {return;}
        int RandCorner = random.nextInt(4);
        if (RandCorner == 0 & (CheckEmpty(0, 0))) {board[0][0] = 'o'; return;}
        if (RandCorner == 1 & (CheckEmpty(0, 2))) {board[0][2] = 'o'; return;}
        if (RandCorner == 2 & (CheckEmpty(2, 0))) {board[2][0] = 'o'; return;}
        if (RandCorner == 3 & (CheckEmpty(2, 2))) {board[2][2] = 'o'; return;}
        while (true) {
            int Randnum = random.nextInt(9);
            if (CheckEmpty(0,0) & Randnum == 1) {board[0][0] = 'o'; return;}
            if (CheckEmpty(0,1) & Randnum == 2) {board[0][1] = 'o'; return;}
            if (CheckEmpty(0,2) & Randnum == 3) {board[0][2] = 'o'; return;}
            if (CheckEmpty(1,0) & Randnum == 4) {board[1][0] = 'o'; return;}
            if (CheckEmpty(1,1) & Randnum == 5) {board[1][1] = 'o'; return;}
            if (CheckEmpty(1,2) & Randnum == 6) {board[1][2] = 'o'; return;}
            if (CheckEmpty(2,0) & Randnum == 7) {board[2][0] = 'o'; return;}
            if (CheckEmpty(2,1) & Randnum == 8) {board[2][1] = 'o'; return;}
            if (CheckEmpty(2,2) & Randnum == 9) {board[2][2] = 'o'; return;}
        }
    }

    public static void CompMove() {
        Random random = new Random();
        if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return;}
        if (CompNextOverCheckWin()) {return;}
        if (CompOppositeSideCheckWin()) {return;}
        if (CompNextOverCheckLoss()) {return;}
        if (CompOppositeSideCheckLoss()) {return;}
        for (int i = 0; i<=2;i++) {
            for (int j = 0; j<2; j++) {
                if (board[i][j] != board[i][j+1] & ((board[i][j] == 0) | (board[i][j+1] == 0)) & (board[i][j] != 1) & (board[i][j+1] != 1)) {
                    if (CheckEmpty(i, j + 1))  {board[i][j+1] = 'o'; return;}
                    if (CheckEmpty(i, j)) {board[i][j] = 'o'; return;}
                }//horizontal check
                if (board[j][i] != board[j+1][i] & ((board[j][i] == 0) | (board[j+1][i] == 0)) & (board[j][i] != 1) & (board[j+1][i] != 1)) {
                    if (CheckEmpty(j + 1, i)) {board[j+1][i] = 'o'; return;}
                    if (CheckEmpty(j, i)) {board[j][i] = 'o'; return;}
                } //vertical check
            }
        }
        if (board[1][1] == 0) {
            if(CheckEmpty(0, 0)) {board[0][0] = 'o'; return;}
            if(CheckEmpty(2,0)) {board[2][0] = 'o'; return;}
            if(CheckEmpty(2,2)) {board[2][2] = 'o'; return;}
            if(CheckEmpty(0,2)) {board[0][2] = 'o'; return;}
        }
        while (true) {
            int Randnum = random.nextInt(9);
            if (CheckEmpty(0,0) & Randnum == 1) {board[0][0] = 'o'; return;}
            if (CheckEmpty(0,1) & Randnum == 2) {board[0][1] = 'o'; return;}
            if (CheckEmpty(0,2) & Randnum == 3) {board[0][2] = 'o'; return;}
            if (CheckEmpty(1,0) & Randnum == 4) {board[1][0] = 'o'; return;}
            if (CheckEmpty(1,1) & Randnum == 5) {board[1][1] = 'o'; return;}
            if (CheckEmpty(1,2) & Randnum == 6) {board[1][2] = 'o'; return;}
            if (CheckEmpty(2,0) & Randnum == 7) {board[2][0] = 'o'; return;}
            if (CheckEmpty(2,1) & Randnum == 8) {board[2][1] = 'o'; return;}
            if (CheckEmpty(2,2) & Randnum == 9) {board[2][2] = 'o'; return;}
        }
    }

    public static boolean FirstMoveRandom() {
        Random random = new Random();
        int Randnum = random.nextInt(2);
        return Randnum == 0;
    }
    public static boolean CompNextOverCheckLoss(){
        for (int i = 0; i<=2;i++) {
            for (int j = 0; j<2; j++) {
                if (board[i][j] == 'x' & board[i][j+1] == 'x') {
                    if (CheckEmpty(i, j + 2))  {board[i][j+2] = 'o'; return true;}
                    if (CheckEmpty(i, j - 1)) {board[i][j-1] = 'o'; return true;}
                }//horizontal check
                if (board[j][i] == 'x' & board[j + 1][i] == 'x') {
                    if (CheckEmpty(j + 2, i)) {board[j+2][i] = 'o'; return true;}
                    if (CheckEmpty(j - 1, i)) {board[j-1][i] = 'o'; return true;}
                } //vertical check
                }
            }

        if (board[0][0] == 'x' & board[1][1] == 'x') {
            if (CheckEmpty(2, 2)) {board[2][2] = 'o'; return true;}
        }
        if (board[2][2] == 'x' & board[1][1] == 'x') {
            if (CheckEmpty(0,0)) {board[0][0] = 'o'; return true;}
            }
        //diag topleft to bot right

        if (board[0][2] == 'x' & board[1][1] == 'x') {
            if (CheckEmpty(2, 0)) {board[2][0] = 'o'; return true;}
        }
        if (board[2][0] == 'x' & board[1][1] == 'x') {
            if (CheckEmpty(0,2)) {board[0][2] = 'o'; return true;}
        }
        return false;
    }

    public static boolean CompNextOverCheckWin(){
        for (int i = 0; i<=2;i++) {
            for (int j = 0; j<2; j++) {
                if (board[i][j] == 'o' & board[i][j+1] == 'o') {
                    if (CheckEmpty(i, j + 2))  {board[i][j+2] = 'o'; return true;}
                    if (CheckEmpty(i, j - 1)) {board[i][j-1] = 'o'; return true;}
                }//horizontal check
                if (board[j][i] == 'o' & board[j + 1][i] == 'o') {
                    if (CheckEmpty(j + 2, i)) {board[j+2][i] = 'o'; return true;}
                    if (CheckEmpty(j - 1, i)) {board[j-1][i] = 'o'; return true;}
                } //vertical check
            }
        }

        if (board[0][0] == 'o' & board[1][1] == 'o') {
            if (CheckEmpty(2, 2)) {board[2][2] = 'o'; return true;}
        }
        if (board[2][2] == 'o' & board[1][1] == 'o') {
            if (CheckEmpty(0,0)) {board[0][0] = 'o'; return true;}
        }
        //diag topleft to bot right

        if (board[0][2] == 'o' & board[1][1] == 'o') {
            if (CheckEmpty(2, 0)) {board[2][0] = 'o'; return true;}
        }
        if (board[2][0] == 'o' & board[1][1] == 'o') {
            if (CheckEmpty(0,2)) {board[0][2] = 'o'; return true;}
        }
        return false;
    }

    public static boolean CompOppositeSideCheckLoss() {
        if (board[0][0] == 'x' & board[0][2] == 'x') {
            if (CheckEmpty(0, 1)) {board[0][1] = 'o'; return true;}
        }
        if (board[0][0] == 'x' & board[2][0] == 'x') {
            if (CheckEmpty(1, 0)) {board[1][0] = 'o'; return true;}
        }
        if (board[0][0] == 'x' & board[2][2] == 'x') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[0][2] == 'x' & board[2][0] == 'x') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[0][1] == 'x' & board[2][1] == 'x') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[1][0] == 'x' & board[1][2] == 'x') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[0][2] == 'x' & board[2][2] == 'x') {
            if (CheckEmpty(1,2)) {board[1][2] = 'o'; return true;}
        }
        if (board[2][0] == 'x' & board[2][2] == 'x') {
            if (CheckEmpty(2, 1)) {board[2][1] = 'o'; return true;}
        }
        return false;
    }

    public static boolean CompOppositeSideCheckWin() {
        if (board[0][0] == 'o' & board[0][2] == 'o') {
            if (CheckEmpty(0, 1)) {board[0][1] = 'o'; return true;}
        }
        if (board[0][0] == 'o' & board[2][0] == 'o') {
            if (CheckEmpty(1, 0)) {board[1][0] = 'o'; return true;}
        }
        if (board[0][0] == 'o' & board[2][2] == 'o') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[0][2] == 'o' & board[2][0] == 'o') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[0][1] == 'o' & board[2][1] == 'o') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[1][0] == 'o' & board[1][2] == 'o') {
            if (CheckEmpty(1, 1)) {board[1][1] = 'o'; return true;}
        }
        if (board[0][2] == 'o' & board[2][2] == 'o') {
            if (CheckEmpty(1,2)) {board[1][2] = 'o'; return true;}
        }
        if (board[2][0] == 'o' & board[2][2] == 'o') {
            if (CheckEmpty(2, 1)) {board[2][1] = 'o'; return true;}
        }
        return false;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");
        while (true) {
            System.out.println("Menu: Enter your choice");
            System.out.println("\t A) Play a game against the computer");
            System.out.println("\t B) View last Game Board");
            System.out.println("\t C) View score counter");
            System.out.println("\t D) Reset score counter");
            System.out.println("\t E) Exit Game");
            System.out.println();
            String InputStr = input.nextLine();
            switch (InputStr) {
                case "A": {
                    System.out.println("You are x the computer is o");
                    ResetBoard();
                    PrintBoard();
                    if (FirstMoveRandom()) {CompFristMove(); PrintBoard();}
                    PlayerMove();
                    CompSecondMove();
                        PrintBoard();
                    PlayerMove();
                    CompMove();
                        PrintBoard();
                        if (CheckWinHuman()) {break;}
                        if (CheckWinComp()) {break;}
                        if (CheckDraw()) {break;}
                    PlayerMove();
                        if (CheckWinHuman()) {break;}
                        if (CheckWinComp()) {break;}
                        if (CheckDraw()) {break;}
                    CompMove();
                        PrintBoard();
                        if (CheckWinHuman()) {break;}
                        if (CheckWinComp()) {break;}
                        if (CheckDraw()) {break;}
                    PlayerMove();
                        if (CheckWinHuman()) {break;}
                        if (CheckWinComp()) {break;}
                        if (CheckDraw()) {break;}
                    CompMove();
                        PrintBoard();
                        if (CheckWinHuman()) {break;}
                        if (CheckWinComp()) {break;}
                        if (CheckDraw()) {break;}
                    PlayerMove();
                        if (CheckWinHuman()) {break;}
                        if (CheckWinComp()) {break;}
                        if (CheckDraw()) {break;}
                }
                case "B": {
                    PrintBoard();
                    break;
                }
                case "C": {
                    Score(0);
                    break;
                }
                case "D": {
                    ResetGame();
                    Score(0);
                    break;
                }
                case "E": {
                    Score(0);
                    System.out.println("Exiting Game");
                    return;
                }
            }
        }
    }
}