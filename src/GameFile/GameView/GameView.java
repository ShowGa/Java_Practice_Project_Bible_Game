package GameFile.GameView;

import GameFile.Sprite. *;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class GameView {
    protected ArrayList<Sprite> elements;
    protected Door door;
    protected ImageIcon img;

    public void drawView(Graphics g) {
        img.paintIcon(null, g, 0, 0);
        for (Sprite s : elements) {
            // draw all the sprite
            s.draw(g);
        }
    }

    public Door getDoor() {
        return this.door;
    }

    public ArrayList<Sprite> getAllElements() {
        return this.elements;
    }
}
