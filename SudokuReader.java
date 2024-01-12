// Importing necessary Java libraries for handling input/output operations.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// This class is responsible for reading Sudoku puzzles from a file.
public class SudokuReader {

    // Method to read a Sudoku puzzle from a file.
    // The file path is provided as a parameter.
    public int[][] readPuzzle(String filePath) throws IOException {
        // Creating a 9x9 array to store the puzzle. Puzzles are 9 rows by 9 columns.
        int[][] puzzle = new int[9][9];

        // Setting up a BufferedReader to read text from the file.
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int row = 0;

        // Reading the file line by line. Each line represents a row in the Sudoku puzzle.
        while ((line = br.readLine()) != null && row < 9) {
            // Splitting each line into values using a comma as the separator.
            String[] values = line.split(",");
            for (int col = 0; col < 9; col++) {
                // Checking if the value is 'x', which represents an empty cell.
                // If so, store 0 in the puzzle array.
                if (values[col].trim().equalsIgnoreCase("x")) {
                    puzzle[row][col] = 0;
                } else {
                    // Otherwise, convert the string to an integer and store it in the puzzle array.
                    puzzle[row][col] = Integer.parseInt(values[col].trim());
                }
            }
            // Move to the next row in the puzzle.
            row++;
        }

        // Closing the BufferedReader.
        br.close();

        // Returning the filled puzzle array.
        return puzzle;
    }

    // Method to print the puzzle to the console.
    // This is useful for verifying the puzzle read from the file.
    public void printPuzzle(int[][] puzzle) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Print each value in the puzzle followed by a space.
                System.out.print(puzzle[row][col] + " ");
            }
            // Print a new line at the end of each row.
            System.out.println();
        }
    }
}