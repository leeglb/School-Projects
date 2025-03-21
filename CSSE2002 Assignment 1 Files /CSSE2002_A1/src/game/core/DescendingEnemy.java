package src.game.core;

public abstract class DescendingEnemy extends ObjectWithPosition {


    public DescendingEnemy(int x, int y) {
        super(x, y);
    }

    public void tick(int tick) {
        if (tick % 10 == 0) {
            y--;
        }
    }
}
