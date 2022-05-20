package datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Markup {
    private Set<Integer> valueBuffer;

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

    public int getSizeValue() {
        return this.valueBuffer.size();
    }

    public int getSingleton() throws SudokuException {
        if (this.valueBuffer.size() != 1) {
            throw new SudokuException("Markup is not a singleton!");

        } else {
            Iterator<Integer> it = this.valueBuffer.iterator();
            this.valueBuffer.clear();

            return it.next();
        }
    }

    public void clear() {
        this.valueBuffer.clear();
    }

    public Markup cloneMarkup() throws SudokuException {
        Markup M = new Markup();

        Iterator<Integer> it = this.valueBuffer.iterator();
        while (it.hasNext()) {
            M.valueBuffer.add(it.next());
        }

        return M;
    }

    public int getSize() {
        return this.valueBuffer.size();
    }
}
