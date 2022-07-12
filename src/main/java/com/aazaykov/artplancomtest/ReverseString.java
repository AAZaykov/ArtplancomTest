package com.aazaykov.artplancomtest;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        long start = System.currentTimeMillis();
        String s = null;
        for (int i = 0; i < 1000; i++) {
            reverseString(str);
        }
        for (int i = 0; i < 10000; i++) {
            reverseString(str);
        }
        for (int i = 0; i < 100000; i++) {
            s = reverseString(str);
        }
        System.out.println(s);
        long finish = System.currentTimeMillis();
        System.out.println(String.format("%03d",(finish - start)));
    }

    static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }
}