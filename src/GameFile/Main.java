package GameFile;

import GameFile.GameView.DisasterView;
import GameFile.GameView.GameView;
import GameFile.GameView.RedSeaGameView;
import GameFile.GameView.TenComandmentsView;
import GameFile.Sprite.Moses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {
    public static final int CELL = 50;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static final int ROW = HEIGHT / CELL;
    public static final int COL = WIDTH / CELL;
    private int level;

    Moses moses;
    public static GameView gameView;

    public Main() {
        level = 1;
        resetGame(new DisasterView());
        addKeyListener(this);
    }

    public void resetGame(GameView view) {
        moses = new Moses(1, 1);
        gameView = view;
        repaint();
    }

    private boolean changeLevel(String result) {
        if (result.equals("Next Level")) {
            level++;
            if (level == 2) {
                resetGame(new RedSeaGameView());
            } else if (level == 3) {
                resetGame(new TenComandmentsView());
            }
            return true;
        }
        return false;
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIDTH, HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        gameView.drawView(g);
        moses.draw(g);

        requestFocusInWindow();
    }

    // KeyListener
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //--------- Moses moving feature ---------//
        Point mosesPoint = moses.getRelativePosition();
        // check moses position
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (mosesPoint.y > 1) {
                    String result = moses.overlap(mosesPoint.x, mosesPoint.y - 1);
                    if (result.equals("Die")) {
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You died. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.y --;
                    }

                    // Check Game Over
                    if (result.equals("Game Over")) {
                        JOptionPane.showMessageDialog(this, "You Won !");
                        return;
                    }

                    // check door hit
                    if (changeLevel(result)) {
                        return;
                    }
                }
                break;
            case KeyEvent.VK_DOWN:
                if (mosesPoint.y < 10) {
                    String result = moses.overlap(mosesPoint.x, mosesPoint.y + 1);
                    if (result.equals("Die")) {
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You died. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.y ++;
                    }

                    // Check Game Over
                    if (result.equals("Game Over")) {
                        JOptionPane.showMessageDialog(this, "You Won !");
                        return;
                    }

                    // check door hit
                    if (changeLevel(result)) {
                        return;
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                if (mosesPoint.x > 1) {
                    String result = moses.overlap(mosesPoint.x - 1, mosesPoint.y);
                    if (result.equals("Die")) {
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You died. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.x --;
                    }

                    // Check Game Over
                    if (result.equals("Game Over")) {
                        JOptionPane.showMessageDialog(this, "You Won !");
                        return;
                    }

                    // check door hit
                    if (changeLevel(result)) {
                        return;
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (mosesPoint.x < 10) {
                    String result = moses.overlap(mosesPoint.x + 1, mosesPoint.y);
                    if (result.equals("Die")) {
                        level = 1;
                        JOptionPane.showMessageDialog(this, "You died. Please try again.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if (!result.equals("Cannot move")) {
                        mosesPoint.x ++;
                    }

                    // Check Game Over
                    if (result.equals("Game Over")) {
                        JOptionPane.showMessageDialog(this, "You Won !");
                        return;
                    }

                    // check door hit
                    if (changeLevel(result)) {
                        return;
                    }
                }
                break;
        }
        moses.setPosition(mosesPoint);

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
    }
}
