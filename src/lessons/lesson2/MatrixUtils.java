package lessons.lesson2;

import lessons.lesson2.exceptions.NumberOfInputElementsException;

import java.util.Arrays;

public class MatrixUtils {

    static int SIZE = 4;

    static String[][] parseMatrix(String string) throws NumberOfInputElementsException {

        String[][] result = new String[4][4];
        String[] strings = string.split("\\D+");
        if (strings.length != SIZE * SIZE) {
            throw new NumberOfInputElementsException();
        }

        for (int i = 0, k = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = strings[k++];
            }
        }

        return result;

    }

    static int[][] matrixToInts(String[][] matrix) {

        int[][] result = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result[i][j] = Integer.parseInt(matrix[i][j]);
            }
        }

        return result;

    }

    public static void main(String[] args) {

        try {
            // First
            System.out.println(Arrays.deepToString(parseMatrix("1 2 3 4\nfsdf s 5 6 7 8\n 9 dsfdsf 10 11 12\n 13 gfgdf 14 15 16")));
            System.out.println(Arrays.deepToString(parseMatrix("1 2 3 4\nfsdf s 5 6 7 8\n 9 dsfdsf 10 11 12\n 13 gfgdf 14 15")));
        } catch (NumberOfInputElementsException e) {
            e.printStackTrace();
        }

    }


}
