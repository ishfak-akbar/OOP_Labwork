

import java.util.Scanner;

public class RestaurantManagementTest {
    public static void main(String[] args) {

        RestaurantManagement restaurant = new RestaurantManagement();
        
        Scanner input = new Scanner(System.in);
        restaurant.credits(1000);
        System.out.print("Enter email : ");
        String email = input.nextLine();
        System.out.print("Enter password : ");
        int password = input.nextInt();

        restaurant.loginPage(email, password);
        
        
        
        input.close();

    }

}
