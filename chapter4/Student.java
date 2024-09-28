
package chapter4;
import java.util.Scanner;


public class Student {

    private String name;
    private double average;
    static double average2;
    
    public Student(String name, double average) {
        this.name = name;
        if (average > 0.0) {
            if (average <= 100) {
                this.average = average;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAverage(double studentAverage) {
        if (average > 0.0) {
            if (average <= 100.0) {
                this.average = studentAverage;
            }
        }
    }

    public double getAverage() {
        return average;
    }

    public String getLetterGrade() 
    {
        String letterGrade = "";
        if (average >= 90.0) {
            letterGrade = "A";
        } else if (average >= 80.0) {
            letterGrade = "B";
        } else if (average >= 70.0) {
            letterGrade = "C";
        } else if (average >= 60.0) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        return letterGrade;
    }
    
    static double classAverage(double[] grades)
    {
        double total = 0;
        
        for(double grade : grades)
        {
            total += grade;
        }
        average2 = total/grades.length;
//        while(gradeCounter <= 10)
//        {
//            System.out.println("Enter Grade : ");
//            int grade = marks;
//        }
        return average2;
    }
    public static void Analysis1() 
    {
        Scanner input = new Scanner(System.in);
        int passes = 0;
        int failures = 0;
        int studentCounter = 1;

        while (studentCounter <= 10) {
            System.out.print("Enter result (1 = pass, 2 = fail): ");
            int result = input.nextInt();

            if (result == 1)
                passes++;
            else
                failures++;

            studentCounter++;
        }

        System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);

        if (passes > 8)
            System.out.println("Bonus to instructor!");
    }

}
