package datastructures;

import java.util.HashSet;
import java.util.Set;

public class PreemptiveSet {
    private Set<Cell> buffer;

    public PreemptiveSet() {
        this.buffer = new HashSet<>();
    }

    public void addCell(Cell c) {
        this.buffer.add(c);
    }

    public boolean contains(Cell c) {
        return this.buffer.contains(c);
    }

    public void removeCell(Cell c) {
        this.buffer.remove(c);
    }
}
