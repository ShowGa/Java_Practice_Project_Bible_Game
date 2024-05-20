package GameFile.GameView;

import GameFile.Sprite.Door;
import GameFile.Sprite.RedSeaViewSprite.Anubis;
import GameFile.Sprite.RedSeaViewSprite.Cat;
import GameFile.Sprite.RedSeaViewSprite.Pharoah;

import javax.swing.*;
import java.util.ArrayList;

public class RedSeaGameView extends GameView{
    public ArrayList<Cat> getCats() {
        return cats;
    }

    public ArrayList<Anubis> getAnubis() {
        return anubis;
    }

    public ArrayList<Pharoah> getPharoah() {
        return pharoah;
    }

    private ArrayList<Cat> cats = new ArrayList<>();
    private ArrayList<Anubis> anubis = new ArrayList<>();
    private ArrayList<Pharoah> pharoah = new ArrayList<>();

    public RedSeaGameView() {

        img = new ImageIcon("sea.jpg");
        elements = new ArrayList<>();
        door = new Door(10, 10);

        cats.add(new Cat(6, 3));
        cats.add(new Cat(6, 4));
        cats.add(new Cat(6, 5));
        cats.add(new Cat(8, 3));
        cats.add(new Cat(1, 3));
        cats.add(new Cat(6, 9));
        cats.add(new Cat(2, 7));
        cats.add(new Cat(2, 5));

        pharoah.add(new Pharoah(5, 4));
        pharoah.add(new Pharoah(6, 1));
        pharoah.add(new Pharoah(5, 1));
        pharoah.add(new Pharoah(4, 1));
        pharoah.add(new Pharoah(3, 1));
        pharoah.add(new Pharoah(1, 4));

        anubis.add(new Anubis(2, 6));
        anubis.add(new Anubis(7, 6));
        anubis.add(new Anubis(7, 7));
        anubis.add(new Anubis(7, 8));
        anubis.add(new Anubis(10, 1));

        elements.addAll(anubis);
        elements.addAll(pharoah);
        elements.addAll(cats);
        elements.add(door);
    }
}
