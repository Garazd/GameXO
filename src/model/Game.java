package model;

public class Game {

    private static final String DEFAULT_GAME_NAME = "XO";

    private static Player[] players;
    private static Board board;
    private static String gameName;

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

    public static Player[] getPlayers() {
        return players;
    }

    public static Board getBoard() {
        return board;
    }

    public static String getGameName() {
        return gameName;
    }
}