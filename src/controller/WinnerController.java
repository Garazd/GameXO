package controller;

import model.Board;
import model.Figure;
import model.Point;
import model.exeptions.InvalidPointException;

public class WinnerController {

    public static Figure getWinner(final Board board) {
        try {
            for(int i = 0; i < 3; i++)
                if (check(board, new Point(i, 0), p -> new Point(p.getX(), p.getY() + 1)))
                    return board.getFigure(new Point(i, 0));

            for(int i = 0; i < 3; i++)
                if (check(board, new Point(0, i), p -> new Point(p.getX() + 1, p.getY())))
                    return board.getFigure(new Point(0, i));

            for(int i = 0; i < 3; i++)
                if (check(board, new Point(0, 0), p -> new Point(p.getX() + 1, p.getY() + 1)))
                    return board.getFigure(new Point(0, 0));

            for(int i = 0; i < 3; i++)
                if (check(board, new Point(0, 2), p -> new Point(p.getX() + 1, p.getY() - 1)))
                    return board.getFigure(new Point(1, 1));
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean check(final Board board,
                                 final Point currentPoint,
                                 final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = board.getFigure(currentPoint);

            if (currentFigure == null) return false;

            nextFigure = board.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure) return false;

        return check(board, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {

        Point next(final Point point);
    }
}