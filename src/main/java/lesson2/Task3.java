package lesson2;

public class Task3 {
    public static void main() {
        System.out.println("\nTask 3\r\n");
        int[] myArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        Task2.showMyArr(myArr);
        doRefineArr(myArr);
        System.out.println("Выше - до.\r\nНиже - после цикла.");
        Task2.showMyArr(myArr);

    }

    private static void doRefineArr(int[] myArr){
        int i = 0;
        int cols = myArr.length;
        while (i < cols) {
            if (myArr[i] < 6) myArr[i] *= 2; i++;
        }
    }
}
