package lessons.lesson1;

import java.awt.*;

class Ball extends Sprite {

    private float vx;
    private float vy;
    private Color color = new Color((int)(Math.random() * 255f), (int)(Math.random() * 255f), (int)(Math.random() * 255f));

    Ball(GameCanvas gameCanvas) {
        super(gameCanvas);
        halfHeight = 20 + (float)(Math.random() * 50f);
        //noinspection SuspiciousNameCombination
        halfWidth = halfHeight;
    }

    @Override
    public void update(float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;
        if(getLeft() < gameCanvas.getLeft()){
            setLeft(gameCanvas.getLeft());
            vx = -vx;
        }

        if(getRight() > gameCanvas.getRight()){
            setRight(gameCanvas.getRight());
            vx = -vx;
        }

        if(getTop() < gameCanvas.getTop()){
            setTop(gameCanvas.getTop());
            vy = -vy;
        }

        if(getBottom() > gameCanvas.getBottom()){
            setBottom(gameCanvas.getBottom());
            vy = -vy;
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}