package view;

import controller.GameController;
import model.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    protected final GameController gameController;

    private final static Scanner scanner = new Scanner(System.in);

    public ConsoleView(final GameController gameController) {
        assert gameController != null;
        this.gameController = gameController;
    }

    public void start() {
        System.out.println("Pleas input coordinates: ");
        int x = getCoordinate("X");
        int y = getCoordinate("Y");
    }

    public void showGameName() {
        System.out.println(gameController.getGameName());
    }

    public void showPlayersName() {
        System.out.println(gameController.getPlayers());
    }

    public void showBoard() {
        for (int i = 0; i < 3; i++) {
            showBoardLine(i);
        }
    }

    private void showPlayers() {
        for (Player player : gameController.getPlayers()){
            System.out.println(player.getName());
        }
    }

    private void showBoardLine(final int row) {
        for (int i = 0; i < row; i++) {
            System.out.print(gameController.getBoard().getFigures(row, i));
        }
    }

    private int getCoordinate(final String coordinateName) {
        int counter = 0;
        do {
            System.out.print(String.format("Input the coordinate %s: ", coordinateName));
            try {
                final Scanner in = new Scanner(System.in);
                return in.nextInt();
            } catch (final InputMismatchException e) {
                System.out.println("Coordinate is incorrect");
                counter += 1;
            }
        } while (counter < 3);
        return  -1;
    }
}