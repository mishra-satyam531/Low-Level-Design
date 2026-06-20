package ticTacToe;

import java.util.Deque;
import java.util.LinkedList;

import ticTacToe.controllers.GameController;
import ticTacToe.enums.PieceType;
import ticTacToe.models.Board;
import ticTacToe.models.Player;
import ticTacToe.strategy.OrderOneWinningStrategy;

public class Main {
    public static void main(String[] args) {
        int boardSize = 3;

        Board board = new Board(boardSize);
        OrderOneWinningStrategy winningStrategy = new OrderOneWinningStrategy(boardSize);

        Deque<Player> players = new LinkedList<>();
        players.add(new Player("Player 1", PieceType.X));
        players.add(new Player("Player 2", PieceType.O));

        GameController game = new GameController(board, players, winningStrategy);
        System.out.println("Tic-Tac-Toe Game is Starting...\n");
        game.startGame();
    }
}
