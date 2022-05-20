package datastructures;

public class Cell {
    private int value;
    private final Markup markup;

    public Cell(int value) throws SudokuException {
        if (value <= 0 || value > Sudoku.size * Sudoku.size) {
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
        if (value <= 0 || value > Sudoku.size * Sudoku.size) {
            throw new SudokuException(String.format("Invalid cell value (%d)!", value));

        } else {
            this.value = value;
        }
    }

    public Markup getMarkup() {
        return this.markup;
    }
}
