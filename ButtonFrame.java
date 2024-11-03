//12.15
package chapter12;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ButtonFrame extends JFrame{
    
    private final JButton plainButton;
    private final JButton fancyButton;
    
    public ButtonFrame()
    {
        super("Testing Buttons");
        setLayout(new FlowLayout());
        
        plainButton = new JButton("PlainButton");
        add(plainButton);
        
        Icon pic1 = new ImageIcon("C:/Users/ishfa/OneDrive/Documents/NetBeansProjects/OOPHomework/src/main/java/chapter12/burger1.png");
        Icon pic2 = new ImageIcon("C:/Users/ishfa/OneDrive/Documents/NetBeansProjects/OOPHomework/src/main/java/chapter12/burger2.png");
        fancyButton = new JButton("Fancy Button", pic1); // set image
        fancyButton.setRolloverIcon(pic2); // set rollover image
        add(fancyButton);
        
        ButtonHandler handler = new ButtonHandler(); 
        fancyButton.addActionListener(handler); 
        plainButton.addActionListener(handler);
           
    }
    
    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {      
            JOptionPane.showMessageDialog(ButtonFrame.this , 
                    String.format("You pressed: %s",event.getActionCommand()));
        }
    }
}
