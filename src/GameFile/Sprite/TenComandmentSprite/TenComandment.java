package GameFile.Sprite.TenComandmentSprite;

import GameFile.Sprite.Sprite;

import javax.swing.*;

public class TenComandment extends Sprite {
    public TenComandment(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("stone.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
