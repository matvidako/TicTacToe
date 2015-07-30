package hr.matvidako.tictactoe;

enum Player {
    CIRCLE(R.drawable.circle),
    CROSS(R.drawable.cross);

    public final int iconDrawable;

    Player(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }
}
