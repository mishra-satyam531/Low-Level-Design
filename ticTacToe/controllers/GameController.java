package ticTacToe.controllers;

import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

import ticTacToe.enums.GameState;
import ticTacToe.models.Board;
import ticTacToe.models.Move;
import ticTacToe.models.Player;
import ticTacToe.strategy.WinningStrategy;

public class GameController {
    private Board board;
    private Deque<Player> players;
    private WinningStrategy winningStrategy;
    private GameState gameState;
    private Stack<Move> movesHistory;

    public GameController(Board board, Deque<Player> players, WinningStrategy winningStrategy) {
        this.board = board;
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.gameState = GameState.IN_PROGRESS;
        this.movesHistory = new Stack<>();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        int totalMoves = 0;
        int maxMoves = board.getSize() * board.getSize();

        while (gameState == GameState.IN_PROGRESS) {
            board.printBoard();
            Player currentPlayer = players.pollFirst(); 

            System.out.println(currentPlayer.getName() + "'s turn. Enter Row number or type 'undo': ");
            String rowInput = scanner.next();

            // Check for undo during row input
            if (rowInput.equalsIgnoreCase("undo")) {
                players.addFirst(currentPlayer);
                boolean undoSuccess = undoMove();
                if (undoSuccess) totalMoves--;
                continue;
            }

            int row;
            try {
                row = Integer.parseInt(rowInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                players.addFirst(currentPlayer);
                continue;
            }

            System.out.println("Enter Column number or type 'undo': ");
            String colInput = scanner.next();

            // Check for undo during column input
            if (colInput.equalsIgnoreCase("undo")) {
                players.addFirst(currentPlayer); 
                boolean undoSuccess = undoMove();
                if (undoSuccess) totalMoves--;
                continue;
            }

            int col;
            try {
                col = Integer.parseInt(colInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                players.addFirst(currentPlayer);
                continue;
            }

            // Attempt to place the piece
            boolean isMoveValid = board.addPiece(row, col, currentPlayer.getPieceType());
            
            if (!isMoveValid) {
                System.out.println("Invalid move! Please try again.");
                players.addFirst(currentPlayer);
                continue;
            }

            // Save valid move to history
            movesHistory.push(new Move(row, col, currentPlayer));
            totalMoves++;

            // Check for win
            boolean isWinner = winningStrategy.checkWinner(board, row, col, currentPlayer.getPieceType());

            if (isWinner) {
                board.printBoard();
                System.out.println(currentPlayer.getName() + " wins the game!");
                gameState = GameState.WON;
            } else if (totalMoves == maxMoves) {
                board.printBoard();
                System.out.println("The game is a draw!");
                gameState = GameState.DRAW;
            }

            players.addLast(currentPlayer);
        }
    }

    // Handles the complete undo process
    private boolean undoMove() {
        if (movesHistory.isEmpty()) {
            System.out.println("No moves to undo! The board is empty.");
            return false;
        }

        Move lastMove = movesHistory.pop();

        // 1. Clear the board cell
        board.removePiece(lastMove.getRow(), lastMove.getCol());

        // 2. Revert the winning strategy counters
        winningStrategy.undoMove(board, lastMove.getRow(), lastMove.getCol(), lastMove.getPlayer().getPieceType());

        // 3. Revert the turn order
        players.addFirst(players.pollLast());

        System.out.println("Undo successful! Reverted " + lastMove.getPlayer().getName() + "'s move.");
        return true;
    }
}
