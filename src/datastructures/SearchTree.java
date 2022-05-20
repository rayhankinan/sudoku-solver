package datastructures;

public class SearchTree {
    private Sudoku root;

    public SearchTree(Sudoku root) {
        this.root = root;
    }

    public void solve() throws SudokuException {
        /* TODO: SOLVE USING CROOK'S ALGORITHM */

        /* STEP 1: MARKUP EVERY CELL */
        this.root.markupAllCell();

        /* STEP 2: FIND ALL SINGLETON */
        this.root.findAllSingleton();

        /* STEP 3: FIND PREEMPTIVE SETS */
    }
}
