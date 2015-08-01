package hr.matvidako.tictactoe;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import butterknife.ButterKnife;

public class Cell extends ImageView {

    private Player occupiedBy = Player.NONE;

    public Cell(Context context) {
        this(context, null, 0);
    }

    public Cell(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Cell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this);
    }

    public void occupy(Player player) {
        occupiedBy = player;
        setImageResource(player.iconDrawable);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(this, View.ALPHA, 0, 1);
        fadeIn.start();
    }

    public Player getOccupiedBy() {
        return occupiedBy;
    }

    public void clear() {
        occupiedBy = Player.NONE;
        setImageResource(0);
    }

    public boolean isEmpty() {
        return occupiedBy == Player.NONE;
    }
}
