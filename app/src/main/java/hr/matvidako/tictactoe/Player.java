package hr.matvidako.tictactoe;

enum Player {
    NONE(0),
    CIRCLE(R.drawable.circle),
    CROSS(R.drawable.cross);

    public final int iconDrawable;

    Player(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }
}
