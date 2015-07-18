package controller;

import model.Board;
import model.Figure;
import model.exeptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Board board) {
        try {
            for(int i = 0; i < 3; i++)
                if (check(board, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                    return board.getFigure(new Point(i, 0));

            for(int i = 0; i < 3; i++)
                if (check(board, new Point(0, i), p -> new Point(p.x + 1, p.y)))
                    return board.getFigure(new Point(0, i));

            for(int i = 0; i < 3; i++)
                if (check(board, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                    return board.getFigure(new Point(0, 0));

            for(int i = 0; i < 3; i++)
                if (check(board, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                    return board.getFigure(new Point(1, 1));
        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean check(final Board board,
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