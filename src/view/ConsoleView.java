package view;

import controller.CurrentMoveController;
import controller.MoveController;
import controller.WinnerController;
import model.*;
import model.exeptions.AlreadyOccupiedException;
import model.exeptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final Character separator = new Character('-');
    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();
    //private final ConsoleCoordinateReader coordinateReader = new ConsoleCoordinateReader();

    private final int SEPARATOR_LENGTH = 11;
    private final int INDENT_LENGTH = 50;
    private final int HALF_INDENT_LENGTH = INDENT_LENGTH / 2;
    private final String HYPHEN_VIEW = " -- ";

    public void show(final Game game) {
        final Player player1 = game.getPlayers()[0];
        final Player player2 = game.getPlayers()[1];

        System.out.format("%" + INDENT_LENGTH + "s\n", "Game name:" + game.getGameName());

        System.out.format("%"
                        + (HALF_INDENT_LENGTH
                        - SEPARATOR_LENGTH
                        + player2.getName().length()
                        + HYPHEN_VIEW.length()
                        + player2.getFigure().toString().length())
                        + "s %"
                        + (HALF_INDENT_LENGTH
                        + SEPARATOR_LENGTH
                        + HALF_INDENT_LENGTH
                        - player2.getName().length()
                        - HYPHEN_VIEW.length()
                        - player2.getFigure().toString().length())
                        + "s",
                player1.getName() + HYPHEN_VIEW + player1.getFigure(),
                player2.getName() + HYPHEN_VIEW + player2.getFigure() + "\n");

        final Board board = game.getBoard();
        for (int y = 0; y < board.getSize(); y++) {
            if (y != 0)
                System.out.format("%" + INDENT_LENGTH + "s\n", generateSeparator(separator, SEPARATOR_LENGTH));
            System.out.format("%" + INDENT_LENGTH + "s\n", generateLine(board, y));
        }
    }

    public boolean move(final Game game) {
        final Board board = game.getBoard();
        final Figure winner = winnerController.getWinner(board);
        if (winner != null) {
            System.out.format("Winner is: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(board);
        if (currentFigure == null) {
            System.out.println("No winner and no moves left!");
            return false;
        }
        System.out.format("Please enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(board, point, currentFigure);
        } catch (final InvalidPointException | AlreadyOccupiedException e) {
            System.out.println("Point is invalid!");
        }
        return true;
    }

    public int askCoordinate(String coordinateName) {
        System.out.format("Please input %s:", coordinateName);
        try (final Scanner in = new Scanner(System.in)){
            return in.nextInt();
        } catch (final InputMismatchException e) {
            System.out.println("Enter the correct coordinate!");
            return askCoordinate(coordinateName);
        }
    }

    private Point askPoint() {
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    protected String generateLine(final Board board, final int y) {
        String resultLine = "";
        try {
            for (int x = 0; x < board.getSize(); x++) {
                Figure figure = null;
                try {
                    figure = board.getFigure(new Point(x, y));
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                }
                String leftFigureWall = (x != 0 ? "|" : "");
                String figureSymbol = String.format("%s", figure != null ? figure : " ");
                String figureCell = String.format("%s%2s ", leftFigureWall, figureSymbol);
                resultLine = resultLine.concat(figureCell);
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return resultLine;
    }

    private String generateSeparator(final Character piece, final int count){
        String result = "";
        for (int i = 0; i < count; i++){
            result = result + piece;
        }
        return result;
    }
}