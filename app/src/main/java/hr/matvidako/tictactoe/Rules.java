package hr.matvidako.tictactoe;

public class Rules {

    public Player getStartingPlayer() {
        return Player.CIRCLE;
    }

    public Player getNextPlayer(Player currentPlayer) {
        if(currentPlayer == Player.CIRCLE) {
            return Player.CROSS;
        } else {
            return Player.CIRCLE;
        }
    }

    public Player getWinner(Board board) {
        return Player.NONE;
    }

}
