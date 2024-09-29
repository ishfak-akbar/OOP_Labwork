
package OwnProject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class RestaurantManagementV3 extends JFrame {

    private static ArrayList<Order> customerOrders = new ArrayList<>(); // ArrayList to store orders
    private static double balance;
    private String password = "2314";
    private String email = "ishfak@gmail.com";

    public void loginPage(String email, String password) {
        if (email.equals(this.email) && (password == null ? this.password == null : password.equals(this.password))) {
            menu();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Email or Password!", "Warning", 0);
        }
    }

    public void credits(double amount) {
        this.balance = amount;
    }

    public static double spent(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient Money");
            return 0;

        }
        return balance;
    }

    public static void menu() {
        enum UserOption {
            MAIN_DISH, KEBAB, DESERT, EXIT;
        }
        String opt = JOptionPane.showInputDialog(null, """
                                                    What would you like to have today?

                                                    ----------MENU----------
                                                    1.Main Dish
                                                    2.Kebab
                                                    3.Coffee/Deserts
                                                    4.Exit

                                                    """, "Ishfak's Resturant & Cafe", 1);

        UserOption userOption;
        int userChoice;

        if (opt.matches("\\d+")) { // Check if opt contains only digits
            userChoice = Integer.parseInt(opt);
            userOption = UserOption.values()[userChoice - 1];
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Order. Please enter a number (1-3).");
            return;
        }

        switch (userOption) {
            case MAIN_DISH:
                String selectMain = JOptionPane.showInputDialog(null, """
                                                            ---------MAIN DISH---------
                                                            1.PERI PERI CHICKEN  --- TK 335.00
                                                            2.BEEF BBQ         --- TK 355.00
                                                            Please select a main dish : \n\n""");

                double price;
                if ("1".equals(selectMain)) {
                    spent(335.00);
                    price = 335.00;
                } else {
                    spent(355.00);
                    price = 355.00;
                }
                customerOrders.add(new Order(userOption.toString(),
                        ("1".equals(selectMain)) ? "PERI PERI CHICKEN" : "BEEF BBQ", price));
                menu();
                break;

            case KEBAB:
                String selectKebab = JOptionPane.showInputDialog(null, """
                                                            ---------KEBAB---------
                                                            1.TENGDI KEBAB  --- TK 325.00
                                                            2.RESHMI KEBAB  --- TK 255.00
                                                            Please select a kebab item : \n\n""");

                double price1;
                if ("1".equals(selectKebab)) {
                    spent(325.00);
                    price1 = 325.00;
                } else {
                    spent(255.00);
                    price1 = 255.00;
                }

                customerOrders.add(new Order(userOption.toString(),
                        ("1".equals(selectKebab)) ? "TENGDI KEBAB" : "RESHMI KEBAB", price1));
                menu();
                break;

            case DESERT:
                String selectDesert = JOptionPane.showInputDialog(null, """
                                                            ---------COFFEE/DESERTS---------
                                                            1.BLENDED OREO COLD --- TK 180.00
                                                            2.NUTELLA WAFFLE   --- TK 230.00
                                                            What would you like to have for deserts ? : \n\n""");

                double price2;
                if ("1".equals(selectDesert)) {
                    spent(180.00);
                    price2 = 180.0;
                } else {
                    spent(230.00);
                    price2 = 180.0;
                }

                customerOrders.add(new Order(userOption.toString(),
                        ("1".equals(selectDesert)) ? "BLENDED OREO COLD" : "NUTELLA WAFFLE", price2));
                menu();
                break;

            case EXIT:
                String optt = JOptionPane.showInputDialog(null, "Will that be all Sir/Ma'am?\n1.YES\n2.NO\n\n");
                if ("2".equals(optt)) {
                    menu();
                } else {
                    displayOrders();
                }
                
        }
//        String optt = JOptionPane.showInputDialog(null, "Will that be all Sir/Ma'am?\n1.YES\n2.NO\n\n");
//        if ("2".equals(optt)) {
//            menu();
//        } else {
//            displayOrders();
//        }
    }

    private static void displayOrders() {
        Collections.sort(customerOrders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                int categoryComparison = o2.getCategory().compareTo(o1.getCategory());
                if (categoryComparison != 0) {
                    return categoryComparison;
                }
                return Double.compare(o2.getPrice(), o1.getPrice());
            }
        });
        StringBuilder displayString = new StringBuilder();
        LocalDate curDate = LocalDate.now();
        String formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyy").format(curDate);
        
        displayString.append("Date : ");
        displayString.append(formattedDate);
        displayString.append("\n");

        displayString.append("\n        ----------------- RECEIPT -----------------\n");

        for (Order order : customerOrders) {
            displayString.append(order.toString()).append("\n");
        }

        displayString.append("\n        ------------------------------------------------\n");
        displayString.append("                   Total Amount: ").append(calculateTotal()).append(" TK\n\n");

        JOptionPane.showMessageDialog(null, displayString.toString(), "Receipt", -1);

    }

    private static double calculateTotal() {
        double total = 0.0;
        for (Order order : customerOrders) {
            total += order.getPrice();
        }
        return total;

    }

}

class Order {

    private String category;
    private String item;
    private double price;

    public Order(String category, String item, double price) {
        this.category = category;
        this.item = item;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %s - %.2f TK", category, item, price);
    }
}
