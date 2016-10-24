package lessons.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameCircles extends JFrame {

    public static void main(String[] args) {
        new GameCircles();
    }

    private GameCanvas gameCanvas;
    private final ArrayList<Ball> balls = new ArrayList<>();

    private GameCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600, 200);
        setSize(800, 600);
        setResizable(false);
        setTitle("Кружки");
        gameCanvas = new GameCanvas(this);
        add(gameCanvas, BorderLayout.CENTER);
        setVisible(true);
    }

    void onRepaint(Graphics g, float deltaTime){
        update(deltaTime);
        render(g);
    }

    private void update(float deltaTime){
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).update(deltaTime);
        }
    }

    private void render(Graphics g){
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).render(g);
        }
    }

    private class CustomListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            GameCircles.this.balls.add(new Ball(gameCanvas));
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         *
         * @param e
         */
        @Override
        public void mousePressed(MouseEvent e) {

        }

        /**
         * Invoked when a mouse button has been released on a component.
         *
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {

        }

        /**
         * Invoked when the mouse enters a component.
         *
         * @param e
         */
        @Override
        public void mouseEntered(MouseEvent e) {

        }

        /**
         * Invoked when the mouse exits a component.
         *
         * @param e
         */
        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
