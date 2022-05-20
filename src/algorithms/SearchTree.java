package algorithms;

import java.util.Stack;

import datastructures.Cell;
import datastructures.Sudoku;
import datastructures.SudokuException;

public class SearchTree {
    private Sudoku root;
    private Sudoku solution;

    public SearchTree(Sudoku root) {
        this.root = root;
        this.solution = new Sudoku();
    }

    public void solve() throws SudokuException {
        Stack<Sudoku> S = new Stack<>();

        this.root.solve();
        S.push(this.root);

        while (!S.isEmpty()) {
            Sudoku currentSudoku = S.pop();

            if (currentSudoku.isSolved()) {
                this.solution = currentSudoku;
                break;

            } else {
                try {
                    Cell firstEmptyCell = currentSudoku.getFirstEmptyCell();

                    for (int value : firstEmptyCell.getMarkup().getValueBuffer()) {
                        Sudoku newSudoku = currentSudoku.changeFirstEmptyCell(value);

                        S.push(newSudoku);
                    }

                } catch (SudokuException e) {
                    continue;
                }
            }
        }
    }

    public Sudoku getRoot() {
        return this.root;
    }

    public Sudoku getSolution() {
        return this.solution;
    }
}
