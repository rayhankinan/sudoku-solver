package datastructures;

public class Cell {
    private int value;
    private PreemptiveSet preemptiveSet;

    public Cell(int value) {
        this.value = value;
        this.preemptiveSet = new PreemptiveSet();
    }

    public int getValue() {
        return value;
    }

    public PreemptiveSet getPreemptiveSet() {
        return this.preemptiveSet;
    }
}
