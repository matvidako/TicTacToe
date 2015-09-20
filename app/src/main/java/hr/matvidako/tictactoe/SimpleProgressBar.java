package hr.matvidako.tictactoe;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;

public class SimpleProgressBar extends View {

    private static final int MAX_CLIP_DRAWABLE_LEVEL = 10000;
    ClipDrawable clipDrawable;
    int progress = 0;

    public SimpleProgressBar(Context context) {
        this(context, null, 0);
    }

    public SimpleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SimpleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayerDrawable layerDrawable = (LayerDrawable) context.getResources().getDrawable(R.drawable.progress);
        clipDrawable = (ClipDrawable) layerDrawable.getDrawable(1);
        setBackgroundDrawable(layerDrawable);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        clipDrawable.setLevel(progress);
    }

    public int getProgress() {
        return progress;
    }

    public void startProgressAnimation(int duration) {
        ObjectAnimator progressAnimator;
        progressAnimator = ObjectAnimator.ofInt(this, "progress", MAX_CLIP_DRAWABLE_LEVEL);
        progressAnimator.setDuration(duration);
        progressAnimator.start();
    }

}
