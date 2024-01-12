// This class contains the logic to solve a Sudoku puzzle.
public class SudokuSolver {

    // Method to solve the Sudoku puzzle.
    // This method uses recursion and backtracking to find the solution.
    public boolean solve(int[][] puzzle) {
        // Loop through each cell in the 9x9 grid.
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Check if the cell is empty (represented by 0).
                if (puzzle[row][col] == 0) {
                    // Try filling the cell with numbers from 1 to 9.
                    for (int number = 1; number <= 9; number++) {
                        // Check if placing 'number' in the current cell is valid according to Sudoku rules.
                        if (isValid(puzzle, row, col, number)) {
                            // Place the number in the cell.
                            puzzle[row][col] = number;

                            // Recursively try to solve the rest of the puzzle with this number in place.
                            if (solve(puzzle)) {
                                return true; // Puzzle solved successfully with the current placement.
                            } else {
                                // If placing 'number' didn't lead to a solution, reset the cell and backtrack.
                                puzzle[row][col] = 0;
                            }
                        }
                    }
                    // If no number from 1 to 9 can solve the puzzle, return false to trigger backtracking.
                    return false;
                }
            }
        }
        // If the entire grid is filled without conflicts, the puzzle is solved.
        return true;
    }

    // Helper method to check if placing a number in the given cell is valid.
    private boolean isValid(int[][] puzzle, int row, int col, int number) {
        // The number must not be already present in the same row, column, or 3x3 subgrid.
        return !isInRow(puzzle, row, number) && !isInCol(puzzle, col, number) && !isInBox(puzzle, row - row % 3, col - col % 3, number);
    }

    // Helper method to check if a number is present in the given row.
    private boolean isInRow(int[][] puzzle, int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[row][i] == number) {
                return true; // Number found in the row.
            }
        }
        return false; // Number not found in the row.
    }

    // Helper method to check if a number is present in the given column.
    private boolean isInCol(int[][] puzzle, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[i][col] == number) {
                return true; // Number found in the column.
            }
        }
        return false; // Number not found in the column.
    }

    // Helper method to check if a number is present in the 3x3 subgrid.
    private boolean isInBox(int[][] puzzle, int boxStartRow, int boxStartCol, int number) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (puzzle[row + boxStartRow][col + boxStartCol] == number) {
                    return true; // Number found in the subgrid.
                }
            }
        }
        return false; // Number not found in the subgrid.
    }
}