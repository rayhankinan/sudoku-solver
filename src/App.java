import algorithms.SearchTree;
import datastructures.Sudoku;

public class App {
    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku();
        SearchTree searchTree = new SearchTree(sudoku);
    }
}
