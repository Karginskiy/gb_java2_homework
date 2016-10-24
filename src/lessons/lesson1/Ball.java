package lessons.lesson1;

import java.awt.*;
import java.util.Random;

class Ball extends Sprite {

    private Color color = new Color((int)(Math.random() * 255f), (int)(Math.random() * 255f), (int)(Math.random() * 255f));
    private Random random = new Random();

    Ball(float x, float y) {
        this();
        this.x = x;
        this.y = y;
    }

    Ball() {
        halfHeight = 20 + (float)(Math.random() * 50f);
        //noinspection SuspiciousNameCombination
        halfWidth = halfHeight;
        vy = 150 + (float)(Math.random() * 200f) * ((float) random.nextInt(2) - 1);
        vx = 150 + (float)(Math.random() * 200f) * ((float) random.nextInt(2) - 1);
    }

    @Override
    public void update(float deltaTime) {
        x += vx * deltaTime;
        y += vy * deltaTime;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(), (int) getWidth(), (int) getHeight());
    }
}