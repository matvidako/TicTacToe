package hr.matvidako.tictactoe;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindDrawable;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Cell extends ImageView {

    @BindDrawable(R.drawable.circle)
    Drawable iconCircle;

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

    @OnClick
    public void onClick()
    {
        setImageDrawable(iconCircle);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(this, View.ALPHA, 0, 1);
        fadeIn.start();
    }

}
