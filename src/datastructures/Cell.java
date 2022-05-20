package datastructures;

public class Cell {
    private int value;
    private Markup markup;

    public Cell(int value) throws SudokuException {
        if (value < 0 || value > Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid cell value (%d)!", value));

        } else {
            this.value = value;
            this.markup = new Markup();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) throws SudokuException {
        if (value < 0 || value > Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid cell value (%d)!", value));

        } else {
            this.value = value;
        }
    }

    public Markup getMarkup() {
        return this.markup;
    }

    public void setSingleton() throws SudokuException {
        this.value = this.markup.getSingleton();
    }

    public boolean equals(Cell C) {
        return this.value == C.value && this.markup.equals(C.markup);
    }

    public Cell cloneCell() throws SudokuException {
        Cell C = new Cell(this.value);

        C.markup = this.markup.cloneMarkup();

        return C;
    }

    public String toString() {
        return String.format("%d %s", this.value, this.markup.toString());
    }
}
