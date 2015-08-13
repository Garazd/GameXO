import model.Board;
import model.Figure;
import model.Game;
import model.Player;
import view.ConsoleView;

public class Main {

    public static void main(final String[] args) {

        final Board board = new Board();
        final Player[] players = new Player[2];
        players[0] = new Player("Vitaliy", Figure.X);
        players[1] = new Player("Oleg", Figure.O);

        final Game gameXO = new Game(players, board, "XO");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.showBoard(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.showBoard(gameXO);
        }
    }
}
