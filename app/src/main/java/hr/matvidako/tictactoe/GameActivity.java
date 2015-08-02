package hr.matvidako.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends Activity {

    Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        board = new Board((GridLayout) findViewById(R.id.grid), new Rules());
        ButterKnife.bind(this);
    }

    @OnClick(R.id.clear)
    public void clearGrid() {
        board.clear();
    }

}
