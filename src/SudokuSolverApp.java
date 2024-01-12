// Importing necessary Java libraries for handling input/output operations.
import java.io.IOException;

// Main class of the Sudoku Solver application.
public class SudokuSolverApp {
    // The main method - this is where the program starts executing.
    public static void main(String[] args) {

        // Creating objects of the SudokuReader, SudokuSolver, and SudokuWriter classes.
        SudokuReader reader = new SudokuReader();
        SudokuSolver solver = new SudokuSolver();
        SudokuWriter writer = new SudokuWriter();

        try {
            // Define the file paths for the input and output files.
            String inputFilePath = "/Users/mickelsamuel/Desktop/Sudoku/input.txt";
            String outputFilePath = "/Users/mickelsamuel/Desktop/Sudoku/output.txt";

            // Reading the Sudoku puzzle from the input file.
            int[][] puzzle = reader.readPuzzle(inputFilePath);

            // Printing the original Sudoku puzzle to the console.
            System.out.println("Original Sudoku Puzzle:");
            reader.printPuzzle(puzzle);

            // Adding an empty line for better readability in the console.
            System.out.println();

            // Attempting to solve the Sudoku puzzle.
            if (solver.solve(puzzle)) {
                // If the puzzle is solved, print the solved puzzle to the console.
                System.out.println("Sudoku Solved:");
                reader.printPuzzle(puzzle);

                // Write the solved puzzle to the output file.
                writer.writePuzzle(puzzle, outputFilePath);

                // Reset the input file with 'x' in all cells after solving.
                // This prepares the file for the next use.
                writer.resetPuzzle(inputFilePath);

                // Adding an empty line for better readability in the console.
                System.out.println();

                System.out.println("Input file has been reset for next use.");
            } else {
                // If the puzzle cannot be solved, print a message indicating this.
                System.out.println("No solution exists for the given Sudoku puzzle.");
            }
        } catch (IOException e) {
            // If there is an error during file reading or writing, print the error details.
            e.printStackTrace();
        }
    }
}