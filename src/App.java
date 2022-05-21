import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import algorithms.SearchTree;
import datastructures.Sudoku;
import utils.CSVReader;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama file: ");
        String filename = scanner.nextLine();

        CSVReader csvReader = new CSVReader(filename);

        Sudoku sudoku = csvReader.getSudoku();

        if (sudoku != null) {
            SearchTree searchTree = new SearchTree(sudoku);

            long startTime = System.nanoTime();
            searchTree.solve();
            long endTime = System.nanoTime();

            double executionTime = ((double) (endTime - startTime)) * 1e-9;
            BigDecimal bigDecimal = new BigDecimal(executionTime).setScale(3, RoundingMode.HALF_EVEN);

            System.out.println();
            searchTree.getSolution().print();

            System.out.printf("Waktu eksekusi: %.3f s\n", bigDecimal.doubleValue());
        }

        scanner.close();
    }
}
