package model;

public class Game {

    private static final String DEFAULT_GAME_NAME = "XO";

    private Player[] players;
    private final Board board;
    private final String gameName;

    public Game(final Player[] players,
                final Board board,
                final String gameName) {
        this.players = players;
        this.board = board;

        if (gameName == null || gameName.isEmpty()) {
            this.gameName = DEFAULT_GAME_NAME;
        } else {
            this.gameName = gameName;
        }
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