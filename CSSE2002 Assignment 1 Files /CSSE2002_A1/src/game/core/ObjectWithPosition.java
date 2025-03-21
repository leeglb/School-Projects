package src.game.core;


public abstract class ObjectWithPosition implements SpaceObject, src.game.ui.Tickable {
    protected int x; //protected means accessible by classes within or extended.
    protected int y;

    public ObjectWithPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public int getY() {
        return y;
    }

}
