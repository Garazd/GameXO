package controller;

import model.Board;
import model.Figure;
import model.exeptions.AlreadyOccupiedException;
import model.exeptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class CurrentMoveControllerTest {

    @Test
    public void testCurrentMoveWhenNextMoveIsO() throws AlreadyOccupiedException, InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Board board = new Board();
            board.setFigure(new Point(i, 0), Figure.X);
            board.setFigure(new Point(i, 1), Figure.O);
            board.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.O, currentMoveController.currentMove(board));
        }
    }

    @Test
    public void testCurrentMoveWhenNextMoveIsX() throws AlreadyOccupiedException, InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        for (int i = 0; i < 3; i++) {
            final Board board = new Board();
            board.setFigure(new Point(i, 1), Figure.O);
            board.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, currentMoveController.currentMove(board));
        }
    }

    @Test
    public void testCurrentMoveWhenNoNextMove() throws AlreadyOccupiedException, InvalidPointException {
        final CurrentMoveController currentMoveController = new CurrentMoveController();
        final Board board = new Board();
        board.setFigure(new Point(0, 0), Figure.O);
        board.setFigure(new Point(0, 1), Figure.X);
        board.setFigure(new Point(0, 2), Figure.O);
        board.setFigure(new Point(1, 0), Figure.O);
        board.setFigure(new Point(1, 1), Figure.X);
        board.setFigure(new Point(1, 2), Figure.O);
        board.setFigure(new Point(2, 0), Figure.O);
        board.setFigure(new Point(2, 1), Figure.X);
        board.setFigure(new Point(2, 2), Figure.O);
        assertNull(currentMoveController.currentMove(board));
    }
}