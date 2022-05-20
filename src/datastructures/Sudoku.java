package datastructures;

public class Sudoku {
    public static final int size = 3;

    private final Cell buffer[][];
    private final PreemptiveSet preemptiveSet;

    public Sudoku() {
        this.buffer = new Cell[Sudoku.size * Sudoku.size][Sudoku.size * Sudoku.size];
        this.preemptiveSet = new PreemptiveSet();
    }

    public Cell getCell(int N, int M) {
        return this.buffer[N][M];
    }

    public Cell[] getRow(int N) {
        return this.buffer[N];
    }

    public Cell[] getColumn(int M) {
        Cell[] column = new Cell[Sudoku.size * Sudoku.size];

        for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
            column[i] = this.buffer[i][M];
        }

        return column;
    }

    public Cell[][] getGrid(int N, int M) {
        Cell[][] grid = new Cell[Sudoku.size][Sudoku.size];

        for (int i = N * Sudoku.size; i < (N + 1) * Sudoku.size; i++) {
            for (int j = M * Sudoku.size; j < (M + 1) * Sudoku.size; j++) {
                grid[i - N * Sudoku.size][j - M * Sudoku.size] = this.buffer[i][j];
            }
        }

        return grid;
    }

    public void setCell(int N, int M, Cell C) {
        this.buffer[N][M] = C;
    }

    public PreemptiveSet getPreemptiveSet() {
        return this.preemptiveSet;
    }
}
