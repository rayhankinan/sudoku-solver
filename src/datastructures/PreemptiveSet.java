package datastructures;

import java.util.HashMap;
import java.util.Map;

public class PreemptiveSet {
    private Map<Integer, Cell> buffer;

    public PreemptiveSet() {
        this.buffer = new HashMap<>();
    }

    public void add(int value, Cell C) throws SudokuException {
        if (value <= 0 || value > Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid cell value (%d)!", value));

        } else {
            this.buffer.put(value, C);
        }
    }

    public Cell get(int value) throws SudokuException {
        if (this.buffer.get(value) == null) {
            throw new SudokuException(String.format("Invalid cell value (%d)!", value));

        } else {
            return this.buffer.get(value);
        }
    }

    public void remove(int value) {
        this.buffer.remove(value);
    }
}
