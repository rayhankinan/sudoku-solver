package datastructures;

public class Grid {
    private Cell[][] buffer;

    public Grid(Cell[][] buffer) {
        this.buffer = buffer;
    }

    public Cell[][] getBuffer() {
        return this.buffer;
    }

    public int getMaxMarkupLength() {
        int max = 0;

        for (Cell[] row : this.buffer) {
            for (Cell C : row) {
                max = C.getMarkup().getSize() > max ? C.getMarkup().getSize() : max;
            }
        }

        return max;
    }

    public int getMinMarkupLength() {
        int min = Sudoku.size * Sudoku.size;

        for (Cell[] row : this.buffer) {
            for (Cell C : row) {
                min = C.getMarkup().getSize() < min ? C.getMarkup().getSize() : min;
            }
        }

        return min;
    }

    public void loopGrid() {
        int min = this.getMinMarkupLength();
        int max = this.getMaxMarkupLength();

        for (int K = max; K >= min; K--) {
            /* TODO: SOLVE USING CROOK'S ALGORITHM */
        }
    }
}
