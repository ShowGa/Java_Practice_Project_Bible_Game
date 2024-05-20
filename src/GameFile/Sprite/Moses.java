package GameFile.Sprite;

import GameFile.GameView.DisasterView;
import GameFile.GameView.RedSeaGameView;
import GameFile.GameView.TenComandmentsView;
import GameFile.Main;
import GameFile.Sprite.DisasterViewSprite.Bug;
import GameFile.Sprite.DisasterViewSprite.Frog;
import GameFile.Sprite.DisasterViewSprite.Ice;
import GameFile.Sprite.DisasterViewSprite.Tombstone;
import GameFile.Sprite.RedSeaViewSprite.Anubis;
import GameFile.Sprite.RedSeaViewSprite.Cat;
import GameFile.Sprite.RedSeaViewSprite.Pharoah;
import GameFile.Sprite.TenComandmentSprite.TenComandment;

import javax.swing.*;
import java.util.ArrayList;

public class Moses extends Sprite {
    public Moses(int x, int y) {
        setPosition(x, y);
        img = new ImageIcon("Moses.png");
    }


    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof DisasterView) {
            // check "Die"
            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            for (Frog f : frogs) {
                if (f.getRelativePosition() != null && x == f.getRelativePosition().x && y == f.getRelativePosition().y) {
                    return "Die";
                }
            }

            for (Bug b : bugs) {
                if (b.getRelativePosition() != null && x == b.getRelativePosition().x && y == b.getRelativePosition().y) {
                    return "Die";
                }
            }

            // check
            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIces();
            ArrayList<Tombstone> tombstones = ((DisasterView) Main.gameView).getTombstones();
            for (Ice i : ices) {
                if (i.getRelativePosition() != null && x == i.getRelativePosition().x && y == i.getRelativePosition().y) {
                    return "Cannot move";
                }
            }
            for (Tombstone t : tombstones) {
                if (t.getRelativePosition() != null && x == t.getRelativePosition().x && y == t.getRelativePosition().y) {
                    return "Cannot move";
                }
            }

            // check if level up (hit door)
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y) {
                return "Next Level";
            }
        } else if (Main.gameView instanceof RedSeaGameView) {
            ArrayList<Cat> cats = ((RedSeaGameView) Main.gameView).getCats();
            ArrayList<Anubis> anubis = ((RedSeaGameView) Main.gameView).getAnubis();
            ArrayList<Pharoah> pharoah = ((RedSeaGameView) Main.gameView).getPharoah();
            for (Cat c : cats) {
                if (c.getRelativePosition() != null && x == c.getRelativePosition().x && y == c.getRelativePosition().y) {
                    return "Cannot move";
                }
            }

            for (Anubis a : anubis) {
                if (a.getRelativePosition() != null && x == a.getRelativePosition().x && y == a.getRelativePosition().y) {
                    return "Die";
                }
            }
            for (Pharoah p : pharoah) {
                if (p.getRelativePosition() != null && x == p.getRelativePosition().x && y == p.getRelativePosition().y) {
                    return "Die";
                }
            }

            // check if level up (hit door)
            Door door = Main.gameView.getDoor();
            if (x == door.getRelativePosition().x && y == door.getRelativePosition().y) {
                return "Next Level";
            }
        } else if (Main.gameView instanceof TenComandmentsView){
            TenComandment stone = ((TenComandmentsView) Main.gameView).getStone();
            if (x == stone.getRelativePosition().x && y == stone.getRelativePosition().y) {
                return "Game Over";
            }
        }
        return "none";
    }
}
