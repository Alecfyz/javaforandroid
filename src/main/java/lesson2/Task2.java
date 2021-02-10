package lesson2;

public class Task2 {
    public static void main() {

        System.out.println("\nTask 2\r\n");
        int[] myArr = new int[8];

        fillWithFor(myArr);
        showMyArr(myArr);
    }


    private static void fillWithFor(int[] myArr) {
        int v = 0;
        for(int i = 0; i < myArr.length; i++){
            myArr[i] = v;
            v += 3;
        }

    }

    public static void showMyArr(int[] myArr){
        int rows = myArr.length;
        int row = 0;
        for (int a : myArr
             ) {
            System.out.print(row + "`s = " + myArr[row] + "; ");
            System.out.println(" ");
            row++;
        }

    }

}
