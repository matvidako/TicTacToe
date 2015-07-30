package hr.matvidako.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;

public class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Grid((GridLayout) findViewById(R.id.grid), new Game());
    }

}
