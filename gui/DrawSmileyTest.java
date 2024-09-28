
//6.12
package gui;

import javax.swing.JFrame;

public class DrawSmileyTest {
    public static void main(String[] args) {
        
        DrawSmily panel = new DrawSmily();
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(230,250);
        application.setVisible(true);
        
    }
}
