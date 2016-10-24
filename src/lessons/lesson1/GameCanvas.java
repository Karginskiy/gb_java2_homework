package lessons.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

class GameCanvas extends JPanel {

    private long lastFrameTime;
    private final ArrayList<Sprite> sprites = new ArrayList<>();

    GameCanvas() {
        lastFrameTime = System.nanoTime();
        this.addMouseListener(new CustomMouseListener());
        this.add(new Ball());
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        onRepaint(g, deltaTime);

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    private void add(Sprite sprite) {
        this.sprites.add(sprite);
    }

    private void onRepaint(Graphics g, float deltaTime){
        update(deltaTime);
        render(g);
    }

    private int getLeft(){ return 0; }
    private int getRight(){ return getWidth() - 1; }
    private int getTop(){ return 0; }
    private int getBottom(){ return getHeight() - 1; }

    private void update(float deltaTime){
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).update(deltaTime);
            reflectFromBorders(sprites.get(i));
        }
    }

    private void render(Graphics g){
        for (int i = 0; i < sprites.size(); i++) {
            sprites.get(i).render(g);
        }
    }

    private void reflectFromBorders(Sprite sprite) {
         if(sprite.getLeft() < getLeft()){
             sprite.setLeft(getLeft());
             sprite.revertVx();
         }

        if(sprite.getRight() > getRight()){
            sprite.setRight(getRight());
            sprite.revertVx();
        }

        if(sprite.getTop() < getTop()){
            sprite.setTop(getTop());
            sprite.revertVy();
        }

        if(sprite.getBottom() > getBottom()){
           sprite.setBottom(getBottom());
           sprite.revertVy();
        }
    }

    private class CustomMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            GameCanvas.this.add(new Ball(e.getX(), e.getY()));
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}