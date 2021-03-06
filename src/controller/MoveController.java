package controller;

import model.Board;
import model.Figure;
import model.Point;
import model.exeptions.AlreadyOccupiedException;
import model.exeptions.InvalidPointException;

public class MoveController {

    public void applyFigure(final Board board,
                            final Point point,
                            final Figure figure) throws InvalidPointException,
                                                        AlreadyOccupiedException {
        if (board.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        board.setFigure(point, figure);
    }
}