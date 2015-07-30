package hr.matvidako.tictactoe;

import android.support.v7.widget.GridLayout;
import android.view.View;

public class Grid implements View.OnClickListener {

    Game game;

    public Grid(GridLayout gridLayout, Game game) {
        this.game = game;

        for(int i = 0; i < gridLayout.getChildCount(); i++) {
            gridLayout.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Cell cell = (Cell) v;
        cell.setIcon(game.getCurrentPlayer().iconDrawable);
        game.onTurnEnd();
    }

}
