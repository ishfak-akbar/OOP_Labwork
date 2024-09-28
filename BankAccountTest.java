
import java.util.Scanner;
public class BankAccountTest {
    public static void main(String[] args) {
        
        System.out.println("Create Account");
        System.out.println("--------------");
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String name = input.nextLine();
        System.out.print("Enter an Id : ");
        String id = input.nextLine();
        
        BankAccount account1 = new BankAccount(name,id);
        
        account1.menu();
        
    }
}

