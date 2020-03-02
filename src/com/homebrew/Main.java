package com.homebrew;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Enter a whole number as a parameter!");
            return;
        }

        int number;
        try {
            number = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number.\nEnter a whole number as a parameter!");
            return;
        }
        System.out.println(number + " is " + (isSemiprime(number) ? "" : "not ") + "a semiprime.");
    }

    static boolean isSemiprime(int number) {
        if (number == 1) {
            return true;
        }
        if (number < 1) {
            return false;
        }

        List<Integer> primeDivisors = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            if (number % i == 0 && isPrime(i)) {
                primeDivisors.add(i);
            }
        }

        for (int primeDivisor : primeDivisors) {
            if (primeDivisors.contains(number / primeDivisor)) {
                return true;
            }
        }
        return false;
    }

    static boolean isPrime(int number) {
        if (number == 1) {
            return true;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
