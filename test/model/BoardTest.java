package model;

import org.junit.Test;

import java.awt.*;

import static junit.framework.Assert.assertEquals;

public class BoardTest {

    @Test
    public void testGetSize() {
        final Board board = new Board();

        assertEquals(3, board.getSize());
    }

    @Test
    public void testSetFigure() {
        final Board board = new Board();
        final Point inputPoint = new Point(0,0);
        final Figure inputFigure = Figure.O;

        board.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = board.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }
}