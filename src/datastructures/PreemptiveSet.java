package datastructures;

import java.util.HashSet;
import java.util.Set;

public class PreemptiveSet {
    private Set<Integer> valueBuffer;
    private Set<Cell> cellBuffer;

    public PreemptiveSet() {
        this.valueBuffer = new HashSet<>();
        this.cellBuffer = new HashSet<>();
    }

    public void addValue(int value) {
        this.valueBuffer.add(value);
    }

    public void addCell(Cell C) {
        this.cellBuffer.add(C);
    }

    public boolean containsValue(int value) {
        return this.valueBuffer.contains(value);
    }

    public boolean containsCell(Cell C) {
        return this.cellBuffer.contains(C);
    }

    public void removeValue(int value) {
        this.valueBuffer.remove(value);
    }

    public void removeCell(Cell C) {
        this.cellBuffer.remove(C);
    }
}
