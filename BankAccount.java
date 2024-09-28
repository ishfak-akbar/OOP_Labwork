
import java.util.Scanner;
public class BankAccount {
    
    private double balance; 
    private String accountName;
    private String accountId;
    
    public BankAccount(String accountName, String accountId)
    {
        this.accountName = accountName;
        this.accountId = accountId;
    }
    
    public void deposit(double amount)
    {
        if(amount!=0)
        {
            balance += amount;  
        }
    }
    
    public void withdraw(double amount)
    {
        if(amount>0)
        {
            balance -= amount;   
        }
    }
    
    public void menu()
    {
        int opt = '\n';
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome "+accountName);
        System.out.println("Id : "+accountId+"\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        
        //opt = input.next().charAt(0);
        while(opt != 4)
        {
            System.out.print("Enter option : ");
            opt = input.nextInt();
            
            switch(opt)
            {
                case 1:
                    System.out.println("Balance : "+balance+"\n");
                    break;
                case 2:
                    System.out.println("Enter deposit amount : ");
                    double amount = input.nextDouble();
                    deposit(amount);
                    System.out.println("Tk. "+amount+" has been deposited in your account.");
                    System.out.println("Your new balance is : "+balance);
                    break;
                
                case 3:
                    System.out.println("Enter withdraw amount : ");
                    double amount2 = input.nextDouble();
                    withdraw(amount2);
                    System.out.println("Tk. "+amount2+" has been withdrawn from your account.");
                    System.out.println("Your new balance is : "+balance);
                    break;
                
                case 4:
                    System.out.println("Process Terminated");
                    break;
                
                default :
                    System.out.println("Please enter a valid option!");
            }
            
        }
        
    }
    
   
}

