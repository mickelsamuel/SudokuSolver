// Importing necessary Java libraries for handling file writing operations.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// This class is responsible for writing the solved Sudoku puzzle to a file.
public class SudokuWriter {

    // Method to write the solved puzzle into a file.
    // It takes the solved puzzle array and the file path as parameters.
    public void writePuzzle(int[][] solvedPuzzle, String filePath) throws IOException {
        // Setting up a BufferedWriter to write text to the file.
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

        // Looping through each row of the solved puzzle.
        for (int row = 0; row < 9; row++) {
            // Using StringBuilder to create a string representation of each row.
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < 9; col++) {
                // Appending each number in the row to the line.
                line.append(solvedPuzzle[row][col]);
                // Adding a comma after each number except the last one in the row.
                if (col < 8) {
                    line.append(",");
                }
            }
            // Writing the line to the file.
            bw.write(line.toString());
            // Adding a new line after each row except the last one.
            if (row < 8) {
                bw.newLine();
            }
        }

        // Closing the BufferedWriter to finish writing and save the file.
        bw.close();
    }

    // Method to reset the puzzle in the file with 'x' in all cells.
    public void resetPuzzle(String filePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));

        // String representing a row with all 'x'.
        String resetRow = "x,x,x,x,x,x,x,x,x";

        for (int row = 0; row < 9; row++) {
            bw.write(resetRow);
            if (row < 8) {
                bw.newLine(); // Add a new line after each row except the last one.
            }
        }

        bw.close();
    }
}