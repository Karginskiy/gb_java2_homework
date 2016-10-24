package lessons.lesson1;

import javax.swing.*;
import java.awt.*;

class GameCanvas extends JPanel {

    private final GameCircles gameCircles;
    private long lastFrameTime;

    GameCanvas(GameCircles gameCircles){
        this.gameCircles = gameCircles;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        lastFrameTime = currentTime;

        gameCircles.onRepaint(g, deltaTime);

        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }

    int getLeft(){ return 0; }
    int getRight(){ return getWidth() - 1; }
    int getTop(){ return 0; }
    int getBottom(){ return getHeight() - 1; }
}