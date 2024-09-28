
package chapter4;

import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int total = 0;
        int gradeCounter = 0;
        
        while(gradeCounter<10)
        {
            System.out.println("Enter Grade : ");
            int grade = input.nextInt();
            total += grade;
            gradeCounter++;
        }
        int average = total/10;
        
        System.out.println("Total : "+total);
        System.out.println("Average : "+average);
        
    }
}


