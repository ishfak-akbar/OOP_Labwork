
package OwnProject;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RestaurantManagementTest2{
    public static void main(String[] args) {

        RestaurantManagement2 restaurant = new RestaurantManagement2();
        restaurant.credits(5000);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        
        JLabel emailLabel = new JLabel("Enter Email: ");
        JTextField emailField = new JTextField(20);
        loginPanel.add(emailLabel);
        loginPanel.add(emailField);

        // Add label and text field for password (using JPasswordField for password masking)
        JLabel passwordLabel = new JLabel("Enter Password: ");
        JPasswordField passwordField = new JPasswordField(20);
        // Set echoChar to mask password characters with an asterisk (*)
        passwordField.setEchoChar('*');
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        // Show the login dialog and retrieve user input
        int result = JOptionPane.showConfirmDialog(null, loginPanel, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION){
            String email = emailField.getText();
            String password = new String(passwordField.getPassword()); // Convert char array to String
            restaurant.loginPage(email, password);
        } 
        else {
            System.exit(0); // Exit if user cancels login
        }
        
    

    }

}
