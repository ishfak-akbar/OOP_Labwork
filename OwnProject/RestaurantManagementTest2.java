
package OwnProject;

import javax.swing.JOptionPane;

public class RestaurantManagementTest2{
    public static void main(String[] args) {

        RestaurantManagement2 restaurant = new RestaurantManagement2();
        
        restaurant.credits(5000);
        
        String email = JOptionPane.showInputDialog(null,"Enter Email : ");
        String password = JOptionPane.showInputDialog(null,"Enter Password : ");
             
        restaurant.loginPage(email, password);
        
    

    }

}
