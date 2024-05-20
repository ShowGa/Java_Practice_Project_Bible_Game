package GameFile.GameView;

import GameFile.Sprite.TenComandmentSprite.TenComandment;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TenComandmentsView extends GameView{
    private TenComandment stone;

    public TenComandmentsView() {
        img = new ImageIcon("mountain.jpg");
        elements = new ArrayList<>();
        stone = new TenComandment(5, 5);

        elements.add(stone);
    }

    public TenComandment getStone() {
        return stone;
    }
}
