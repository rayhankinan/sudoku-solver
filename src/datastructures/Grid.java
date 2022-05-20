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
            for (Cell cell : row) {
                min = cell.getMarkup().getSize() < min ? cell.getMarkup().getSize() : min;
            }
        }

        return min;
    }

    public void removeAllCell(PreemptiveSet preemptiveSet) {
        for (Cell[] row : this.buffer) {
            for (Cell cell : row) {
                if (!preemptiveSet.getCellBuffer().contains(cell)) {
                    cell.getMarkup().removeAll(preemptiveSet.getMarkup());
                }
            }
        }
    }

    public Row getRow(int N) throws SudokuException {
        if (N < 0 || N >= Sudoku.size) {
            throw new SudokuException(String.format("Invalid row index (%d)!", N));

        } else {
            return new Row(this.buffer[N]);
        }
    }

    public Column getColumn(int M) throws SudokuException {
        if (M < 0 || M >= Sudoku.size) {
            throw new SudokuException(String.format("Invalid column index (%d)!", M));

        } else {
            Cell[] column = new Cell[Sudoku.size];

            for (int i = 0; i < Sudoku.size; i++) {
                column[i] = this.buffer[i][M];
            }

            return new Column(column);
        }
    }
}
