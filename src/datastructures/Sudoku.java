package datastructures;

public class Sudoku {
    private static final int N = 3;
    private Grid buffer[][];

    public Sudoku() {
        this.buffer = new Grid[N][N];
    }

    public Grid getGrid(int i, int j) {
        return this.buffer[i][j];
    }

    public void setGrid(int i, int j, Grid g) {
        this.buffer[i][j] = g;
    }
}
