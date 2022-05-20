package datastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Markup {
    private Set<Integer> valueBuffer;

    public Markup() {
        this.valueBuffer = new HashSet<>();
    }

    public void add(int value) throws SudokuException {
        if (value <= 0 || value > Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid cell value (%d)!", value));

        } else {
            this.valueBuffer.add(value);
        }
    }

    public boolean contains(int value) {
        return this.valueBuffer.contains(value);
    }

    public void remove(int value) {
        this.valueBuffer.remove(value);
    }

    public Set<Integer> getValueBuffer() {
        return this.valueBuffer;
    }

    public int getSize() {
        return this.valueBuffer.size();
    }

    public int getSingleton() throws SudokuException {
        if (this.valueBuffer.size() != 1) {
            throw new SudokuException("Markup is not a singleton!");

        } else {
            Iterator<Integer> it = this.valueBuffer.iterator();
            int value = it.next();
            this.valueBuffer.clear();

            return value;
        }
    }

    public boolean equals(Markup markup) {
        return this.valueBuffer.equals(markup.valueBuffer);
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

    public void addAll(Markup markup) {
        this.valueBuffer.addAll(markup.valueBuffer);
    }

    public boolean containsAll(Markup markup) {
        return this.valueBuffer.containsAll(markup.valueBuffer);
    }

    public void removeAll(Markup markup) {
        this.valueBuffer.removeAll(markup.valueBuffer);
    }

    public String toString() {
        return Arrays.toString(this.valueBuffer.toArray());
    }
}
