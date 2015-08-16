import model.Board;
import model.Figure;
import model.Game;
import model.Player;
import model.exeptions.InvalidBoardSizeException;
import view.ConsoleView;

import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {

        final int FIELD_SIZE = 3;

        final Player[] players = new Player[2];
        players[0] = new Player("Vitaliy", Figure.X);
        players[1] = new Player("Oleg", Figure.O);

        Board board = null;
        try {
            board = new Board(FIELD_SIZE);
        } catch (InvalidBoardSizeException e) {
            e.printStackTrace();
        }
        final Game gameXO = new Game(players, board, "XO");
        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(gameXO);
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
    }

    static String playerNameInput(final int count) {
        Scanner sc = new Scanner(System.in);
        System.out.format("Enter Player %s  name: ", count);
        String name = sc.nextLine();
        return name;
    }
}