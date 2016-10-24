package lessons.lesson1;

import java.awt.*;

abstract class Sprite {

    protected GameCanvas gameCanvas;
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    public Sprite(GameCanvas gameCanvas){
        this.gameCanvas = gameCanvas;
    }

    public float getLeft(){ return x - halfWidth; }

    public void setLeft(float left){ x = left + halfWidth; }

    public float getRight(){ return x + halfWidth; }

    public void setRight(float right){ x = right - halfWidth;}

    public float getTop(){ return y - halfHeight; }

    public void setTop(float top){ y = top + halfHeight; }

    public float getBottom(){ return y + halfHeight; }

    public void setBottom(float bottom){ y = bottom - halfHeight; }

    public float getWidth(){ return 2f * halfWidth; }

    public float getHeight(){return 2f * halfHeight; }

    abstract public void update(float deltaTime);

    abstract public void render(Graphics g);
}