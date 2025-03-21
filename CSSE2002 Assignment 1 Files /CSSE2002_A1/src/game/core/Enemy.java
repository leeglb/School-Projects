package src.game.core;

import src.game.ui.ObjectGraphic;

public class Enemy extends DescendingEnemy{

    public Enemy(int x, int y) {
        super(x, y);
    }

    public ObjectGraphic render() {
        return new ObjectGraphic("👾", "assets/enemy.png");
    }
}
