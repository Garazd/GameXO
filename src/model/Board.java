package model;

import model.exeptions.InvalidBoardSizeException;
import model.exeptions.InvalidPointException;

public class Board {

    private static final int MIN_SIZE = 3;
    private static final int MIN_COORDINATE = 0;

    private final int boardSize;
    private final Figure[][] board;

    public Board(final int boardSize) throws InvalidBoardSizeException {
        if (boardSize < MIN_SIZE) {
            throw new InvalidBoardSizeException();
        } else {
            this.boardSize = boardSize;
            board = new Figure[boardSize][boardSize];
        }
    }

    public int getSize(){
        return boardSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return board [point.getX()][point.getY()];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        board [point.getX()][point.getY()] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.getX(), board.length) && checkCoordinate(point.getY(), board[point.getX()].length);
    }

    private boolean checkCoordinate(final int coordinate, final int MAX_COORDINATE) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}