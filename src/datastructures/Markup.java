package datastructures;

import java.util.HashSet;
import java.util.Set;

public class Markup {
    private final Set<Integer> valueBuffer;

    public Markup() {
        this.valueBuffer = new HashSet<>();
    }

    public void addValue(int value) throws SudokuException {
        if (value <= 0 || value > Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid cell value (%d)!", value));

        } else {
            this.valueBuffer.add(value);
        }
    }

    public boolean containsValue(int value) {
        return this.valueBuffer.contains(value);
    }

    public void removeValue(int value) {
        this.valueBuffer.remove(value);
    }
}
