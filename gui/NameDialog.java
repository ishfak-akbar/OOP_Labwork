
//3.13
package gui;

import javax.swing.JOptionPane;
public class NameDialog {
    public static void main(String[] args) {
        
        String name = JOptionPane.showInputDialog("What is your name?");
        
        String message = String.format("Welcome "+name+", to JAVA Programming");
        
        JOptionPane.showMessageDialog(null,message);
    }
}
