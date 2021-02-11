package lesson2;

public class Task4rev2 {
    public static void showDiag() {
        System.out.println("\nTask 4 rev.2 - заполнить диагональные элементы единицами;\r\nИздание дополненное, переработанное.'\r\n");

        int arrCols = 9;
        int arrRows = 9;
        short[][] myArr = new short[arrRows][arrCols];
        drawDiag(myArr);
        HomeWork2.showMyArr(myArr);
    }

    private static void drawDiag(short[][] myArr){
        int columns = myArr[0].length; // оставил специально для повышения чистаемости
        int curStep = 0;
        for (int row = 0; row < myArr.length; row++) {
            myArr[row][curStep] = 1;
            myArr[row][columns-curStep-1] = 1;
            curStep++;
        }
    }
}
