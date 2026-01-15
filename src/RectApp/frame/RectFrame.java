package RectApp.frame;

import RectApp.panel.RectPanel;

import javax.swing.*;

public class RectFrame extends JFrame {

    public RectFrame() {
        this.setTitle("Rectangles");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        RectPanel panel = new RectPanel();
        this.add(panel);
    }
}
