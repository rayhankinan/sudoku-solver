package utils;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import datastructures.Sudoku;
import datastructures.SudokuException;
import datastructures.Cell;

public class CSVReader {
    private Sudoku sudoku;

    public CSVReader(String filename) throws SudokuException {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            this.sudoku = new Sudoku();

            for (int i = 0; i < Sudoku.size * Sudoku.size; i++) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                for (int j = 0; j < Sudoku.size * Sudoku.size; j++) {
                    this.sudoku.setCell(i, j, new Cell(Integer.parseInt(data[j])));
                }
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Sudoku getSudoku() {
        return this.sudoku;
    }
}
