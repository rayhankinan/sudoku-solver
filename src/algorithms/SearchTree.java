package algorithms;

import datastructures.Sudoku;
import datastructures.SudokuException;

public class SearchTree {
    private Sudoku root;

    public SearchTree(Sudoku root) {
        this.root = root;
    }

    public void solve() throws SudokuException {
        Sudoku oldSolution;

        do {
            oldSolution = this.root.cloneSudoku();

            this.root.loopBasic();
            this.root.loopCrooker();

        } while (!oldSolution.equals(this.root));
    }

    public Sudoku getRoot() {
        return this.root;
    }
}
