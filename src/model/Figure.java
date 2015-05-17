package model;

public enum Figure {

    X("X"),O("O");

    private final String figure;

    Figure(final String figure) {
        assert figure != null;

        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }
}