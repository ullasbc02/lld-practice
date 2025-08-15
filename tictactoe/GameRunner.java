import java.util.*;

import games.*;



class GameRunner {
    public static void main(String[] args) {
        // Initialize the game
        Board board = new Board(3);
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');
        List<Player> players = Arrays.asList(player1, player2);
        GameManagement game = new GameManagement(board, players, players.size());

        // Simulate some moves
        game.myTurn(player1, 0, 0);
        game.myTurn(player2, 1, 1);
        game.myTurn(player1, 0, 1);
        game.myTurn(player2, 1, 0);
        game.myTurn(player1, 0, 2);
        game.myTurn(player2, 2, 2);
        board.display();
        game.checkWinner(player2.getSymbol());
        game.checkWinner(player1.getSymbol());

    }
}