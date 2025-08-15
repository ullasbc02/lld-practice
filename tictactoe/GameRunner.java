import games.*;
import java.util.*;

public class GameRunner {
    public static void main(String[] args) {
        Board board = new Board(3);
        Player player1 = new Player("Alice", 'X');
        Player player2 = new Player("Bob", 'O');
        List<Player> players = Arrays.asList(player1, player2);

        GameManagement game = new GameManagement(board, players);

        // Simulated moves
        game.myTurn(0, 0);
        game.myTurn(1, 1);
        game.myTurn(0, 1);
        game.myTurn(1, 0);
        game.myTurn(0, 2); // Alice should win here
    }
}
