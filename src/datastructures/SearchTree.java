package datastructures;

public class SearchTree {
    private Sudoku root;

    public SearchTree(Sudoku root) {
        this.root = root;
    }

    public void solve() throws SudokuException {
        Sudoku oldSolution;

        do {
            /* SIMPLE SOLUTION */
            oldSolution = this.root.cloneSudoku();

            Sudoku oldSimpleSolution;
            do {
                oldSimpleSolution = this.root.cloneSudoku();

                /* STEP 1: MARKUP EVERY CELL */
                this.root.markupAllCell();

                /* STEP 2: FIND ALL SINGLETON */
                this.root.findAllSingleton();

            } while (!oldSimpleSolution.equals(this.root));

            /* TODO: SOLVE USING CROOK'S ALGORITHM */
            Sudoku oldCrookerSolution;
            do {
                oldCrookerSolution = this.root.cloneSudoku();

            } while(!oldCrookerSolution.equals(this.root));


        } while (!oldSolution.equals(this.root));
    }
}
