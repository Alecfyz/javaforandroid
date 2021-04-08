package lesson14.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Homework14 {
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Integer[] intarr = new Integer[]{1,2,2,4,64,7,9,889,3,4,5,6};

        Integer[] resArr = checkQuad(intarr);
        for (int a: resArr ) {
            System.out.print("_" + a + "_ ");
        }
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-");

        Integer[] intarr2 = new Integer[]{1, 1, 1, 1};
        System.out.println(checkOneFourArr(intarr2) ? "Массив корректен.":RED_BOLD+"Массив НЕ корректен"+ANSI_RESET);
    }

    public static Integer[] checkQuad(Integer[] intarr) {
        Integer[] result = null;
        int pos;
        int newLen;
        ArrayList<Integer> al = new ArrayList<>(Arrays.asList(intarr));
        System.out.println(al.toString());

            pos = al.lastIndexOf(4);
            if (pos < 0) {
                throw new RuntimeException("Нет четверок!");
            }
            System.out.println("pos = " + pos);
            newLen = intarr.length - pos - 1;
            if (newLen <= 0) {
                System.out.println(RED_BOLD + "Ключ стоит в исходном массиве на последнем индексе, нечего копировать в новый." + ANSI_RESET);
                result = new Integer[0];
            } else {
                Integer[] resArr = new Integer[newLen];
                System.arraycopy(intarr, pos + 1, resArr, 0, newLen);
                result = resArr;
            }

        if (result == null) result = new Integer[0];
        return result;
    }

    public static boolean checkOneFourArr(Integer[] intarr2) {
        boolean res = false;
        HashSet<Integer> unic = new HashSet<>();
        for (int i: intarr2
             ) {
            unic.add(i);
        }

        if (unic.contains(1) && unic.contains(4) && unic.size() == 2)
            res = true;

        System.out.println("Unic:" + unic.toString());
    return res;
    }
    
}
