package datastructures;

public class SearchTree {
    private Sudoku root;

    public SearchTree(Sudoku root) {
        this.root = root;
    }

    public void solve() throws SudokuException {
        /* TODO: SOLVE USING CROOK'S ALGORITHM */

        /* STEP 1: MARKUP EVERY CELL */
        for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
            for (int j = 0; j < Sudoku.size * Sudoku.size; j++) {
                for (int initialValue = 1; initialValue <= Sudoku.size * Sudoku.size; initialValue++) {
                    this.root.getCell(i, j).getMarkup().addValue(initialValue);
                }

                Cell[] row = this.root.getRow(i);
                for (Cell cell : row) {
                    this.root.getCell(i, j).getMarkup().removeValue(cell.getValue());
                }

                Cell[] column = this.root.getColumn(j);
                for (Cell cell : column) {
                    this.root.getCell(i, j).getMarkup().removeValue(cell.getValue());
                }

                Cell[][] grid = this.root.getGrid(i, j);
                for (Cell[] buffer : grid) {
                    for (Cell cell : buffer) {
                        this.root.getCell(i, j).getMarkup().removeValue(cell.getValue());
                    }
                }

                if (this.root.getCell(i, j).getValue() != -1) {
                    throw new SudokuException("Invalid sudoku grid!");
                }
            }
        }
    }
}
