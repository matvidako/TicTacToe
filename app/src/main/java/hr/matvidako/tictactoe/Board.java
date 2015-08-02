package hr.matvidako.tictactoe;

import android.support.v7.widget.GridLayout;
import android.view.View;

import java.util.Iterator;

public class Board implements View.OnClickListener {

    private Rules rules;
    private Player currentPlayer;

    private int size = 3;
    private int cellCount = size * size;
    private int moveCount = 0;
    private Cell[][] cells = new Cell[size][size];

    public Board(GridLayout gridLayout, Rules rules) {
        this.rules = rules;
        this.currentPlayer = rules.getStartingPlayer();
        this.cellCount = gridLayout.getChildCount();

        int childIndex = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Cell cell = (Cell) gridLayout.getChildAt(childIndex);
                cells[row][col] = cell;
                cell.setOnClickListener(this);
                childIndex++;
            }
        }
    }

    public void clear() {
        moveCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                cells[row][col].clear();
            }
        }
    }

    public boolean isFull() {
        return moveCount >= cellCount;
    }

    @Override
    public void onClick(View v) {
        Cell cell = (Cell) v;
        if (cell.isEmpty()) {
            cell.occupy(currentPlayer);
            moveCount++;
            currentPlayer = rules.getNextPlayer(currentPlayer);
        }
        if (rules.getWinner(this) != Player.NONE) {
            clear();
        } else if (isFull()){
            clear();
        }
    }

}
