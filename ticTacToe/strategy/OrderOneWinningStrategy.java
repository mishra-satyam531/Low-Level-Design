package ticTacToe.strategy;

import ticTacToe.enums.PieceType;
import ticTacToe.models.Board;

public class OrderOneWinningStrategy implements WinningStrategy {
    private int[] rowCounts;
    private int[] colCounts;
    private int mainDiagonalCount;
    private int antiDiagonalCount;
    private int boardSize;

    public OrderOneWinningStrategy(int boardSize) {
        this.boardSize = boardSize;
        this.rowCounts = new int[boardSize];
        this.colCounts = new int[boardSize];
        this.mainDiagonalCount = 0;
        this.antiDiagonalCount = 0;
    }

    @Override
    public boolean checkWinner(Board board, int row, int col, PieceType pieceType) {
        int score = (pieceType == PieceType.X) ? 1 : -1;

        rowCounts[row] += score;
        colCounts[col] += score;

        if (row == col) {
            mainDiagonalCount += score;
        }
        
        if (row + col == boardSize - 1) {
            antiDiagonalCount += score;
        }

        // Check if any line has absolute sum == boardSize
        return Math.abs(rowCounts[row]) == boardSize ||
               Math.abs(colCounts[col]) == boardSize ||
               Math.abs(mainDiagonalCount) == boardSize ||
               Math.abs(antiDiagonalCount) == boardSize;
    }

    @Override
    public void undoMove(Board board, int row, int col, PieceType pieceType) {
        int score = (pieceType == PieceType.X) ? 1 : -1;

        rowCounts[row] -= score;
        colCounts[col] -= score;

        if (row == col) {
            mainDiagonalCount -= score;
        }
        
        if (row + col == boardSize - 1) {
            antiDiagonalCount -= score;
        }
    }
}
