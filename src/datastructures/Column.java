package datastructures;

public class Column {
    private Cell[] buffer;

    public Column(Cell[] buffer) {
        this.buffer = buffer;
    }

    public Cell[] getBuffer() {
        return this.buffer;
    }

    public int getMaxMarkupLength() {
        int max = 0;

        for (Cell C : this.buffer) {
            max = C.getMarkup().getSize() > max ? C.getMarkup().getSize() : max;
        }

        return max;
    }

    public int getMinMarkupLength() {
        int min = Sudoku.size * Sudoku.size;

        for (Cell C : this.buffer) {
            min = C.getMarkup().getSize() < min ? C.getMarkup().getSize() : min;
        }

        return min;
    }

    public void loopColumn() {
        int min = this.getMinMarkupLength();
        int max = this.getMaxMarkupLength();

        for (int K = max; K >= min; K--) {
            /* TODO: SOLVE USING CROOK'S ALGORITHM */
        }
    }
}
