package lessons.lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCircles extends JFrame {

    public static void main(String[] args) {
        new GameCircles();
    }

    private GameCircles(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(600, 200);
        setSize(800, 600);
        setResizable(false);
        setTitle("Кружки");
        add(new GameCanvas(), BorderLayout.CENTER);
        setVisible(true);
    }

}
