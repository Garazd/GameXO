package controller;

import model.Board;
import model.Figure;
import model.Point;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 0), Figure.X);
            board.setFigure(new Point(i, 1), Figure.X);
            board.setFigure(new Point(i, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 0), Figure.X);
            board.setFigure(new Point(i, 1), Figure.X);
            board.setFigure(new Point(i, 2), Figure.O);
            assertNull(winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(0, i), Figure.X);
            board.setFigure(new Point(1, i), Figure.X);
            board.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(0, i), Figure.X);
            board.setFigure(new Point(1, i), Figure.X);
            board.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(board));
        }
    }

    @Test
    public void testGetWinnerWhenWinnerDiagonal1() throws Exception {
        final WinnerController winnerController = new WinnerController();
            final Board board = new Board(3);
            board.setFigure(new Point(0, 0), Figure.X);
            board.setFigure(new Point(1, 1), Figure.X);
            board.setFigure(new Point(2, 2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(board));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiagonal1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Board board = new Board(3);
        board.setFigure(new Point(0, 0), Figure.X);
        board.setFigure(new Point(1, 1), Figure.X);
        board.setFigure(new Point(2, 2), Figure.O);
        assertNull(winnerController.getWinner(board));
    }

    @Test
    public void testGetWinnerWhenWinnerDiagonal2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Board board = new Board(3);
        board.setFigure(new Point(0, 2), Figure.X);
        board.setFigure(new Point(1, 1), Figure.X);
        board.setFigure(new Point(2, 0), Figure.X);
        assertEquals(Figure.X, winnerController.getWinner(board));
    }

    @Test
    public void testGetWinnerWhenNoWinnerDiagonal2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Board board = new Board(3);
        board.setFigure(new Point(0, 2), Figure.X);
        board.setFigure(new Point(1, 1), Figure.X);
        board.setFigure(new Point(2, 0), Figure.O);
        assertNull(winnerController.getWinner(board));
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        for (int i = 0; i < 3; i++) {
            final Board board = new Board(3);
            board.setFigure(new Point(i, 0), Figure.O);
            board.setFigure(new Point(i, 1), Figure.X);
            board.setFigure(new Point(i, 2), Figure.X);
            assertNull(winnerController.getWinner(board));
        }
    }

    // TODO
}