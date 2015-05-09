import controller.GameController;
import model.Board;
import model.Player;
import view.ConsoleView;

public class Main {

    public static void main(final String[] args) {

        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Vitaliy", "figureX");
        players[1] = new Player("Oleg", "figureO");

        final GameController game = new GameController("string for the name of the game", players,  board);
        final ConsoleView consoleView = new ConsoleView(game);
    }

    private static void startGame(final ConsoleView twoConsoleView) {
        twoConsoleView.showGameName();
        twoConsoleView.showPlayersName();
    }
}