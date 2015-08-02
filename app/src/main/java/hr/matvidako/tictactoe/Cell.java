package hr.matvidako.tictactoe;

import android.animation.Animator;
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

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(this, View.ALPHA, 1, 0);
        fadeOut.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }
            @Override
            public void onAnimationEnd(Animator animation) {
                setImageResource(0);
            }
            @Override
            public void onAnimationCancel(Animator animation) {
            }
            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        fadeOut.start();
    }

    public boolean isEmpty() {
        return occupiedBy == Player.NONE;
    }

}
