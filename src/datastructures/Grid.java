package datastructures;

public class Grid {
    private static final int N = 3;
    private Cell buffer[][];

    public Grid() {
        this.buffer = new Cell[N][N];
    }

    public Cell getCell(int i, int j) {
        return this.buffer[i][j];
    }

    public void setCell(int i, int j, Cell c) {
        this.buffer[i][j] = c;
    }
}
