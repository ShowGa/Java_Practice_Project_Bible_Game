package GameFile.Sprite;

import GameFile.GameView.DisasterView;
import GameFile.Main;
import GameFile.Sprite.DisasterViewSprite.Bug;
import GameFile.Sprite.DisasterViewSprite.Frog;
import GameFile.Sprite.DisasterViewSprite.Ice;
import GameFile.Sprite.DisasterViewSprite.Tombstone;

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
        }
        return "none";
    }
}
