
package chapter4;

public class StudentTest {
    
    public static void main(String[] args) {
        Student student1 = new Student("Jane Green", 93.5);
        Student student2 = new Student("John Blue", 72.75);
    
        System.out.printf("%s's letter grade is: %s%n",student1.getName(),student1.getLetterGrade());
        System.out.printf("%s's letter grade is: %s%n",student2.getName(),student2.getLetterGrade());
        
        double[] arr = {67,78,89,67,87,98,93,85,82,100};
        double average = Student.classAverage(arr);
        
        System.out.println(average);

        Student.Analysis1();
    
    }
    
}
