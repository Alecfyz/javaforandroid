package lesson1;

import java.util.Calendar;



public class HomeWork {
    public static void main() {

        final String STR_CONST = "Строковая константа";
        int intVar = -12;
        double dVar = 4.000000040000000004;
        float fVar = 1.0F;
        char chVar = 'R';
        char chVar2 = 1251;
        String strVar = "Это строчная переменная";
        boolean bolVar = true;

        System.out.println("Это первое домашнее задание по основам Java.\n-=-=-=-=-=-=-=-");

        printAllVars(STR_CONST, intVar, dVar, fVar, chVar, chVar2, strVar, bolVar);

        int task3var = calculateTask3(intVar, (int)dVar, (int)fVar, chVar2);
        System.out.println("\n=-=\nВычисление из задачи №3 ДЗ: (a * (b + (c / d))). Результат = " + task3var);

        boolean ifDiap = checkIfDiap(Math.abs((int)dVar), Math.abs(intVar));
        String res = "вне диапазона.";
        if (ifDiap) {
            res = "в пределах заданного диапазона.";
        }
        System.out.println("\n=-=\nВычисление из задачи №4 ДЗ. a = " + dVar + ", b = " + intVar + ". Cумма _!модулей!_ a и b " + res);

        System.out.println("\n=-=\nПроверка из задачи №5 ДЗ.");
        checkIfPositive(intVar);
        checkIfPositive(dVar);
        checkIfPositive(0);

        System.out.println("\n=-=\nПроверка на отрицательное число из задачи №6 ДЗ.");
        if (checkIfNegative(intVar)) System.out.println("Аргумент " + intVar + " отрицательный"); else System.out.println("Аргумент " + intVar + " положитнльный\n");
        if (checkIfNegative((int)dVar)) System.out.println("Аргумент " + dVar + " отрицательный"); else System.out.println("Аргумент " + dVar + " положитнльный\n");


        System.out.println("\n=-=\nПередача в метод строки. №7 ДЗ.");
        printHelloName("Тимофей");

        System.out.println("\n=-=\nОпределение високосного года. №8 ДЗ.");
        int frstDate = 2000;
        int secDate = 2020;
        Calendar calendar = Calendar.getInstance();

        checkIfBissextile(frstDate);
        checkIfBissextile(secDate);
        checkIfBissextile(calendar.get(Calendar.YEAR));

        System.out.println("\n=-=\nИтс э файнал [countdown].");

    }




    private static void printAllVars(String var1, int var2, double var3, float var4, char var5, char var6, String var7, boolean var8){
        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6);
        System.out.println(var7);
        System.out.println(var8);
    }

    private static int calculateTask3(int a, int b, int c, int d) {
        return (a * (b + (c / d)));
    }

    private static boolean checkIfDiap(int a, int b) {
        int sum = a + b;
        if (sum >= 10 & sum <= 20){
            return true;
        } else return false;
    }

    private static void checkIfPositive(double a) {
        String res = "отрицательный.";
        if (a >= 0) {
            res = "положительный.";
        }
        System.out.print(" a = " + a + ", аргумент " + res + "\n");
    }

    private static boolean checkIfNegative(int a) {
        boolean res = false;
        if (a < 0) {
            res = true;
        }
        return res;
    }

    private static void printHelloName(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void checkIfBissextile(int argDate) {
        double get100 = argDate % 100;
        double get400 = argDate % 400;
        double get4 = argDate % 4;
//        System.out.println("get100 = " + get100 + "\nget400 = " +get400);
        boolean res = false;                                // год НЕ високосный


        if (get4 == 0 ) {
            res = true;                             // да, значит , високосный
//            System.out.println("Год " + argDate + " Это 4й год, он високосный.");

            if (get100 == 0) {                                 // это сотый год?
                res = false;                                    // если сотый, значит не високосный
//                System.out.println("Год " + argDate + " Это 100й год, он НЕ високосный.");

                    if (get400 == 0) {                         // это четырехсотый год?
                        res = true;                             // да, значит , все-таки високосный
//                        System.out.println("Год " + argDate + " Это 400й год, он високосный.");

                    }

            }
        }

            String result;
        if (res) result = "это високосный год"; else result = "обычный, не високосный год";
        System.out.println(argDate + " год - "+ result);

//        Date date = new Date();
//        System.out.println(date.);
    }

}
