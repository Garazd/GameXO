package controller;

import model.Board;
import model.Figure;
import model.Point;
import model.exeptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(final Board board) {
        int countFigure = 0;
        for (int x = 0; x < board.getSize(); x++) {
            countFigure += countFiguresInTheRow(board, x);
        }

        if (countFigure == board.getSize() * board.getSize())
            return null;

        if (countFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInTheRow(final Board board, final int row) {
        int countFigure = 0;
        for (int x = 0; x < board.getSize(); x++) {
            try {
                if (board.getFigure(new Point(x, row)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }
}