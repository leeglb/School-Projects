package src.game.core;

import src.game.ui.ObjectGraphic;

public class Asteroid extends DescendingEnemy {

    public Asteroid(int x, int y) {
        super(x, y);
    }

    @Override
    public ObjectGraphic render() {
        return new ObjectGraphic("🌑", "assets/asteroid.png");
    }
}
