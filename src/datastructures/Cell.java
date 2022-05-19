package datastructures;

public class Cell {
    private int value;
    private Markup markup;

    public Cell(int value) {
        this.value = value;
        this.markup = new Markup();
    }

    public int getValue() {
        return value;
    }

    public Markup getMarkup() {
        return this.markup;
    }
}
