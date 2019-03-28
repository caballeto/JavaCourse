package com.labs;

import java.util.Scanner;

public class Lab1 {
    private static final String INITIALS = "Authored by: Mokrousov V. R.";

    private static void start() {
        System.out.println(INITIALS);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        start();

        System.out.print("Insert matrix size\n> ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        Matrix matrix = new Matrix(n);

        matrix.fill();
        matrix.print();
        matrix.process();
        matrix.print();
    }
}
