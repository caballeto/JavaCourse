package com.labs;

public class Matrix {
    private static final int RANDOM_BOUND = 100;
    private static final String PRINT_FORMAT = "%" + (int) (Math.log10(RANDOM_BOUND) + 1) + "d ";
    private int[][] matrix;

    public Matrix(int n) {
        matrix = new int[n][n];
    }

    public void fill() {
        int n = matrix.length;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = (int) (Math.random() * RANDOM_BOUND) - 50;
    }

    public void print() {
        print(matrix);
    }

    public void print(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.printf(PRINT_FORMAT, elem);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void process() {
        final int N = matrix.length;

        for (int i = 0; i < N/2; i++) {
            for (int j = 0;j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - i - 1][N - j - 1];
                matrix[N - i - 1][N - j - 1] = temp;
            }
        }
    }
}
