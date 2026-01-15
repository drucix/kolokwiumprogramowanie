package RectApp;

import RectApp.frame.RectFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try{
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new RectFrame().setVisible(true);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
