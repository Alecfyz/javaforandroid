package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 5;
    static int winLineLen = 3;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_SYMBOL = '*';
    static final String EMPTY = " ";

    static final char[][] MAP = new char[SIZE][SIZE];
    static final Scanner IN = new Scanner(System.in);
    static final Random random = new Random();

    static int turnsCount;


    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {

        //инициализация поля
        initMap();

        //печать поля в консоль
        printMap();

        //игра
        playGame();

    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        //пеать заголовка
        printHeaderMap();

        //печать поля
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.println("Выигрышная линия = " + winLineLen);
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();
    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyMap() {

        for (int i = 0; i < SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
                System.out.println();
        }
    }

    private static void playGame() {
        turnsCount = 0;
        while(true){
            humanTurn();
            printMap();
            //проверка окончания игры
            checkEnd(DOT_HUMAN);

            turnAI();
            printMap();
            //проверка окончания игры
            checkEnd(DOT_AI);
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int colNumber;
        boolean isInputValid = true;

        System.out.printf("%nХод человека. Введите строку и столбец.%n");
        do {
            rowNumber = -1;
            colNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (IN.hasNextInt()) {
                rowNumber = IN.nextInt() - 1;
            } else {
                processIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбец: ");
            if (IN.hasNextInt()) {
                colNumber = IN.nextInt() - 1;
            } else {
                processIncorrectInput();
                isInputValid = false;
                continue;
            }
        } while (!(isInputValid && isHumanTurnValid(rowNumber, colNumber)));

        MAP[rowNumber][colNumber] = DOT_HUMAN;
        turnsCount++;
    }

    private static void processIncorrectInput() {
        IN.nextLine();
        System.out.printf("Ошибка ввода. Введите число в диапазоне 1 - %d%n", SIZE);
    }

    private static boolean isHumanTurnValid(int rowNumber, int colNumber) {
        if (!isNumbersValid(rowNumber, colNumber)){
            System.out.println("\nЗначения за пределами поля.");
            return false;
        } else if (!isCellEmpty(rowNumber, colNumber)){
            System.out.println("\nЯчейка уже занята!");
            return false;
        }
            return true;
    }

    private static boolean isNumbersValid(int rowNumber, int colNumber) {
        return !(rowNumber >= SIZE || rowNumber < 0 || colNumber >= SIZE || colNumber < 0);
    }

    private static boolean isCellEmpty(int rowNumber, int colNumber) {
        return MAP[rowNumber][colNumber] == DOT_EMPTY;

    }

    private static void checkEnd(char symbol) {
        // проверка на выигрыш
        if (checkWin(symbol)){
            if (symbol == DOT_HUMAN) {
                System.out.println("Выиграл человек!");
            } else {
                System.out.println("Комп выиграл!");
            }
            System.exit(0);
        }
        else if (isMapFull()){
            System.out.println("Ничья");
            System.exit(0);
        }

        //проверка на отсутствие пустых ячеек
    }

    private static boolean isMapFull() {
        return turnsCount == SIZE * SIZE;
    }

    private static boolean checkWin(char symbol) {
        //if (MAP[0][0] == symbol && MAP[0][1] == symbol && MAP[0][2] == symbol) return true;
        return checkWinHorizont(symbol) || checkWinVertical(symbol) || checkWinDiagonal(symbol);
    }

    private static boolean checkWinDiagonal(char symbol) {
        return checkWinDiagDownsteirs(symbol) || checkWinDiagUpsteirs(symbol);
    }

    private static boolean checkWinDiagDownsteirs(char symbol) { // нисходящие диагонали
        for (int i = 0; i <= SIZE-winLineLen+1; i++) { //rows
            int curWinLen = 0;
            for (int row = i, colm = 0; row <= SIZE-1; row++, colm++) {
                if (MAP[row][colm] == symbol) {
                    curWinLen++;
                    if (curWinLen == winLineLen) {
                        System.out.println("Есть попадание Downsteirs1!");
                        return true;
                    }
                } else curWinLen = 0;
            }
        } // дошли от второстепенных диагоналей до длинной средней нисходящей диагонали
        int iii = SIZE-winLineLen-1;
        for (int i = 0; i <= iii; i++) { //rows
            int curWinLen = 0;
            for (int row = 0, colm = i+1; colm <= SIZE-1; row++, colm++) {
                if (MAP[row][colm] == symbol) {
                    curWinLen++;
                    if (curWinLen == winLineLen) {
                        System.out.println("Есть попадание Downsteirs2!");
                        return true;
                    }
                } else curWinLen = 0;
            }
        }
        return false;
    }

    private static boolean checkWinDiagUpsteirs(char symbol) { // восходящие диагонали
        for (int i = winLineLen-1; i < SIZE; i++) { //columns
            int curWinLen = 0;
            for (int row = i, colm = 0; row >= 0; row--, colm++) {
                if(MAP[row][colm] == symbol) {
                    curWinLen++;
                    if (curWinLen == winLineLen) {
                        System.out.println("Есть попадание!");
                        return true;
                    }
                } else curWinLen = 0;
            }
        } // дошли слева сверху до самой длинной восходящей диагонали и пошли по восходящим второстепенным диагоналям

        for (int i = 1; i <= SIZE-winLineLen; i++){
            int curWinLen = 0;
            for (int row = SIZE-1, colm = i; colm < SIZE; row--, colm++) {
                if(MAP[row][colm] == symbol) {
                    curWinLen++;
                    if (curWinLen == winLineLen) {
                        System.out.println("Есть попадание2!");
                        return true;
                    }
                } else curWinLen = 0;
            }
        }
        return false;
    }

    private static boolean checkWinHorizont(char symbol) {
        for (int i = 0; i < SIZE; i++) { //строки
            int curWinLen = 0;
            for (int j = 0; j < SIZE; j++) { //ячейки (столбцы)
                if(MAP[i][j] == symbol) {
                    curWinLen++;
                    if (curWinLen == winLineLen) return true;
                } else curWinLen = 0;
            }
        }
        return false;
    }

    private static boolean checkWinVertical(char symbol) {
        for (int i = 0; i < SIZE; i++) { //строки
            int curWinLen = 0;
            for (int j = 0; j < SIZE; j++) { //ячейки (столбцы)
                if(MAP[j][i] == symbol) {
                    curWinLen++;
                    if (curWinLen == winLineLen) return true;
                } else curWinLen = 0;
            }
        }
        return false;
    }


    private static void turnAI() {
        int rowNumber;
        int colNumber;
        System.out.println("\nКомп ходит.");

        do {
            rowNumber = random.nextInt(SIZE);
            colNumber = random.nextInt(SIZE);
        } while (!isCellEmpty(rowNumber, colNumber));

        MAP[rowNumber][colNumber] = DOT_AI;
        turnsCount++;
    }

}
