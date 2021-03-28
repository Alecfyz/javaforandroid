package lesson11;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Homework1 {
    public static void main(String[] args) {
        String[] strArr = new String[]{"one", "two", "THREE", "four", "FIVE", "six", "seven"};
        Integer[] intArr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println("Ex. #1");
        swap(strArr, 2, 4);
        swap(intArr, 1, 8);
        System.out.println();

        System.out.println("Ex. #2");
        System.out.println(turnToArrList(strArr).toString());
        System.out.println(turnToArrList(intArr).toString());
    }


    private static <E extends Comparable<E>> void swap(E[] arr, int addrA, int addrB) {
        E tmp = arr[addrA];
        arr[addrA] = arr[addrB];
        arr[addrB] = tmp;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1)
                System.out.print(", ");
        }
        System.out.println();
        System.out.println("===");
    }

    private static <E> ArrayList<E> turnToArrList(E[] arr) {
        ArrayList<E> myArrList = new ArrayList<>();
        Collections.addAll(myArrList, arr);
        return myArrList;
    }}