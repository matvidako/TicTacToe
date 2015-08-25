package hr.matvidako.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends Activity implements Board.OnGameOverListener {

    Board board;
    @Bind(R.id.scoreCircle)
    TextSwitcher scoreCircleTextSwitcher;
    @Bind(R.id.scoreCross)
    TextSwitcher scoreCrossTextSwitcher;
    LayoutInflater layoutInflater;

    int scoreCircle = 0;
    int scoreCross = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        board = new Board((GridLayout) findViewById(R.id.grid), new Rules(), this);
        ButterKnife.bind(this);
        layoutInflater = LayoutInflater.from(this);

        Animation animIn = AnimationUtils.loadAnimation(this, R.anim.score_in);
        Animation animOut = AnimationUtils.loadAnimation(this, R.anim.score_out);
        scoreCircleTextSwitcher.setFactory(new ScoreViewFactory());
        scoreCircleTextSwitcher.setInAnimation(animIn);
        scoreCircleTextSwitcher.setOutAnimation(animOut);
        scoreCrossTextSwitcher.setFactory(new ScoreViewFactory());
        scoreCrossTextSwitcher.setInAnimation(animIn);
        scoreCrossTextSwitcher.setOutAnimation(animOut);
        resetScore();
    }

    private void resetScore() {
        scoreCircle = scoreCross = 0;
        scoreCircleTextSwitcher.setCurrentText(scoreCircle + "");
        scoreCrossTextSwitcher.setCurrentText(scoreCross + "");
    }

    @Override
    public void onGameOver(Player winner) {
        if (winner == Player.CIRCLE) {
            scoreCircle++;
            scoreCircleTextSwitcher.setText(scoreCircle + "");
        } else if (winner == Player.CROSS) {
            scoreCross++;
            scoreCrossTextSwitcher.setText(scoreCross + "");
        }
        board.clear();
    }

    private class ScoreViewFactory implements ViewSwitcher.ViewFactory {
        @Override
        public TextView makeView() {
            return (TextView) layoutInflater.inflate(R.layout.text_view_score, null, false);
        }
    }

}
