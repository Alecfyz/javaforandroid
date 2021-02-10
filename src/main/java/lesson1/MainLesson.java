package lesson1;

public class MainLesson {
    public static void main(String[] args) {

        //HomeWork.main();
        lesson2.HomeWork2.main();
    }



    public static void testvars() {
//        System.out.println("asdf");
        int varA;
        varA = 3;
        int varB = 7;
       int varC = varB / varA;
//        System.out.println(varC);

        double varCC = (double) varB / varA;
        System.out.println(varCC);

        double doubVA = 3.0;
        double doubVB = 7.0;

//        System.out.println(doubVB / doubVA);

        char ch = 1251;
        System.out.println(ch);

    }


    private static void testSumVar() {
        sumVar(3, 10);
        sumVar(7, 10);
        sumVar(-3, 10);
        sumVar(0, 0);
        sumVar(-3, -7);
    }

    private static void sumVar(int varA, int varB) {
//        int varA;
//        int varB;
        System.out.println(varA + varB);

    }

    private static void calculateSalary() {
        final int TAX_RUSSIA = 13;
        int salary  = calculateSalaryAfterTax(10000, TAX_RUSSIA);
        System.out.println("salary = " + salary);
        System.out.println("aftertax = " + calculateSalaryAfterTax(25000, TAX_RUSSIA) );
    }

    public static int calculateSalaryAfterTax(int salary, int tax) {
        return (int)(salary - salary * tax / 100.0);
    }


    private static void testString() {
        String helloStr = "Hello";
        String worldStr = "world";
        System.out.println(helloStr + " " + worldStr + (5 + 7));
    }


    private static void testCheckAppraisal() {
        checkAppraisal(5);
        checkAppraisal(4);
        checkAppraisal(3);
        checkAppraisal(2);
        checkAppraisal(0);
        checkAppraisal(6);
        checkAppraisal(-3);
    }

    private static void checkAppraisal(int appraisal) {
        System.out.print("Твоя оценка: " + appraisal + ". ");

        if(appraisal == 5) {
            System.out.println("Отлично! Так держать!");
        }
        else if (appraisal == 4) {
            System.out.println("Хорошо, но можно лучше");
        }
//        else if (appraisal == 3 || appraisal == 2 || appraisal == 1) {
        else if (appraisal >= 1 & appraisal <= 3) {
            System.out.println("Выключи планшет и садись за уроки!");
        }
//        else if(appraisal > 5 || appraisal < 1) {
        else {
            System.out.println("Читер!");
        }
        System.out.println("Проверка окончена");
    }

}
