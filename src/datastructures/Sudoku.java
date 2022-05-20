package datastructures;

public class Sudoku {
    public static final int size = 3;

    private Cell buffer[][];

    public Sudoku() {
        this.buffer = new Cell[Sudoku.size * Sudoku.size][Sudoku.size * Sudoku.size];
    }

    public Cell getCell(int N, int M) throws SudokuException {
        if (N < 0 || N >= Sudoku.size * Sudoku.size || M < 0 || M >= Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid cell index (%d, %d)!", N, M));

        } else {
            return this.buffer[N][M];
        }
    }

    public Cell[] getRow(int N) throws SudokuException {
        if (N < 0 || N >= Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid row index (%d)!", N));

        } else {
            return this.buffer[N];
        }
    }

    public Cell[] getColumn(int M) throws SudokuException {
        if (M < 0 || M >= Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid column index (%d)!", M));

        } else {
            Cell[] column = new Cell[Sudoku.size * Sudoku.size];

            for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
                column[i] = this.buffer[i][M];
            }

            return column;
        }
    }

    public Cell[][] getGrid(int N, int M) throws SudokuException {
        if (N < 0 || N >= Sudoku.size || M < 0 || M >= Sudoku.size) {
            throw new SudokuException(String.format("Invalid grid index (%d, %d)!", N, M));

        } else {
            Cell[][] grid = new Cell[Sudoku.size][Sudoku.size];

            for (int i = N * Sudoku.size; i < (N + 1) * Sudoku.size; i++) {
                for (int j = M * Sudoku.size; j < (M + 1) * Sudoku.size; j++) {
                    grid[i - N * Sudoku.size][j - M * Sudoku.size] = this.buffer[i][j];
                }
            }

            return grid;
        }
    }

    public void setCell(int N, int M, Cell C) {
        this.buffer[N][M] = C;
    }

    public void markupAllCell() throws SudokuException {
        for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
            for (int j = 0; j < Sudoku.size * Sudoku.size; j++) {
                if (this.getCell(i, j).getValue() == 0) {
                    this.getCell(i, j).getMarkup().clear();

                    for (int initialValue = 1; initialValue <= Sudoku.size * Sudoku.size; initialValue++) {
                        this.getCell(i, j).getMarkup().addValue(initialValue);
                    }

                    Cell[] row = this.getRow(i);
                    for (Cell cell : row) {
                        this.getCell(i, j).getMarkup().removeValue(cell.getValue());
                    }
    
                    Cell[] column = this.getColumn(j);
                    for (Cell cell : column) {
                        this.getCell(i, j).getMarkup().removeValue(cell.getValue());
                    }
    
                    Cell[][] grid = this.getGrid(i, j);
                    for (Cell[] buffer : grid) {
                        for (Cell cell : buffer) {
                            this.getCell(i, j).getMarkup().removeValue(cell.getValue());
                        }
                    }
                }
            }
        }
    }

    public void findAllSingleton() throws SudokuException {
        for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
            for (int j = 0; j < Sudoku.size * Sudoku.size; j++) {
                this.getCell(i, j).setSingleton();
            }
        }
    }

    public boolean equals(Sudoku S) throws SudokuException {
        for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
            for (int j = 0; j < Sudoku.size * Sudoku.size; j++) {
                if (!this.getCell(i, j).equals(S.getCell(i, j))) {
                    return false;
                }
            }
        }

        return true;
    }

    public Sudoku cloneSudoku() throws SudokuException {
        Sudoku S = new Sudoku();

        for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
            for (int j = 0; j < Sudoku.size * Sudoku.size; j++) {
                S.buffer[i][j] = this.buffer[i][j].cloneCell();
            }
        }

        return S;
    }

    public void loopBasic() throws SudokuException {
        Sudoku oldSimpleSolution;

        do {
            oldSimpleSolution = this.cloneSudoku();

            /* MARKUP EVERY CELL */
            this.markupAllCell();

            /* FIND ALL SINGLETON */
            this.findAllSingleton();

        } while (!oldSimpleSolution.equals(this));
    }

    public void loopCrooker() throws SudokuException {
        Sudoku oldCrookerSolution;
        do {
            oldCrookerSolution = this.cloneSudoku();
            
            /* TODO: SOLVE USING CROOK'S ALGORITHM */

            

        } while(!oldCrookerSolution.equals(this));
    }
}
