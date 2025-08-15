package games;
import java.util.List;

public class GameManagement {
    private Board board;
    private List<Player> players;
    private boolean gameStarted;
    private int currentPlayerIndex;

    public GameManagement(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
        this.gameStarted = true;
    }

    public void myTurn(int row, int col) {
        if (!gameStarted) {
            System.out.println("Game has ended.");
            return;
        }

        Player currentPlayer = players.get(currentPlayerIndex);

        boolean moveSuccessful = board.makeMove(currentPlayer, row, col);
        if (!moveSuccessful) {
            return; // Don't switch turn if move is invalid
        }

        board.display();

        if (board.checkWinner(currentPlayer.getSymbol())) {
            System.out.println("Player " + currentPlayer.getName() + " wins!");
            gameStarted = false;
            return;
        }

        switchPlayer();
    }

    private void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
