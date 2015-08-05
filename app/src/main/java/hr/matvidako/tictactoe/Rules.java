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
        for(int i = 0; i < board.size; i++) {
            Player playerForRowCheck = board.getPlayerAt(i, 0);
            if(playerForRowCheck != Player.NONE && playerForRowCheck == board.getPlayerAt(i, 1) && playerForRowCheck == board.getPlayerAt(i, 2)) {
                return playerForRowCheck;
            }
            Player playerForColCheck = board.getPlayerAt(0, i);
            if(playerForColCheck != Player.NONE && playerForColCheck == board.getPlayerAt(1, i) && playerForColCheck == board.getPlayerAt(2, i)) {
                return playerForColCheck;
            }
        }

        Player player = board.getPlayerAt(0, 0);
        if(player != Player.NONE && player == board.getPlayerAt(1, 1) && player == board.getPlayerAt(2, 2)) {
            return player;
        }

        player = board.getPlayerAt(0, 2);
        if(player != Player.NONE && player == board.getPlayerAt(1, 1) && player == board.getPlayerAt(2, 0)) {
            return player;
        }

        return Player.NONE;
    }

}
