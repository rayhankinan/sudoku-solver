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

            searchTree.solve();

            searchTree.getSolution().print();
        }

        scanner.close();
    }
}
