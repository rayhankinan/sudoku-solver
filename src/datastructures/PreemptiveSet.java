package datastructures;

import java.util.HashSet;
import java.util.Set;

public class PreemptiveSet {
    private final Set<Integer> valueBuffer;
    private final Set<Cell> cellBuffer;

    public PreemptiveSet() {
        this.valueBuffer = new HashSet<>();
        this.cellBuffer = new HashSet<>();
    }

    public void addValue(int value) {
        this.valueBuffer.add(value);
    }

    public boolean containsValue(int value) {
        return this.valueBuffer.contains(value);
    }

    public void removeValue(int value) {
        this.valueBuffer.remove(value);
    }

    public void addCell(Cell C) {
        this.cellBuffer.add(C);
    }

    public boolean containsCell(Cell C) {
        return this.cellBuffer.contains(C);
    }

    public void removeCell(Cell C) {
        this.cellBuffer.remove(C);
    }
}
