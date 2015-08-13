package view;

import controller.CurrentMoveController;
import controller.MoveController;
import controller.WinnerController;
import model.Board;
import model.Figure;
import model.Game;
import model.Player;
import model.exeptions.AlreadyOccupiedException;
import model.exeptions.InvalidPointException;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    private static final String LINE_CHARACTER = "~";
    private static final int LINE_SIZE = 11;

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getGameName());
        final Board board = game.getBoard();
        for (int i = 0; i < board.getSize(); i++) {
            if (i != 0)
                printSeparator();
            showLine(board, i);
        }
    }

    public boolean move(final Game game) {
        final Board board = game.getBoard();
        final Figure winner = winnerController.getWinner(board);
        final Figure currentFigure = currentMoveController.currentMove(board);
        final Point point = askPoint();
        if (winner != null) {
            System.out.println("Winner is: " + winner);
            return false;
        }
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        try {
            moveController.applyFigure(board, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(getCoordinate("X"), getCoordinate("Y"));
    }

    public void showGameName() {
        System.out.println(Game.getGameName());
    }

    public void showPlayersName() {
        System.out.println(Game.getPlayers());
    }

    public void showPlayers() {
        for (Player player : Game.getPlayers()){
            System.out.println(player.getName());
        }
    }

    protected void showLine (final Board board, final int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(LINE_CHARACTER);
        }
        System.out.println();
    }

    private void showBoardLine(final int row) {
        for (int i = 0; i < row; i++) {
            try {
                System.out.print(Game.getBoard().getFigure(new Point()));
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
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

    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }
}