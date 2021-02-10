package lesson2;

public class HomeWork2 {
    public static void main() {
        System.out.println("Это второе домашнее задание по основам Java.\n-=-=-=-=-=-=-=-");


        int arrCols = 14;
        int arrRows = 5;

        manipulateWithArray1(arrRows, arrCols); // Task #1
        Task2.main();
        Task3.main();
        Task4.main();
        Task5.main(new int[]{arrCols});
        Task6.main(new int[]{arrCols});
        Task7.main();
    }

    private static void manipulateWithArray1(int xLen, int yLen) {
        System.out.println("\nTask 1");
        short[][] myArr = new short[xLen][yLen];
                fillTheArray(myArr);
                showMyArr(myArr);

                    int rows = myArr.length;
                    int  columns = myArr[0].length;
                    for (int row = 0; row < rows; row++) {
                        for( int col = 0; col < columns; col++){
                            short curVal = myArr[row][col];
                            myArr[row][col] = (short) (curVal == 1 ? 0 : 1);
                        }
                    }
        System.out.println("Выше - массив до преобразования.\n-=-\nНиже - после инвертирования");

        showMyArr(myArr);


    }

    public static void showMyArr(short[][] myArr){
        int rows = myArr.length;
        int  columns = myArr[0].length;
        for (short[] shorts : myArr) {
            for (int col = 0; col < columns; col++) {
                System.out.print(shorts[col] + "   ");
            }
            System.out.println(" ");
        }
    }

    private static void fillTheArray(short[][] myArr){
        int rows = myArr.length;
        int  columns = myArr[0].length;
        for (int x = 0; x < rows; x++) {
            for( int y = 0; y < columns; y++){
               myArr[x][y] = (short)( Math.random()*2);

            }
        }
    }
}
