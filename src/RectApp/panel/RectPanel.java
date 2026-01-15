package RectApp.panel;

import RectApp.Rect;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class RectPanel extends JPanel implements MouseListener {
    private double xf,xs,yf,ys; //współrzędne przyciśnięcia myszki
    private Rect rectangle; //do moich prostokątów
    private List<Rect> threadList = new ArrayList<>(); //lista moich wątków

    public RectPanel() {
        //to jest tutaj chyba zbędne, ale wolę dodać
        this.setFocusable(true);
        this.requestFocusInWindow();

        this.addMouseListener(this); //żeby mój panel "słuchał" myszki
    }

    //współrzędne pierwszego naciśnięcia
    @Override
    public void mousePressed(MouseEvent e) {
        xf = e.getX();
        yf = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //współrzędne "puszczenia" naciśnięcia
        xs = e.getX();
        ys = e.getY();

        //dane do mojego prostokąta
        double x = Math.min(xf,xs);
        double y = Math.min(yf,ys);
        double width = Math.abs(xs-xf);
        double height = Math.abs(ys-yf);

        rectangle = new Rect(x,y,width,height,this);
        createThread(rectangle);

        repaint();
    }

    //metoda pomocnicza do tworzenia nowych wątków
    private void createThread(Rect r){
        threadList.add(r);
        new Thread(r).start();
    }

    //metoda do rysowania moich prostokątów (wywołuje mi metode z Rect)
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for(Rect r:threadList){
            r.draw(g);
        }
    }


    //niepotrzebne metody do tego zadania, ale muszą być, bo implementuje MouseListener
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }


}
