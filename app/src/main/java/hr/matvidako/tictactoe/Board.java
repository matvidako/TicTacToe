package hr.matvidako.tictactoe;

import android.support.v7.widget.GridLayout;
import android.view.View;

import java.util.Iterator;
import java.util.List;

public class Board implements View.OnClickListener, Iterable<Cell> {

    Game game;
    GridLayout gridLayout;

    public Board(GridLayout gridLayout, Game game) {
        this.game = game;
        this.gridLayout = gridLayout;

        for(Cell cell : this) {
            cell.setOnClickListener(this);
        }
    }

    public void clear() {
        for(Cell cell : this) {
            cell.clear();
        }
    }

    @Override
    public void onClick(View v) {
        Cell cell = (Cell) v;
        if(cell.isEmpty()) {
            cell.occupy(game.getCurrentPlayer());
            game.onTurnEnd();
        }
        if(game.isGameOver(this)) {
            clear();
        }
    }

    @Override
    public Iterator<Cell> iterator() {
        return new CellIterator();
    }

    private class CellIterator implements Iterator<Cell> {

        private int currentIndex = 0;
        private int size;

        public CellIterator() {
            size = gridLayout.getChildCount();
        }

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Cell next() {
            Cell cell = (Cell) gridLayout.getChildAt(currentIndex);
            currentIndex++;
            return cell;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("");
        }
    }

}
