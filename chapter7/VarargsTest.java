
package chapter7;


//7.20
public class VarargsTest {
    public static double average(double... numbers)
    {
        double total = 0.0;
        for(double d:numbers)
        {
            total+=d;
        }
        return total/numbers.length;
    }
    
    public static void main(String[] args) {
        double d1 = 10.0;
        double d2 = 20.0;
        double d3 = 30.0;
        double d4 = 40.0;
        System.out.println("d1 = "+d1);
        System.out.println("d2 = "+d2);
        System.out.println("d3 = "+d3);
        System.out.println("d4 = "+d4);
        
        System.out.println("Average of d1,d2 = "+average(d1,d2));
        System.out.println("Average of d1,d2,d3 = "+average(d1,d2,d3));
        System.out.println("Average of d1,d2,d3,d4 = "+average(d1,d2,d3,d4));
        
    }
}

