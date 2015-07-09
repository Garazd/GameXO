package model;

import model.exeptions.AlreadyOccupiedExemption;
import model.exeptions.InvalidPointExeption;

import java.awt.*;

public class Board {

    private static final int SIZE_FIELD = 3;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = SIZE_FIELD;

    private final Figure[][] figures = new Figure[SIZE_FIELD][SIZE_FIELD];

    public int getSize(){
        return SIZE_FIELD;
    }

    public Figure getFigure(final Point point) throws InvalidPointExeption {
        if (checkPoint(point)) {
            throw new InvalidPointExeption();
        }
        return figures [point.x][point.y];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointExeption,
                                                                         AlreadyOccupiedExemption {
        if (checkPoint(point)) {
            throw new InvalidPointExeption();
        }

        if (figures [point.x][point.y] != null) {
            throw new AlreadyOccupiedExemption();
        }
        figures [point.x][point.y] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x) && checkCoordinate(point.y);
    }

    private boolean checkCoordinate(final int coordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < MAX_COORDINATE;
    }
}