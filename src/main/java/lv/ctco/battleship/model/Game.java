package lv.ctco.battleship.model;

import java.io.Serializable;

public class Game implements Serializable {
    private static final long serialVersionUID = 1;

    private Player player1;
    private Player player2;
    private boolean player1move;

    public Player getCurrentPlayer() {
        return player1move ? player1 : player2;
    }

    public Player getOppositePlayer() {
        return player1move ? player2 : player1;
    }

    public void fire(String address) {
        Player current = getCurrentPlayer();
        Player opposite = getOppositePlayer();

        CellContent firedCell = opposite.getMyField().get(address);

        if (firedCell == CellContent.SHIP) {
            opposite.getMyField().set(address, CellContent.HIT);
            current.getOppositeField().set(address, CellContent.HIT);
        } else {
            player1move = !player1move;
        }

        if (firedCell == CellContent.EMPTY) {
            opposite.getMyField().set(address, CellContent.MISS);
            current.getOppositeField().set(address, CellContent.MISS);
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public boolean isComplete() {
        return player1 != null && player2 != null;
    }

    public boolean isStarted() {
        return player1 != null
                && player2 != null
                && player1.isPlacementComplete()
                && player2.isPlacementComplete();
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }
}
