
//5.18
package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShapesTest {
    
    public static void main(String[] args) {
        
        String input = JOptionPane.showInputDialog("Enter 1 for Rectangles\nEnter 2 for ovals");
        
        int choice = Integer.parseInt(input);
        
        Shapes panel = new Shapes(choice);
        
        JFrame application = new JFrame();
        
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel); 
        application.setSize(300, 300); 
        application.setVisible(true);
        
    }
    
}
