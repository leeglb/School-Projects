package src.game.core;

import src.game.ui.ObjectGraphic;

public interface SpaceObject extends src.game.ui.Tickable {

    int getX();
    int getY();
    ObjectGraphic render();
    //need to link bullet and space objects render
}
