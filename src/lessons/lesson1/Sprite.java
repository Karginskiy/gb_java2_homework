package lessons.lesson1;

import java.awt.*;

abstract class Sprite {

    float x;
    float y;
    float halfWidth;
    float halfHeight;
    float vy;
    float vx;

    abstract public void update(float deltaTime);

    abstract public void render(Graphics g);

    float getLeft(){ return x - halfWidth; }

    void setLeft(float left){ x = left + halfWidth; }

    float getRight(){ return x + halfWidth; }

    void setRight(float right){ x = right - halfWidth;}

    float getTop(){ return y - halfHeight; }

    void setTop(float top){ y = top + halfHeight; }

    float getBottom(){ return y + halfHeight; }

    void setBottom(float bottom){ y = bottom - halfHeight; }

    float getWidth(){ return 2f * halfWidth; }

    float getHeight(){return 2f * halfHeight; }

    void revertVx() { this.vx = -this.vx; }

    void revertVy() { this.vy = -this.vy; }


}