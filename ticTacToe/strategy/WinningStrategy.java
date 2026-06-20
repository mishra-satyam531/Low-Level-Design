package ticTacToe.strategy;

import ticTacToe.enums.PieceType;
import ticTacToe.models.Board;

public interface WinningStrategy {
    boolean checkWinner(Board board, int row, int col, PieceType pieceType);

    void undoMove(Board board, int row, int col, PieceType pieceType);
}
