package ticTacToe.models;

import ticTacToe.enums.PieceType;

public class Board {
    private int size;
    private PieceType[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new PieceType[size][size];
    }

    public int getSize() {
        return size;
    }

    public boolean addPiece(int row, int col, PieceType piece) {
        if (row < 0 || row >= size || col < 0 || col >= size || grid[row][col] != null) {
            return false; // Invalid move
        }
        grid[row][col] = piece;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void removePiece(int row, int col) {
        grid[row][col] = null;
    }
}
