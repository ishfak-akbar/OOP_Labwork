
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RestaurantManagement 
{
    private static ArrayList<Order> customerOrders = new ArrayList<>(); // ArrayList to store orders
    private static double balance;
    private int password = 2314;
    private String email = "ishfak@gmail.com";

    public void loginPage(String email, int password)
    {
        if (email.equals(this.email) && password == this.password)
        {
            System.out.println("Welcome to Ishfak's Resturant & Cafe\nWhat would you like to have today?");
            menu();
        }
        else 
        {
            System.out.println("Incorrect Email or Password !");
        }
    }

    public void credits(double amount)
    {
        this.balance = amount;
    }

    public static double spent(double amount)
    {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount;
        } 
        else 
        {
            System.out.println("Insufficient Balance");
            return 0;

        }
        return balance;
    }

    public static void menu()
    {
        int opt = '\n';
        Scanner input = new Scanner(System.in);

        enum UserOption {
            MAIN_DISH, KEBAB, COFFEE_DESERT
        }
        
        System.out.println("----------MENU----------");
        System.out.println("1.Main Dish");
        System.out.println("2.Kebab");
        System.out.println("3.Coffee/Deserts");
        System.out.print("Enter option : ");
        
        opt = input.nextInt()-1;
        
        UserOption userOption;
        userOption = UserOption.values()[opt];
        
        switch (userOption)
        {
            case MAIN_DISH:
                System.out.println("---------MAIN DISH---------");
                System.out.println("1.PERI PERI CHICKEN       --- TK 335.00");
                System.out.println("2.BEEF BBQ                --- TK 355.00");
                System.out.print("Please select a main dish : ");

                int selectMain = input.nextInt();
                double price = 0;
                if (selectMain == 1) 
                {
                    spent(335.00);
                    price = 335.00;
                }
                else 
                {
                    spent(355.00);
                    price = 355.00;
                }
                customerOrders.add(new Order("Main Dish",
                        (selectMain == 1) ? "PERI PERI CHICKEN" : "BEEF BBQ", price));

                break;

            case KEBAB:
                System.out.println("---------KEBAB---------");
                System.out.println("1.TENGDI KEBAB  --- TK 325.00");
                System.out.println("2.RESHMI KEBAB  --- TK 255.00");
                System.out.print("Please select a kebab item : ");
                
                int selectKebab = input.nextInt();
                double price1 = 0;
                if (selectKebab == 1) 
                {
                    spent(325.00);
                    price1 = 325.00;
                } 
                else 
                {
                    spent(255.00);
                    price1 = 255.00;
                }

                customerOrders.add(new Order("Kebab", (selectKebab == 1) ? "TENGDI KEBAB" : "RESHMI KEBAB", price1));

                break;

            case COFFEE_DESERT:
                System.out.println("---------COFFEE/DESERTS---------");
                System.out.println("1.BLENDED OREO COLD --- TK 180.00");
                System.out.println("2.NUTELLA WAFFLE    --- TK 230.00");
                System.out.print("What would you like to have for deserts ? : ");

                int selectDesert = input.nextInt();
                double price2 = 0;
                if (selectDesert == 1)
                {
                    spent(180.00);
                    price2 = 180.0;
                } 
                else 
                {
                    spent(230.00);
                    price2 = 180.0;
                }
                customerOrders.add(new Order("Dessert", (selectDesert == 1) ? "BLENDED OREO COLD" : "NUTELLA WAFFLE", price2));
                break;

            default:
                System.out.println("Invalid Order");
        }
        System.out.println("Will that be all Sir/Ma'am?\n1.YES\n2.NO");
        int optt;
        optt = input.nextInt();
        if (optt == 2) 
        {
            menu();
        } 
        else 
        {
            displayOrders();
        }

    }

    private static void displayOrders() {
        System.out.println("\n-----------RECIEPT-----------:");
        
        Collections.sort(customerOrders, new Comparator<Order>() 
        {
            @Override
            public int compare(Order o1, Order o2) 
            {
                int categoryComparison = o2.getCategory().compareTo(o1.getCategory());
                if (categoryComparison != 0) 
                {
                    return categoryComparison;
                }
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        
        for (Order order : customerOrders)
        {
            System.out.println(order.toString());
        }
        System.out.println("-----------------------------");
        System.out.println("Total Amount : " + calculateTotal() + " TK");
    }

    private static double calculateTotal()
    {
        double total = 0.0;
        for (Order order : customerOrders)
        {
            total += order.getPrice();
        }
        return total;
    }

}

class Order {

    private String category;
    private String item;
    private double price;

    public Order(String category, String item, double price) 
    {
        this.category = category;
        this.item = item;
        this.price = price;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public double getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return String.format("%s: %s - %.2f TK", category, item, price);
    }
}
