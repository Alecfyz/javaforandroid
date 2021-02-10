package lesson2;

public class Task4 {
    public static void main() {
        System.out.println("\nTask 4 - заполнить диагональные элементы единицами;\r\nНадеюсь, я правильно понял, что такое 'диагональные элементы.'\r\n");

        int arrCols = 10;
        int arrRows = 10;
        short[][] myArr = new short[arrRows][arrCols];
        drawDiag(myArr);
        HomeWork2.showMyArr(myArr);
    }

    private static void drawDiag(short[][] myArr){
        int rows = myArr.length;
        int columns = myArr[0].length;
        for (int row = 0; row < rows; row++) {
            for( int col = 0; col < columns; col++){
                short curVal = 0;
                if (row % 2 != 0 ) {                         // если не четная линия
                    curVal = (short) ((col % 2 == 0) ? 1 : 0); // все четные ячейки единица
                } else {                                    // если четная линия
                    curVal = (short) ((col % 2 != 0) ? 1 : 0); // все нечетные ячейки единица
                }
                myArr[row][col] = curVal;
            }
        }
    }
}
