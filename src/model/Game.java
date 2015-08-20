package model;

public class Game {

    private final Player[] players;
    private final Board board;
    private final String gameName;

    public Game(final Player[] players,
                final Board board,
                final String gameName) {
        this.players = players;
        this.board = board;
        this.gameName = gameName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public String getGameName() {
        return gameName;
    }
}