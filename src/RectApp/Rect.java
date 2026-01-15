package RectApp;

import RectApp.panel.RectPanel;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Rect implements Runnable{
    private Rectangle2D rect; //prostokąt
    private double x,y,w,h; //dane do mojego prostokąta
    private RectPanel panel; //żeby mieć szerokość i wysokość panelu, móc go odświeżać
    private boolean canMove = true; //do metody run

    //tutaj używam tylko po to, żeby mieć losowe kolory
    private Random rand = new Random();
    private Color color;

    public Rect(double x, double y, double w, double h, RectPanel panel) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.panel = panel;

        rect = new Rectangle2D.Double(x,y,w,h);
        color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));

    }

    //metoda do rysowania prostokąta
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        rect.setFrame(x,y,w,h);
        g2d.setColor(color);
        g2d.fill(rect);
    }

    //metoda do "poruszania" się moich wątków
    private void move(){
        x++;
        //krawędź okna
        if(x>= panel.getWidth() - w){ //odejmuje szerokość prostokątu, żeby nie mógł mi wyjechać poza framke
            x=0;
        }
    }
    @Override
    public void run() {
        while(canMove){
            try{
                move();
                Thread.sleep(20);
            } catch (InterruptedException e){
                canMove = false;
                e.printStackTrace();
            }
            panel.repaint();
        }

    }
}
