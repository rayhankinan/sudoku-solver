package algorithms;

import datastructures.Sudoku;
import datastructures.SudokuException;

public class SearchTree {
    private Sudoku root;

    public SearchTree(Sudoku root) {
        this.root = root;
    }

    public void solve() throws SudokuException {
        /* TODO: SHOW ALL SOLUTION USING BFS OR DFS */
        
        this.root.solve();
    }

    public Sudoku getRoot() {
        return this.root;
    }
}
