package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import datastructures.Cell;
import datastructures.Sudoku;
import datastructures.SudokuException;

public class SearchTree {
    private Sudoku root;
    private Sudoku solution;

    public SearchTree(Sudoku root) {
        this.root = root;
        this.solution = new Sudoku();
    }

    public void solve() throws SudokuException {
        Queue<Sudoku> Q = new LinkedList<>();

        this.root.solve();
        Q.add(this.root);

        while (!Q.isEmpty()) {
            Sudoku currentSudoku = Q.poll();

            if (currentSudoku.isSolved()) {
                this.solution = currentSudoku;

            } else {
                Cell firstEmptyCell = currentSudoku.getFirstEmptyCell();

                for (int value : firstEmptyCell.getMarkup().getValueBuffer()) {
                    Sudoku newSudoku = currentSudoku.changeFirstEmptyCell(value);

                    newSudoku.solve();
                }
            }
        }
    }

    public Sudoku getRoot() {
        return this.root;
    }

    public Sudoku getSolution() {
        return this.solution;
    }
}
