package hr.matvidako.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameActivity extends Activity {

    Grid grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = new Grid((GridLayout) findViewById(R.id.grid), new Game());
        ButterKnife.bind(this);
    }

    @OnClick(R.id.clear)
    public void clearGrid() {
        grid.clear();
    }

}
