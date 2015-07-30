package hr.matvidako.tictactoe;

public class Game {

    private Player currentPlayer = Player.CIRCLE;

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void onTurnEnd() {
        if(currentPlayer == Player.CIRCLE) {
            currentPlayer = Player.CROSS;
        } else {
            currentPlayer = Player.CIRCLE;
        }
    }

}
