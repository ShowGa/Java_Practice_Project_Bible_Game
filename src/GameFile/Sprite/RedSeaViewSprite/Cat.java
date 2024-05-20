package GameFile.Sprite.RedSeaViewSprite;

import GameFile.Sprite.Sprite;

import javax.swing.*;

public class Cat extends Sprite {
    public Cat(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("cat.png");
    }

    @Override
    public String overlap(int x, int y) {
        return "";
    }
}
