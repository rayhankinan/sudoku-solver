package datastructures;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PreemptiveSet {
    private Set<Cell> cellBuffer;
    private Markup markup;

    public PreemptiveSet() {
        this.cellBuffer = new HashSet<>();
        this.markup = new Markup();
    }

    public void add(Cell C) {
        this.cellBuffer.add(C);
        this.markup.addAll(C.getMarkup());
    }

    public Set<Cell> getCellBuffer() {
        return this.cellBuffer;
    }

    public Markup getMarkup() {
        return this.markup;
    }

    public int getSizeCell() {
        return this.cellBuffer.size();
    }

    public void print() {
        System.out.println(Arrays.toString(this.cellBuffer.toArray()));
    }
}
