package datastructures;

public class Cell {
    private int value;
    private final Markup markup;

    public Cell(int value) {
        this.value = value;
        this.markup = new Markup();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Markup getMarkup() {
        return this.markup;
    }
}
