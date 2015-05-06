import controller.GameController;
import model.Board;
import model.Player;
import view.ConsoleView;

public class Main {

    public static void main(final String[] args) {

        final Board board = new Board();

        final GameController game = new GameController("string for the name of the game", new Player("figure", "player"), board);
        //final TwoConsoleView twoConsoleView = new TwoConsoleView(game);
        final ConsoleView consoleView = new ConsoleView(game);
        //startGame(twoConsoleView);
    }

    private static void startGame(final ConsoleView twoConsoleView) {
        twoConsoleView.showGameName();
        twoConsoleView.showPlayersName();
    }
}